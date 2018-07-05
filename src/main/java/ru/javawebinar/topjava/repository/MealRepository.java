package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

public interface MealRepository {

    MealWithExceed get(int id);
    void add(MealWithExceed meal);
    void update(int id, MealWithExceed meal);
    void delete(int id);
    List<MealWithExceed> getAll();


}
