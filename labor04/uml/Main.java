package labor04.uml;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Date date = new Date(); // hier fehl am Platz, aber zu Testzwecken benutze ich es hier vorübergehend.

        Customer c1 = new Customer(12345, "Neumann", "Musterstraße 1", "Max.Mustermann@gmail.com", true, null);
        Order o1 = new Order(42069, date, c1, null);
        OrderDetail oD1 = new OrderDetail(1337, 123, "ABC");
        Item i1 = new Item(530, (float) 1.2, "Mit diesem cleanen Look bist du immer stylish unterwegs", 100.20);
        Payment p1 = new Payment(920, 300, o1);

        o1.setPaymentList((List<Payment>) p1);
        c1.setOrderList((List<Order>) o1);



    }
}

