package no.nith.pg6100.controller;

import no.nith.pg6100.domain.MessageDao;
import no.nith.pg6100.domain.MessageProducer;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class Controller implements Serializable {
    @Inject
    private MessageProducer messageProducer;

    @Inject
    private MessageDao messageDao;

    private String message = "";
    private String receivedMessage = "";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReceivedMessage() {
        return receivedMessage;
    }

    public void send() {
        messageProducer.send(message);
    }

    public void getLatest() {
        receivedMessage = messageDao.getLatestMessage();
    }
}
