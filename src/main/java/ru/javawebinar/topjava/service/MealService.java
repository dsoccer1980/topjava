package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface MealService {
    List<MealWithExceed> getAll(int userId);

    Meal get(int id, int userId);

    Meal create(Meal meal, int userId);

    Meal update(Meal meal, int userId);

    void delete(int id, int userId);

    List<MealWithExceed> getBetween(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime, int userId);
}