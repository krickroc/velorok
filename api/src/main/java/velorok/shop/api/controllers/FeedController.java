package velorok.shop.api.controllers;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import velorok.shop.api.models.Bike;
import velorok.shop.api.models.User;
import velorok.shop.api.repositories.BikeRepository;
import velorok.shop.api.repositories.UserRepository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Controller
public class FeedController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BikeRepository bikeRepository;

    @RequestMapping("/feed")
    public @ResponseBody
    String main() {
        Faker faker = new Faker();
        Random random = new Random();

        ArrayList<String> brands = new ArrayList<String>();
        brands.add("Peugeot");
        brands.add("Stevens");
        brands.add("Giant");
        brands.add("Trek");
        brands.add("Santa Cruz");
        brands.add("Cannondale");
        brands.add("Yeti Cycles");

        ArrayList<String> models = new ArrayList<String>();
        models.add("VTT");
        models.add("VTC");
        models.add("City");
        models.add("Electric");

        userRepository.deleteAll();
        bikeRepository.deleteAll();

        brands.forEach((brand) -> {
            models.forEach((model) -> {
                Bike bike = new Bike();
                bike.setBrand(brand);
                bike.setModel(model);
                bikeRepository.save(bike);
            });
        });

        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName(faker.funnyName().name());
            // System.out.println(bikeRepository.findAll());
            ArrayList<Bike> bikes = new ArrayList();
            for (int j = 0; j < 3; j++) {
                bikes.add(bikeRepository.findAll().get(random.nextInt((int) bikeRepository.count())));
            }
            user.setBikes(bikes);
             userRepository.save(user);
        }

        return "DB fed successfully";
    }
}
