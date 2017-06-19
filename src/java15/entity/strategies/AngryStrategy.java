package java15.entity.strategies;

import java15.entity.CashierStrategy;
import java15.entity.Customer;

public class AngryStrategy implements CashierStrategy {
    int ANGRY_COEFFICIENT = 3;
    @Override
    public int communicate(Customer customer) {

        return customer.buyThings() + ANGRY_COEFFICIENT;
    }
}
