package Homework1.Task007.Classes;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Юра on 12.02.2016.
 */
public class Mouse extends AnimalClass {
    @Autowired
    protected Pizza pizza;
    public Mouse(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        voice = "Pi-Pi-Pi";
        name = "Peres";
        likeFood = pizza;
    }
}
