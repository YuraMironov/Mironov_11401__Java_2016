package Homework1.Task007;

import Homework1.Task007.Classes.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

/**
 * Created by Юра on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<AnimalClass> animals = new ArrayList<AnimalClass>();
        ApplicationContext ac = new AnnotationConfigApplicationContext(JavaConfig.class);
        for (int i = 0; i < 10; i++){
            animals.add(ac.getBean("mycat", Cat.class));
        }
        for (int i = 0; i < 10; i++){
            animals.add(ac.getBean("mydog", Dog.class));
        }
        for (int i = 0; i < 10; i++){
            animals.add(ac.getBean("mytigr", Tigr.class));
        }
        for (int i = 0; i < 10; i++){
            animals.add( ac.getBean("mymouse", Mouse.class));
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
            an.eat(an.getLikeFood());
        }
    }
}
