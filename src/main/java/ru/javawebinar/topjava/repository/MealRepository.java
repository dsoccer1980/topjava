package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

public interface MealRepository {

    Meal get(int id);

    void add(Meal meal);

    void update(int id, Meal meal);

    void delete(int id);

    List<MealWithExceed> getAll();


}
