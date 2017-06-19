package java15.entity;

public interface Cashier {
    CashierStrategy strategy(Class customerClass);
}
