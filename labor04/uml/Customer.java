package labor04.uml;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private String delieveryAdress;
    private String contact;
    private boolean active;
    private List<Order> orderList = new ArrayList<>();
}
