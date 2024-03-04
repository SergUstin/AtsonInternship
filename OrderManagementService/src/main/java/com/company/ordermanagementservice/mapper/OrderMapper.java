package com.company.ordermanagementservice.mapper;

import com.company.ordermanagementservice.dto.OrderDTO;
import com.company.ordermanagementservice.model.Order;
import com.company.ordermanagementservice.model.OrderItem;
import com.company.ordermanagementservice.model.PaymentStatus;
import com.company.ordermanagementservice.model.ShipmentStatus;
import com.company.ordermanagementservice.dto.OrderItemDTO;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getUserId());
        dto.setItemsId(order.getItemsId());
        dto.setPaymentStatus(order.getPaymentStatus().name());
        dto.setShipmentStatus(order.getShipmentStatus().name());
        return dto;
    }

    public Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setUserId(dto.getUserId());
        order.setItemsId(dto.getItemsId());
        order.setShipmentStatus(ShipmentStatus.valueOf(dto.getShipmentStatus()));
        order.setPaymentStatus(PaymentStatus.valueOf(dto.getPaymentStatus()));
        return order;
    }

    public OrderItem toEntity(OrderItemDTO dto) {
        OrderItem item = new OrderItem();
        item.setId(dto.getId());
        item.setItemName(dto.getItemName());
        item.setQuantity(dto.getQuantity());
        return item;
    }

    public OrderItemDTO toDTO(OrderItem item) {
        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(item.getId());
        dto.setItemName(item.getItemName());
        dto.setQuantity(item.getQuantity());
        return dto;
    }
}
