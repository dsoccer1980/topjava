package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryMealRepository implements MealRepository {
    private Map<Integer, MealWithExceed> repository = new HashMap<>();

    {
        List<MealWithExceed> mealWithExceedList = MealsUtil.getFilteredWithExceeded(MealsUtil.meals, LocalTime.of(0, 0), LocalTime.of(23, 59), 2000);
        mealWithExceedList.forEach(m -> repository.put(m.getId(), m));
    }

    @Override
    public MealWithExceed get(int id) {
        return repository.get(id);
    }

    @Override
    public void add(MealWithExceed meal) {
        repository.put(meal.getId(), meal);

    }

    @Override
    public void update(int id, MealWithExceed meal) {
        repository.put(id, meal);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public List<MealWithExceed> getAll() {
        return new ArrayList<>(repository.values());
    }
}
