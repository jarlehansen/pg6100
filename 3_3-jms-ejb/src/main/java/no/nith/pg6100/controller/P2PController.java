package no.nith.pg6100.controller;


import no.nith.pg6100.jms.P2PBean;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class P2PController implements Serializable {
    private P2PBean p2PBean;

    private String producedMessage;
    private String consumedMessage;

    @Inject
    public void setP2PBean(P2PBean p2PBean) {
        this.p2PBean = p2PBean;
    }

    public String getProducedMessage() {
        return producedMessage;
    }

    public void setProducedMessage(String producedMessage) {
        this.producedMessage = producedMessage;
    }

    public String getConsumedMessage() {
        return consumedMessage;
    }

    public void setConsumedMessage(String consumedMessage) {
        this.consumedMessage = consumedMessage;
    }

    public void send() {
        if (producedMessage != null && producedMessage.length() > 0) {
            p2PBean.send(producedMessage);
            producedMessage = "";
        }
    }

    public void consume() {
        consumedMessage = p2PBean.consume();
    }
}
