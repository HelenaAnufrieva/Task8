package java15.entity.cashiers;

import java15.entity.CashierStrategy;
import java15.entity.customers.CustomerWithCreditCard;
import java15.entity.customers.NormalCustomer;
import java15.entity.strategies.AngryStrategy;
import java15.entity.strategies.CommonStrategy;

public class NormalCashier extends AbstractCashier {
    public CashierStrategy strategy(Class customerClass) {
        if (NormalCustomer.class.isAssignableFrom(customerClass) || CustomerWithCreditCard.class.isAssignableFrom(customerClass))
            return new CommonStrategy(); // с обычными покупателями - обычная стратегия
        else
            return new AngryStrategy(); // с медленными - он злой


    }
}
