package Homework1.Task006.Classes;

/**
 * Created by Юра on 12.02.2016.
 */
public class Dog extends AnimalClass {
    public Dog(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        voice = "Gavk";
        name = "Sharik";
        likeFood = new Meat();
    }
}
