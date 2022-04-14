package labor04.uml;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date createDate;
    private Customer customer;
    private List<Payment> paymentList = new ArrayList<>();
}
