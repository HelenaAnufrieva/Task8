package java15;

import java15.entity.Customer;
import java15.entity.Register;
import java15.entity.cashiers.NiceCashier;
import java15.entity.cashiers.StrangeCashier;
import java15.entity.cashiers.NormalCashier;
import java15.entity.customers.CustomerWithCreditCard;
import java15.entity.customers.NormalCustomer;
import java15.entity.customers.SlowlyCustomer;

import java.util.Random;

public class Application implements Runnable{

    private Customer randomCustomer()
    {
        if(new Random().nextInt(2) == 0)
            return new CustomerWithCreditCard();
        else {
            if(new Random().nextBoolean())
                return new NormalCustomer();
            else return new SlowlyCustomer();
        }
    }

    /* private Cashier randomCashier()
     {
         if (new Random().nextInt(2) == 0) {
             System.out.println("Nice Cashier");
             return new NiceCashier();
         }
         else {
             if(new Random().nextBoolean()) {
                 System.out.println("Strange Cashier");
                 return new StrangeCashier();
             }
             else {
                 System.out.println("Normal Cashier");
                 return new NormalCashier();
             }
         }
     }*/
    public void run() {
        System.out.println("Nice Cashier");
        Register register = new Register(new NiceCashier());
        for (int i = 0; i < 20; i++) {
            register.newCustomer(randomCustomer());
        }
        register.run();
        System.out.println("Strange Cashier");
        register = new Register(new StrangeCashier());
        for (int i = 0; i < 20; i++) {
            register.newCustomer(randomCustomer());
        }
        register.run();
        System.out.println("Normal Cashier");
        register = new Register(new NormalCashier());
        for (int i = 0; i < 20; i++) {
            register.newCustomer(randomCustomer());
        }
        register.run();

    }

}
