package no.nith.pg6100;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;

@WebService
public class CustomerService {

    public String getCustomers(String input) throws CustomerException {
        throw new CustomerException("Invalid input");
    }

    public String getCustomers2(String input) throws CustomerException, SOAPException {
        SOAPFault fault = SOAPFactory.newInstance().createFault("invalid input", new QName("ValidationFault"));
        throw new CustomerException2(fault);
    }


}
