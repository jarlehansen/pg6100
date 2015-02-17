package no.nith.pg6100;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class Controller {
    @Inject
    private Bean bean;

    public String getPrincipalName() {
        return bean.getPrincipalName();
    }

    public boolean isCallerInRole() {
        return bean.isCallerInRole();
    }
}
