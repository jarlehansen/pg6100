package no.nith.pg6100;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
public class DocumentCustomerService {

    @SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
    public String getCustomers(String input) {
        return "Hello " + input;
    }

}
