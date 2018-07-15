package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final Meal MEAL1 = new Meal(100002, LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500);
    public static final Meal MEAL2 = new Meal(100003, LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000);
    public static final Meal MEAL3 = new Meal(100004, LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500);
    public static final Meal MEAL4 = new Meal(100005, LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000);
    public static final Meal MEAL5 = new Meal(100006, LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500);
    public static final Meal MEAL6 = new Meal(100007, LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510);


}
