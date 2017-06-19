package java15.entity.strategies;

import java15.entity.CashierStrategy;
import java15.entity.Customer;

public class CommonStrategy implements CashierStrategy {
    int COMMON_COEFFICIENT = 0;
    @Override
    public int communicate(Customer customer) {
       /* System.out.println("Common Strategy");*/
        return customer.buyThings() + COMMON_COEFFICIENT;
    }
}
