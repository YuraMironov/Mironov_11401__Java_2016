package ru.kpfu.itis.Mironov.SE.services;

import java.util.List;

/**
 * Created by Юра on 21.04.2016.
 */
public interface Service<T> {
    T addEntity(T t);
    void delete(long id);
    T getByName(String name);
    T editEntity(T t);
    List<T> getAll();
}
