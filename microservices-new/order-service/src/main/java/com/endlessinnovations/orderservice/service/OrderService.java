package com.endlessinnovations.orderservice.service;

import com.endlessinnovations.orderservice.dto.OrderRequest;
import com.endlessinnovations.orderservice.mapper.OrderLineItemsMapper;
import com.endlessinnovations.orderservice.mapper.OrderMapper;
import com.endlessinnovations.orderservice.model.Order;
import com.endlessinnovations.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.endlessinnovations.orderservice.dto.OrderResponse;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {


    private final OrderMapper orderMapper;
    private final OrderLineItemsMapper orderLineItemsMapper;
    private final OrderRepository orderRepository;

//    @Override
//    public List<BeerDTO> listBeers() {
//        return beerRepository.findAll()
//                .stream()
//                .map(beerMapper::beerToBeerDTO)
//                .collect(Collectors.toList());

    public OrderResponse placeOrder(OrderRequest orderRequest) {

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        order.setOrderLineItemsList(orderRequest.getOrderLineItemsDTOList().stream()
                .map(orderLineItemsMapper::orderLineItemsDTOToOrderLineItems)
                .collect(Collectors.toList()));




        Order savedOrder = orderRepository.save(order);
        return orderMapper.orderToOrderDTO(savedOrder);
    }

}
