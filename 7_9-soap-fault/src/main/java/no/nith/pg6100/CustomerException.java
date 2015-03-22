package no.nith.pg6100;

import javax.xml.ws.WebFault;

@WebFault(name = "InvalidCustomer")
public class CustomerException extends Exception {

    public CustomerException() {
    }

    public CustomerException(String message) {
        super(message);
    }
}
