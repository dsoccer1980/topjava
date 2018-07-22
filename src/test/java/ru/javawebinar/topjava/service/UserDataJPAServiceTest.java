package ru.javawebinar.topjava.service;


import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;
import ru.javawebinar.topjava.model.Meal;

import java.util.Arrays;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.ADMIN_MEAL1;
import static ru.javawebinar.topjava.MealTestData.ADMIN_MEAL2;
import static ru.javawebinar.topjava.UserTestData.*;


@ActiveProfiles(Profiles.DATAJPA)
public class UserDataJPAServiceTest extends UserServiceTest {

    @Test
    public void get() throws Exception {
        List<Meal> meals = service.getMealUser(ADMIN_ID);

        ru.javawebinar.topjava.MealTestData.assertMatch(meals, Arrays.asList(ADMIN_MEAL1, ADMIN_MEAL2));
    }

}