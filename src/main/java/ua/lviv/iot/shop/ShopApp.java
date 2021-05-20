package ua.lviv.iot.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.shop.controllers", "ua.lviv.iot.shop.service"})
public class ShopApp {
    public static void main(String[] args) {
        SpringApplication.run(ShopApp.class, args);
    }
}