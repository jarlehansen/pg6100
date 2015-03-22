package no.nith.pg6100;

import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

public class CustomerException2 extends SOAPFaultException {

    public CustomerException2(SOAPFault fault) {
        super(fault);
    }
}
