package Animals.Classes;

import Animals.Interfaces.*;

/**
 * Created by Юра on 12.02.2016.
 */

public class AnimalClass implements AnimalInterface, Eatable, Voicable, Biteble, History{
    boolean angry = false;
    int height;
    int weight;
    int age;
    String name;
    String voice;
    @Override
    public boolean isAngry() {
        return angry;
    }
    @Override
    public boolean isBig() {
        return height > 100;
    }
    @Override
    public boolean isFat() {
        return weight > 50;
    }
    @Override
    public boolean isOld() {
        return age > 10;
    }

    @Override
    public void cook(Food food) {
        System.out.println("Я приготовил " + food.toString());
    }

    @Override
    public void toTaste(Food food) {
        System.out.println("я попробовал " + food.toString());
    }

    @Override
    public void eat(Food food) {
        System.out.println("Я съел " +  food.toString());
    }

    @Override
    public void voice() {
        System.out.println("Я говорю " + voice);
    }

    @Override
    public void cry() {
        System.out.println("Я кричу " + voice);
    }

    @Override
    public void whisper() {
        System.out.println("Я шепчу " + voice);
    }

    @Override
    public void biteHand() {
        System.out.println("Я " + name + " укусил руку");
    }

    @Override
    public void biteLeg() {
        System.out.println("Я " + name + " укусил ногу");

    }

    @Override
    public void biteNose() {
        System.out.println("Я " + name + " укусил за нос");

    }

    @Override
    public int getAge(AnimalInterface animal) {
        return 0;
    }

    @Override
    public int getHeight(AnimalInterface animal) {
        return 0;
    }

    @Override
    public int getWeight(AnimalInterface animal) {
        return 0;
    }
}
