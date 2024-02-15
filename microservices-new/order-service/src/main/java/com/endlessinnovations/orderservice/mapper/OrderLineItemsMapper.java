package com.endlessinnovations.orderservice.mapper;

import com.endlessinnovations.orderservice.dto.OrderLineItemsDTO;
import com.endlessinnovations.orderservice.model.OrderLineItems;
import org.mapstruct.Mapper;

@Mapper
public interface OrderLineItemsMapper {
    OrderLineItems orderLineItemsDTOToOrderLineItems(OrderLineItemsDTO orderLineItems);
    OrderLineItemsDTO orderLineItemsToOrderLineItemsDTO(OrderLineItems orderLineItems);

}
