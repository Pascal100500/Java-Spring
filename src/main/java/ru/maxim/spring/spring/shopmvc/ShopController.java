package ru.maxim.spring.spring.shopmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ShopController {

    private final ShopRepository shopRepository;

    public ShopController(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @GetMapping("/shops")
    public String shops(Model model) {
        List<Shop> shops = shopRepository.getAll();

        model.addAttribute("shops", shops);

        return "shops";
    }

    @GetMapping("/shops/{id}")
    public String shopsById(@PathVariable long id, Model model) {
        Shop shop = shopRepository.getById(id);

        model.addAttribute("shop", shop);

        return "shopinfo";
    }
}