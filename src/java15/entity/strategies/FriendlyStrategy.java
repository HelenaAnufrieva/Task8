package java15.entity.strategies;

import java15.entity.CashierStrategy;
import java15.entity.Customer;

public class FriendlyStrategy implements CashierStrategy {
    private final static int FRIENDLY_COEFFICIENT = -2;

    public int communicate(Customer customer) {

        return customer.buyThings() + FRIENDLY_COEFFICIENT;

    }
}
