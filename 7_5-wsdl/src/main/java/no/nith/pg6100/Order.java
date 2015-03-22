package no.nith.pg6100;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    @XmlElementWrapper(name = "content")
    @XmlElement(name = "order_line")
    private List<OrderLine> orderLines;

    public Order() {
    }

    public Order(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
}
