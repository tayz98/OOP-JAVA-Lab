package labor04.uml;

import java.util.List;

public class Main {

    public static void main(String[] args) {



        Customer c1 = new Customer(12345, "Neumann", "Musterstraße 1", "Max.Mustermann@gmail.com", true, (List<Order>) o1);
        Order o1 = new Order(42069, "Turnschuh", 2021 - 10 - 01, c1, p1);
        OrderDetail oD1 = new OrderDetail(1337, 123, "ABC");
        Item i1 = new Item(530, (float) 1.2, "Mit diesem cleanen Look bist du immer stylish unterwegs", 100.20);
        Payment p1 = new Payment(920, 300, o1);

    }
}

