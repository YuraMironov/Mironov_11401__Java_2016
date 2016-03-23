package Homework1.Task007.Classes;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Юра on 12.02.2016.
 */
public class Dog extends AnimalClass {
    @Autowired
    protected Meat meat;
    public Dog(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        voice = "Gavk";
        name = "Sharik";
        likeFood = meat;
    }
}
