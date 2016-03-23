package Homework1.Task006.Classes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;

/**
 * Created by Юра on 12.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<AnimalClass> animals = new ArrayList<AnimalClass>();
        ApplicationContext ac = new ClassPathXmlApplicationContext("Homework1/Task006/spring-config.xml");
        for (int i = 0; i < 10; i++){
            animals.add((Cat) ac.getBean("cat"));
        }
        for (int i = 0; i < 10; i++){
            animals.add((Dog) ac.getBean("dog"));
        }
        for (int i = 0; i < 10; i++){
            animals.add((Tigr) ac.getBean("tigr"));
        }
        for (int i = 0; i < 10; i++){
            animals.add((Mouse) ac.getBean("mouse"));
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
