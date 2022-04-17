package labor04.uml;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Date d1 = new Date();
        Customer c1 = new Customer(1, "Peter Petersen", "Musterstraße 1", "peterPetersen@hotmail.de", true);
        Order o1 = new Order(1, d1, c1);
        Payment p1 = new Payment(1, 12.0f, o1);
        Payment p2 = new Payment(2, 11.0f, o1);
        Item i1 = new Item(1, 36.5, "A very cool item, you need this!", 12.5);
        Item i2 = new Item(2, 14, "Another awesome item you need!", 99.99);
        OrderDetail od1 = new OrderDetail(1, 3, "german", o1, i1);
        OrderDetail od2 = new OrderDetail(2, 2, "german", o1, i2);

        // check if payments get directed to Order o1 correctly
        System.out.println("payment 1 of Order o1: " + o1.getPaymentList().get(0).getAmount());
        System.out.println("payment 2 of Order o1: " + o1.getPaymentList().get(1).getAmount());
        System.out.println("Sum of all payments for Order o1: " + o1.addUpPayments());
        System.out.println("----------------------------------");

        // check if orderDetails get directed to Order o1 correctly
        System.out.println("OrderDetail od1 of Order o1: " + o1.getOrderDetailList().get(0).getPriceForQuantity());
        System.out.println("OrderDetail od2 of Order o1: " + o1.getOrderDetailList().get(1).getPriceForQuantity());
        System.out.println("----------------------------------");

        // check methods in OrderDetail
        System.out.println("Total weight of OrderDetail od1: " + od1.calculateWeight());
        System.out.println("Total cost without taxes for OrderDetail od1: " + od1.getPriceForQuantity());
        System.out.println("Total cost with taxes for OrderDetail od1: " + od1.calculateSubTotal());
        System.out.println("----------------------------------");

        // calculate total weight and sum for order
        System.out.println("Total weight of Order o1: " + o1.addUpWeight());
        System.out.println("Total price of Order o1: " + o1.addUpPrice());
    }
}

