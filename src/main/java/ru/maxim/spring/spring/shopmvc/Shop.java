package ru.maxim.spring.spring.shopmvc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Shop {
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String website;
    private String category;
    private String description;

    public Shop(String name, String address, String phone, String email, String website, String category, String description) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.category = category;
        this.description = description;
    }

    @Override
    public String toString() {
        return name + " " + address + " " + phone + " " + email + " " + website + " " + category + " " + description;
    }
}
