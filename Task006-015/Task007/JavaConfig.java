package Homework1.Task007;

import Homework1.Task007.Classes.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Юра on 02.03.2016.
 */
@Configuration
@ComponentScan(basePackages = {"ForHomeWork.Task006007.Classes"})
public class JavaConfig {
    @Bean
    public FoodClass likeFood() {
        return new Milk();
    } // соответствующие животные не потхватывают свои любимые блюда

    @Bean
    public Cat mycat() {
        return new Cat(1, 1, 1);
    }

    @Bean
    public Dog mydog() {
        return new Dog(1, 1, 1);
    }

    @Bean
    public Tigr mytigr() {
        return new Tigr(1, 1, 1);
    }

    @Bean
    public Mouse mymouse() {
        return new Mouse(1, 1, 1);
    }
}
