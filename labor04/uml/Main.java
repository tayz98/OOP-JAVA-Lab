package labor04.uml;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Date d1 = new Date();
        Customer c1 = new Customer(12345, "Neumann", "Musterstrasse 1", "Max.Mustermann@gmail.com", true, null);
        Customer c2 = new Customer(111, "Mustermann", "Musterstrasse 2", "MaxMustermann@gmx.de", true);

        Order o1 = new Order(1, d1, c1, null);
        Order o2 = new Order(2, d1, c2, null);

        System.out.println(o2.getCustomerIdForThisOrder());
        //Payment p1 = new Payment(920, 300, o1);

        //o1.setPaymentList((List<Payment>) p1);
        //c1.setOrderList((List<Order>) o1);


    }
}

