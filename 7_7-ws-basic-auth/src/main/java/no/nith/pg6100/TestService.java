package no.nith.pg6100;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService
public class TestService {
    @Inject
    private Text text;

    public String getText() {
        return text.getText();
    }
}
