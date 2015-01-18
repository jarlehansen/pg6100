package no.nith.pg6100;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Thread.sleep(5000);

        Service serviceOne = new Service();
        Service serviceTwo = new Service();

        int amount = 100;
        for(int i = 0; i < 50; i++) {
           try {
               serviceOne.addToAccount(amount);
               serviceTwo.subtractFromAccount(amount);
           } catch(IllegalStateException e) {
               System.out.println(e.getMessage());
           }
        }
    }
}
