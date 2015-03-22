package no.nith.pg6100;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
public class RPCCustomerService {

    @SOAPBinding(style = SOAPBinding.Style.RPC)
    public String getCustomer(String input) {
        return "Hello " + input;
    }
}
