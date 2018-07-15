package ru.javawebinar.topjava.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void get() throws Exception {
        Meal meal = service.get(MEAL1.getId(), USER_ID);
        assertEquals(MEAL1, meal);
    }

    @Test(expected= NotFoundException.class)
    public void getAlienMeal() throws Exception {
        Meal meal = service.get(MEAL1.getId(), ADMIN_ID);
        assertEquals(MEAL1, meal);
    }

    @Test
    public void delete() throws Exception {
        int sizeBefore = service.getAll(USER_ID).size();
        service.delete(MEAL1.getId(), USER_ID);
        assertEquals(sizeBefore - 1, service.getAll(USER_ID).size());
    }

    @Test
    public void getBetweenDates() throws Exception {
    }

    @Test
    public void getBetweenDateTimes() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        List<Meal> meals = service.getAll(USER_ID);
        assertEquals(Arrays.asList(MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1), meals);
    }

    @Test
    public void update() throws Exception {
        Meal mealUpdate = new Meal(MEAL1);
        mealUpdate.setDescription("New Description");
        Meal updatedMeal = service.update(mealUpdate, USER_ID);
        assertEquals(mealUpdate, updatedMeal);
    }

    @Test
    public void create() throws Exception {
        Meal newMeal = new Meal(LocalDateTime.of(2016, Month.MAY, 30, 10, 0), "Завтрак", 500);
        service.create(newMeal, USER_ID);
        assertEquals(Arrays.asList(newMeal, MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1), service.getAll(USER_ID));
    }

    @Test(expected = DuplicateKeyException.class)
    public void createMealWithSameDateTime() throws Exception {
        Meal newMeal = new Meal(MEAL1);
        newMeal.setId(null);
        service.create(newMeal, USER_ID);
        assertEquals(Arrays.asList(newMeal, MEAL6, MEAL5, MEAL4, MEAL3, MEAL2, MEAL1), service.getAll(USER_ID));
    }

}