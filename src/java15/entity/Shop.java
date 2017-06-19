package java15.entity;

import java15.entity.errors.FireInTheShop;
import java15.entity.errors.ShopRobbery;

import java.util.Random;

/**
 * Created by Администратор on 19.06.2017.
 */
public class Shop {
    public void work() throws ShopRobbery, FireInTheShop {
        Random random = new Random();
        if ((random.nextInt(150) + 1) == 1) // вероятность того, что в магазине случится ограбление
            throw new ShopRobbery("Shop is robbing now!!!");
        if ((random.nextInt(150) + 1) <= 2) // вероятность того, что в магазине будет пожар
            throw new FireInTheShop("Shop is on fire!!!");
    }
}
