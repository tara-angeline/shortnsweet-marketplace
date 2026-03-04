package com.example.marketplace.controller;

import com.example.marketplace.model.Product;
import com.example.marketplace.model.Role;
import com.example.marketplace.model.User;
import com.example.marketplace.repository.ProductRepository;
import com.example.marketplace.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public TestController(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/test")
    public String populateDatabase() {
        productRepository.save(new Product(
                "Dark Chocolate",
                "Classic dark chocolate cake",
                "Rich dark chocolate cake layered with silky chocolate ganache.",
                10.99,
                50,
                "/product_img/DarkChocolate_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Nutella",
                "Hazelnut chocolate indulgence",
                "Soft chocolate sponge filled with creamy Nutella frosting.",
                11.49,
                40,
                "/product_img/Nutella_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Tiramisu",
                "Coffee-infused Italian classic",
                "Layers of espresso-soaked sponge with mascarpone cream.",
                12.49,
                35,
                "/product_img/Tiramisu_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Matcha",
                "Earthy Japanese green tea",
                "Light matcha sponge with smooth matcha cream.",
                11.99,
                30,
                "/product_img/Matcha_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Red Velvet",
                "Smooth cocoa with cream cheese",
                "Moist red velvet cake paired with tangy cream cheese frosting.",
                11.99,
                40,
                "/product_img/RedVelvet_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Nastar",
                "Indonesian pineapple delight",
                "Buttery cake filled with sweet pineapple jam, inspired by nastar.",
                10.49,
                30,
                "/product_img/Nastar_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Klepon",
                "Palm sugar & coconut",
                "Pandan-infused cake with molten gula jawa and coconut cream.",
                10.99,
                25,
                "/product_img/Klepon_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Mango Float",
                "Filipino-style mango dessert",
                "Creamy layered cake with ripe mangoes and vanilla cream.",
                11.49,
                35,
                "/product_img/MangoFloat_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Ube",
                "Purple yam sweetness",
                "Soft ube sponge with lightly sweet ube cream.",
                11.99,
                30,
                "/product_img/Ube_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Oolong Tea",
                "Fragrant tea-infused cake",
                "Delicate oolong tea sponge with floral cream notes.",
                11.49,
                25,
                "/product_img/OolongTea_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Lotus Biscoff",
                "Caramelised biscuit favourite",
                "Fluffy cake layered with Biscoff spread and cream.",
                12.49,
                40,
                "/product_img/LotusBiscoff_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Oreo",
                "Cookies & cream classic",
                "Chocolate sponge packed with Oreo crumbs and cream.",
                10.99,
                45,
                "/product_img/Oreo_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Carrot Cake",
                "Spiced & comforting",
                "Moist carrot cake with walnuts and cream cheese frosting.",
                11.49,
                30,
                "/product_img/CarrotCake_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Strawberry Shortcake",
                "Light and fruity",
                "Vanilla sponge layered with fresh strawberries and cream.",
                11.99,
                35,
                "/product_img/StrawberryShortcake_Main.png",
                true
        ));

        productRepository.save(new Product(
                "Black Forest",
                "Chocolate & cherry classic",
                "Chocolate sponge with whipped cream and cherries.",
                12.99,
                30,
                "/product_img/BlackForrest_Main.png",
                true
        ));

        userRepository.save(new User("admin@dessertbox.ie", "12345678", Role.ADMIN, "Tara", "Angeline"));
        userRepository.save(new User("test@example.com", "12345678", Role.CUSTOMER, "Jane", "Doe"));

        return "test";
    }
}
