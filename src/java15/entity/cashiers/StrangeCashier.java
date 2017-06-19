package java15.entity.cashiers;

import java15.entity.CashierStrategy;
import java15.entity.customers.CustomerWithCreditCard;
import java15.entity.customers.NormalCustomer;
import java15.entity.strategies.AngryStrategy;
import java15.entity.strategies.FriendlyStrategy;

public class StrangeCashier extends AbstractCashier {

    public CashierStrategy strategy(Class customerClass) {
        if (NormalCustomer.class.isAssignableFrom(customerClass) || CustomerWithCreditCard.class.isAssignableFrom(customerClass))
            return new AngryStrategy(); // странный кассир с обычными покупателями злой
        else
            return new FriendlyStrategy(); // с медленными покупателями - дружелюбный
    }
}


