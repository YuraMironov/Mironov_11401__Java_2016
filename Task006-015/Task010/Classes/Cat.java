package Homework1.Task010.Classes;

/**
 * Created by Юра on 12.02.2016.
 */
public class Cat extends AnimalClass {
    public Cat(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        voice = "Myau";
        name = "Cat";
        likeFood = new Milk();
    }
}
