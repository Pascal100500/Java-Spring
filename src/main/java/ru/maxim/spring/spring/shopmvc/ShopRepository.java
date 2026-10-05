package ru.maxim.spring.spring.shopmvc;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ShopRepository {

    private final List<Shop> shops = new ArrayList<>();
    private long nextId = 1;


    public void add(Shop shop) {
        shop.setId(nextId);
        nextId++;
        shops.add(shop);
    }

    public List<Shop> getAll() {
        return shops;
    }

    public Shop getById(long id) {
        for (Shop shop : shops) {
            if (shop.getId() == id) {
                return shop;
            }
        }

        return null;
    }

    public ShopRepository() {
        add(new Shop(
                "СпортМир",
                "ул. Ленина, 10",
                "+7 900 111-11-11",
                "sport@example.com",
                "https://sport.example.com",
                "Спортивный",
                "Магазин спортивных товаров"
        ));

        add(new Shop(
                "Продукты 24",
                "ул. Пушкина, 15",
                "+7 900 222-22-22",
                "food@example.com",
                "https://food.example.com",
                "Продовольственный",
                "Продовольственный магазин"
        ));
    }
}
