package pt.isep.arqsoft.GorgeousSandwich.dto.order;

import java.util.Set;

public class OrderDTO implements Comparable<OrderDTO>{

    private Long orderId;
    
    private String orderStatus;
    
    private DeliveryTimeDTO deliveryTime;
    
    private String deliveryDate;
    
    private String orderDate;
    
    private Set<OrderItemDTO> orderItems;

    private String email;

    public OrderDTO(){

    }

    public OrderDTO(String orderStatus, DeliveryTimeDTO deliveryTime,
                    String deliveryDate, String orderDate, Set<OrderItemDTO> orderItems,String email) {
        this.orderStatus = orderStatus;
        this.deliveryTime = deliveryTime;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.email = email;
    }

    public OrderDTO(Long orderId, String orderStatus, DeliveryTimeDTO deliveryTime,
                    String deliveryDate, String orderDate, Set<OrderItemDTO> orderItems,String email) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.deliveryTime = deliveryTime;
        this.deliveryDate = deliveryDate;
        this.orderDate = orderDate;
        this.orderItems = orderItems;
        this.email = email;
    }

    public Long obtainOrderId() {
        return orderId;
    }

    public String obtainOrderStatus() {
        return orderStatus;
    }

    public DeliveryTimeDTO obtainDeliveryTime() {
        return deliveryTime;
    }

    public String obtainDeliveryDate() {
        return deliveryDate;
    }

    public String obtainOrderDate() {
        return orderDate;
    }

    public Set<OrderItemDTO> obtainOrderItems() {
        return orderItems;
    }

    public String obtainEmail(){
        return email;
    }

    public void changeOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void changeOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public int compareTo(OrderDTO o) {
        if (orderId > o.orderId) {
            return 1;
        }
        else if (orderId < o.orderId) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
