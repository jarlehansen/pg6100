package no.nith.pg6100;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class Bean {
    @Resource
    private SessionContext sessionContext;

    public String getPrincipalName() {
        return sessionContext.getCallerPrincipal().getName();
    }

    public boolean isCallerInRole() {
        return sessionContext.isCallerInRole("pg6100_user");
    }
}
