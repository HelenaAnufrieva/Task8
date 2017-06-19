package java15.entity.customers;

import java15.entity.Customer;

public abstract class AbstractCustomer implements Customer{
    int timeOfShopping;
    public AbstractCustomer()
    {
        timeOfShopping = 0;
    }
}
