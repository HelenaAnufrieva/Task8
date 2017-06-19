package java15.entity;

import java15.entity.errors.FireInTheShop;
import java15.entity.errors.ShopRobbery;
import java15.entity.exceptions.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Register {
    private Random random = new Random();
    private final Cashier cashier;
    private final Queue<Customer> queue = new LinkedList<>();

    public Register(Cashier cashier) {
        this.cashier = cashier;
    }

    public void work() throws TapeIsEnded, RegisterIsBroken
    {
        if ((random.nextInt(150) + 1) <= 30) // вероятность того, что закончится лента в кассовом аппарате
            throw new TapeIsEnded("Tape is ended!");
        if ((random.nextInt(150) + 1) <= 15) // вероятность того, что касса сломаеся
            throw new RegisterIsBroken("Register is broken!");
    }

    public void newCustomer(Customer customer)
    {
        queue.add(customer);
    }

    public void run()
    {
        int countBroken = 0, countNoChange = 0, countTapeEnded = 0;
        Shop shop = new Shop();
        int numberOfCustomers = 0;
        int totalTime = 0;
        Customer customer;
        while ((customer = queue.poll()) != null)
        {
            CashierStrategy strategy = cashier.strategy(customer.getClass());
            try {
                work();
                cashier.giveChange();
                shop.work();
            } catch (CashierHasNoChange e) {
                countNoChange++;
                totalTime += 60; // если у кассира нет сдачи, найти сдачу у него займет 1 минута
            }
            catch (TapeIsEnded e) {
                countTapeEnded++;
                totalTime += 120; // замена ленты в кассом аппарате = 2 минуты
            }
            catch (RegisterIsBroken e) {
                countBroken++;
                totalTime += 720; // ремонт кассового аппарата = 12 минут
            }
            catch (ShopRobbery e) {
                e.message();
                return; // если в магазине ограбление - вывод сообщения и завершение работы кассира
            }
            catch (FireInTheShop e) {
                e.message();
                return; // если в магазине пожар - вывод сообщения и завершение работы кассира
            }
            totalTime += strategy.communicate(customer);
            numberOfCustomers++;
        }
        System.out.println("It was " + numberOfCustomers + " customers and it took " + totalTime/60 + " minutes.");
        System.out.println("Register was broken " + countBroken + " times, cashier didn't have to deposit " + countNoChange + " times, tape was ended " + countTapeEnded + " times.");

    }
}
