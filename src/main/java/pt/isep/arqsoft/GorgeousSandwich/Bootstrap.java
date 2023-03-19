package pt.isep.arqsoft.GorgeousSandwich;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pt.isep.arqsoft.GorgeousSandwich.controller.CommentController;
import pt.isep.arqsoft.GorgeousSandwich.controller.OrderController;
import pt.isep.arqsoft.GorgeousSandwich.controller.ReviewController;
import pt.isep.arqsoft.GorgeousSandwich.controller.SandwichController;
import pt.isep.arqsoft.GorgeousSandwich.dto.comment.CommentDTO;
import pt.isep.arqsoft.GorgeousSandwich.dto.order.DeliveryTimeDTO;
import pt.isep.arqsoft.GorgeousSandwich.dto.order.OrderDTO;
import pt.isep.arqsoft.GorgeousSandwich.dto.order.OrderItemDTO;
import pt.isep.arqsoft.GorgeousSandwich.dto.review.ReviewDTO;
import pt.isep.arqsoft.GorgeousSandwich.dto.sandwich.SandwichDTO;

@Component
public class Bootstrap implements CommandLineRunner {

    private SandwichController sandwichController;
    private ReviewController reviewController;
    private CommentController commentController;
    private OrderController orderController;

    public Bootstrap(SandwichController sandwichController, ReviewController reviewController, CommentController commentController, OrderController orderController) {
        this.sandwichController = sandwichController;
        this.reviewController = reviewController;
        this.commentController = commentController;
        this.orderController = orderController;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Creation of Sandwiches");
        SandwichDTO sandwich1 = sandwichController.createSandwich(new SandwichDTO(2, "salty", "Sandwich1 " + new java.util.Date().getTime(), "desc1"));
        SandwichDTO sandwich2 = sandwichController.createSandwich(new SandwichDTO(3, "salty", "Sandwich2 " + new java.util.Date().getTime(), "desc2"));
        sandwichController.createSandwich(new SandwichDTO(4, "sweet", "Sandwich3 " + new java.util.Date().getTime(), "desc3"));
        sandwichController.createSandwich(new SandwichDTO(5, "salty", "Sandwich4 " + new java.util.Date().getTime(), "desc4"));
        sandwichController.createSandwich(new SandwichDTO(1, "sweet", "Sandwich5 " + new java.util.Date().getTime(), "desc5"));
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Created 5 Sandwiches");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Update of Sandwiches Stock");
        sandwichController.addUnitsSandwich(sandwich1.sandwichId, new SandwichDTO(1, null, null, null));
        sandwichController.addUnitsSandwich(sandwich1.sandwichId, new SandwichDTO(2, null, null, null));
        sandwichController.addUnitsSandwich(sandwich1.sandwichId, new SandwichDTO(3, null, null, null));
        sandwichController.addUnitsSandwich(sandwich1.sandwichId, new SandwichDTO(4, null, null, null));
        sandwichController.addUnitsSandwich(sandwich1.sandwichId, new SandwichDTO(5, null, null, null));
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Updated 5 Stocks");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get List of Sandwiches");
        sandwichController.listAll();
        sandwichController.listAll();
        sandwichController.listAll();
        sandwichController.listAll();
        sandwichController.listAll();
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " End of Get List of Sandwiches");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get Details of Sandwiches");
        sandwichController.getById(sandwich1.sandwichId);
        sandwichController.getById(sandwich1.sandwichId);
        sandwichController.getById(sandwich1.sandwichId);
        sandwichController.getById(sandwich1.sandwichId);
        sandwichController.getById(sandwich1.sandwichId);
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " 5 sandwiches details retrieved");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Review/Rate of Sandwiches");
        reviewController.createReview(new ReviewDTO("desc1", 1, sandwich1.sandwichId, "test@test.com"));
        reviewController.createReview(new ReviewDTO("desc2", 2, sandwich1.sandwichId, "test@test.com"));
        reviewController.createReview(new ReviewDTO("desc3", 2, sandwich1.sandwichId, "test@test.com"));
        reviewController.createReview(new ReviewDTO("desc4", 3, sandwich1.sandwichId, "test@test.com"));
        reviewController.createReview(new ReviewDTO("desc5", 5, sandwich1.sandwichId, "test@test.com"));
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " 5 reviews created");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get List of Reviews");
        reviewController.listBySandwich(sandwich1.sandwichId);
        reviewController.listBySandwich(sandwich1.sandwichId);
        reviewController.listBySandwich(sandwich1.sandwichId);
        reviewController.listBySandwich(sandwich1.sandwichId);
        reviewController.listBySandwich(sandwich1.sandwichId);
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " End of Get List of Reviews");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get The Rate Interval");
        reviewController.getGradeMinAndMax();
        reviewController.getGradeMinAndMax();
        reviewController.getGradeMinAndMax();
        reviewController.getGradeMinAndMax();
        reviewController.getGradeMinAndMax();
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " End of Get Rate Interval");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Comment a Sandwich");
        commentController.createComment(new CommentDTO("desc1", sandwich1.sandwichId, "test@test.com"));
        commentController.createComment(new CommentDTO("desc1", sandwich1.sandwichId, "test@test.com"));
        commentController.createComment(new CommentDTO("desc1", sandwich1.sandwichId, "test@test.com"));
        commentController.createComment(new CommentDTO("desc1", sandwich1.sandwichId, "test@test.com"));
        commentController.createComment(new CommentDTO("desc1", sandwich1.sandwichId, "test@test.com"));
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " 5 comments created");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get List of comments");
        commentController.listBySandwich(sandwich1.sandwichId);
        commentController.listBySandwich(sandwich1.sandwichId);
        commentController.listBySandwich(sandwich1.sandwichId);
        commentController.listBySandwich(sandwich1.sandwichId);
        commentController.listBySandwich(sandwich1.sandwichId);
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " End of Get List of comments");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Make an Order");
        DeliveryTimeDTO deliveryTime = new DeliveryTimeDTO("13:40", "14:00");
        OrderItemDTO orderItem = new OrderItemDTO(sandwich1.sandwichId, 2);
        Set<OrderItemDTO> orderItemList = new HashSet<OrderItemDTO>();
        orderItemList.add(orderItem);
        OrderDTO order1 = orderController.createOrder(new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        orderController.createOrder(new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        orderController.createOrder(new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        orderController.createOrder(new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        orderController.createOrder(new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " 5 orders created");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Update of Orders");
        DeliveryTimeDTO deliveryTime1 = new DeliveryTimeDTO("14:00", "14:20");
        OrderItemDTO orderItem1 = new OrderItemDTO(sandwich2.sandwichId, 1);
        Set<OrderItemDTO> orderItemList1 = new HashSet<OrderItemDTO>();
        orderItemList1.add(orderItem1);
        orderController.updateOrder(order1.orderId, new OrderDTO(null, deliveryTime1, "2023-03-30", null, orderItemList1, "test@test.com"));
        orderController.updateOrder(order1.orderId, new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        orderController.updateOrder(order1.orderId, new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        orderController.updateOrder(order1.orderId, new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        orderController.updateOrder(order1.orderId, new OrderDTO(null, deliveryTime, "2023-03-30", null, orderItemList, "test@test.com"));
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Updated 5 Orders");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get List of Orders");
        orderController.listAll();
        orderController.listAll();
        orderController.listAll();
        orderController.listAll();
        orderController.listAll();
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " End of Get List of Orders");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get Details of Orders");
        orderController.getById(order1.orderId);
        orderController.getById(order1.orderId);
        orderController.getById(order1.orderId);
        orderController.getById(order1.orderId);
        orderController.getById(order1.orderId);
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " 5 orders details retrieved");

        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " Starting the Get of Delivery Times");
        orderController.getDeliveryTimes();
        orderController.getDeliveryTimes();
        orderController.getDeliveryTimes();
        orderController.getDeliveryTimes();
        orderController.getDeliveryTimes();
        System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss.SS").format(new java.util.Date()) + " End the get of Delivery Times");
    }
}



