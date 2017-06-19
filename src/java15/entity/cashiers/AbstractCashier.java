package java15.entity.cashiers;

import java15.entity.Cashier;
import java15.entity.CashierStrategy;
import java15.entity.exceptions.CashierHasNoChange;

import java.util.Random;

public abstract class AbstractCashier implements Cashier {
    @Override
    public abstract CashierStrategy strategy(Class customerClass);
    public void giveChange() throws CashierHasNoChange
    {
        Random random = new Random();
        if ((random.nextInt(150) + 1) <= 60) // вероятность того, что у кассира не будет сдачи
            throw new CashierHasNoChange("Cashier has no change!");
    }
}
