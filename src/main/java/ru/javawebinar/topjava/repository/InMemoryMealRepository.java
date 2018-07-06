package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

public class InMemoryMealRepository implements MealRepository {
    private final static int CALORIES_PER_DAY = 2000;

    private Map<Integer, Meal> repository = new HashMap<>();

    {
        MealsUtil.meals.forEach(m -> repository.put(m.getId(), m));
    }

    @Override
    public Meal get(int id) {
        return repository.get(id);
    }

    @Override
    public void add(Meal meal) {
        repository.put(meal.getId(), meal);
    }

    @Override
    public void update(int id, Meal meal) {
        repository.put(id, meal);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public List<MealWithExceed> getAll() {
        return MealsUtil.getFilteredWithExceeded(new ArrayList<>(repository.values()), LocalTime.of(0, 0), LocalTime.of(23, 59), CALORIES_PER_DAY)
                .stream()
        .sorted(Comparator.comparing(MealWithExceed::getDateTime)).collect(Collectors.toList());
    }
}
