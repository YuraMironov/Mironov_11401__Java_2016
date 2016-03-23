package Homework1.Task006.Classes;

/**
 * Created by Юра on 12.02.2016.
 */
public class Tigr extends AnimalClass {
    public Tigr(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        voice = "Rrrr";
        name = "Tigr";
        likeFood = new Meat();
    }
}
