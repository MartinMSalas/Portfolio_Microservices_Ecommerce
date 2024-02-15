package com.endlessinnovations.orderservice.mapper;

import com.endlessinnovations.orderservice.dto.OrderRequest;
import com.endlessinnovations.orderservice.dto.OrderResponse;
import com.endlessinnovations.orderservice.model.Order;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {
    OrderResponse orderToOrderDTO(Order order);
    Order orderDTOToOrder(OrderRequest orderDTO);


}

