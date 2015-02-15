package no.nith.pg6100;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;


@RolesAllowed({"pg6100_user"})
@Stateless
public class Bean {

    public void allowed() {
        System.out.println("allowed()");
    }

    @RolesAllowed({"pg6100_admin"})
    public void notAllowed() {
        System.out.println("notAllowed()");
    }
}
