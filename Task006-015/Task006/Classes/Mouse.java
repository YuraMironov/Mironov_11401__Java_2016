package Homework1.Task006.Classes;

/**
 * Created by Юра on 12.02.2016.
 */
public class Mouse extends AnimalClass {
    public Mouse(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        voice = "Pi-Pi-Pi";
        name = "Peres";
        likeFood = new Pizza();
    }
}
