package java15.entity;

import java15.entity.exceptions.CashierHasNoChange;

public interface Cashier {
    CashierStrategy strategy(Class customerClass);
    void giveChange() throws CashierHasNoChange;
}
