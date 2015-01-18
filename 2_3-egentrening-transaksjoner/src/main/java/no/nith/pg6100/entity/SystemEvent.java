package no.nith.pg6100.entity;

import java.util.Date;

public class SystemEvent {
    private int id;

    private Date time;

    private EventType eventType;

    private int customerId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "SystemEvent{" +
                "id=" + id +
                ", time=" + time +
                ", eventType=" + eventType +
                ", customerId=" + customerId +
                '}';
    }
}
