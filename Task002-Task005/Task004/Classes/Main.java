package Homework1.Task004.Classes;

import java.util.ArrayList;

/**
 * Created by Юра on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<AnimalClass> animals = new ArrayList<AnimalClass>();
        for (int i = 0; i < 10; i++){
            animals.add(new Cat(1,1,1));
        }
        for (int i = 0; i < 10; i++){
            animals.add(new Dog(1,1,1));
        }
        for (int i = 0; i < 10; i++){
            animals.add(new Tigr(1,1,1));
        }
        for (int i = 0; i < 10; i++){
            animals.add(new Mouse(1,1,1));
        }
        for(AnimalClass an : animals){
            an.getAge();
            an.getWeight();
            an.getHeight();
            an.biteHand();
            an.biteLeg();
            an.biteNose();
            an.isAngry();
            an.isBig();
            an.isOld();
            an.isFat();
            an.eat(an.likeFood);
        }
    }
}
