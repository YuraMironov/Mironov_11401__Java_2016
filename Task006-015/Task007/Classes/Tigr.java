package Homework1.Task007.Classes;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Юра on 12.02.2016.
 */
public class Tigr extends AnimalClass {
    @Autowired
    protected Meat meat;
    public Tigr(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        voice = "Rrrr";
        name = "Tigr";
        likeFood = meat;
    }
}
