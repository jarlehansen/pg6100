package no.nith.pg6100;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {
    @XmlAttribute
    private long id;
    @XmlAttribute
    private Date date;

    @XmlElementWrapper(name = "content")
    @XmlElement(name = "order_line")
    private List<OrderLine> orderLines;

    public Order() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Order(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }
}
