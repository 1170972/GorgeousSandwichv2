package pt.isep.arqsoft.GorgeousSandwich.dto.order;

import java.util.TreeSet;
import pt.isep.arqsoft.GorgeousSandwich.domain.order.*;
import pt.isep.arqsoft.GorgeousSandwich.domain.sandwich.SandwichID;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.springframework.stereotype.Service;
import pt.isep.arqsoft.GorgeousSandwich.domain.shared.UserEmail;

@Service
public class OrderConverter {

    public static OrderDTO convertToDTO(Order order){
        DeliveryTime deliveryTime = order.obtainDeliveryTime();
        if(order.obtainOrderId() == null){
            return new OrderDTO(order.obtainOrderStatus().obtainName(),new DeliveryTimeDTO(deliveryTime.obtainStartTime().toString(),
                    deliveryTime.obtainEndTime().toString()),
                    order.obtainDeliveryDate().toString(),
                    order.obtainOrderDate().toString(), convertOrderItemsListToDTO(order.obtainOrderItems()),order.obtainUserEmail().obtainName());
        }
        return new OrderDTO(order.obtainOrderId().obtainID(), order.obtainOrderStatus().obtainName(),
                new DeliveryTimeDTO(deliveryTime.obtainStartTime().toString(),
                        deliveryTime.obtainEndTime().toString()), order.obtainDeliveryDate().toString(),
                        order.obtainOrderDate().toString(), convertOrderItemsListToDTO(order.obtainOrderItems()),order.obtainUserEmail().obtainName());
    }

    public static Order convertFromDTO(OrderDTO orderDTO){
        DeliveryTimeDTO deliveryTimeDTO = orderDTO.obtainDeliveryTime();
        if(orderDTO.obtainOrderId()==null){
            return new Order(OrderStatus.valueOf(orderDTO.obtainOrderStatus()),
                    DeliveryTime.valueOf(LocalTime.parse(deliveryTimeDTO.obtainStartTime()), LocalTime.parse(deliveryTimeDTO.obtainEndTime())),
                    DeliveryDate.valueOf(LocalDate.parse(orderDTO.obtainDeliveryDate())),
                    OrderDate.valueOf(LocalDate.parse(orderDTO.obtainOrderDate())), convertOrderItemsListFromDTO(orderDTO.obtainOrderItems()), UserEmail.valueOf(orderDTO.obtainEmail()));
        }
        return new Order(OrderStatus.valueOf(orderDTO.obtainOrderStatus()),
                DeliveryTime.valueOf(LocalTime.parse(deliveryTimeDTO.obtainStartTime()), LocalTime.parse(deliveryTimeDTO.obtainEndTime())),
                DeliveryDate.valueOf(LocalDate.parse(orderDTO.obtainDeliveryDate())),
                OrderDate.valueOf(LocalDate.parse(orderDTO.obtainOrderDate())),OrderID.valueOf(orderDTO.obtainOrderId()), convertOrderItemsListFromDTO(orderDTO.obtainOrderItems()),UserEmail.valueOf(orderDTO.obtainEmail()));
    }

    public static OrderItemDTO convertOrderItemToDTO(OrderItem orderItem){
        return new OrderItemDTO(orderItem.obtainSandwichId().obtainID(), orderItem.obtainQuantity().obtainUnits());
    }

    public static OrderItem convertOrderItemFromDTO(OrderItemDTO orderItemDTO){
        return OrderItem.valueOf(SandwichID.valueOf(orderItemDTO.obtainSandwichId()), Quantity.valueOf(orderItemDTO.obtainQuantity()));
    }

    public static Set<OrderItemDTO> convertOrderItemsListToDTO(Set<OrderItem> orderItems){
        Set<OrderItemDTO> orderItemsDTO = new TreeSet<>();
        for (OrderItem o : orderItems){
            orderItemsDTO.add(convertOrderItemToDTO(o));
        }
        return orderItemsDTO;
    }

    public static Set<OrderItem> convertOrderItemsListFromDTO(Set<OrderItemDTO> orderItemsDTO){
        Set<OrderItem> orderItems = new TreeSet<>();
        for (OrderItemDTO o : orderItemsDTO){
            orderItems.add(convertOrderItemFromDTO(o));
        }
        return orderItems;
    }

    public static List<OrderDTO> convertListToDTO(List<Order> orderList){
        List<OrderDTO> orderDTOList = new ArrayList<>();
        for (Order o : orderList){
            orderDTOList.add(convertToDTO(o));
        }
        return orderDTOList;
    }

}
