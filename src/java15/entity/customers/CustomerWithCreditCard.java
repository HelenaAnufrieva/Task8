package java15.entity.customers;

import java.util.Random;

public class CustomerWithCreditCard extends AbstractCustomer {
    @Override
    public int buyThings() {
        Random random = new Random();
        timeOfShopping = 50;
        boolean isPayed = false;
        while(!isPayed) {
            if (random.nextBoolean()) {
                isPayed = true;
                timeOfShopping += 10;
            }
            else isPayed = true;
        }
        return timeOfShopping;
    }
}
