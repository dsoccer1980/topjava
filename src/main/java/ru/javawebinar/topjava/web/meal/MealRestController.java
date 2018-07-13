package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.AuthorizedUser;
import ru.javawebinar.topjava.model.Meal;

import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;


    public List<MealWithExceed> getAll() {
        log.info("getAll");
        int userId = AuthorizedUser.id();
        return service.getAll(userId);
    }

    public Meal get(int id) {
        log.info("get Meal with id=" + id);
        int userId = AuthorizedUser.id();
        return service.get(id, userId);
    }

    public List<MealWithExceed> getByDate(LocalDate startDate, LocalTime startTime, LocalDate endDate, LocalTime endTime) {
        log.info("getAll");
        int userId = AuthorizedUser.id();
        return service.getBetween(startDate, startTime, endDate, endTime, userId);
    }

    public Meal create(Meal meal) {
        log.info("create Meal " + meal);
        int userId = AuthorizedUser.id();
        checkNew(meal);
        return service.create(meal, userId);
    }

    public Meal update(Meal meal, int id) {
        log.info("update Meal " + meal);
        int userId = AuthorizedUser.id();
        assureIdConsistent(meal, id);
        return service.update(meal, userId);
    }

    public void delete(int id) {
        log.info("delete Meal with id=" + id);
        int userId = AuthorizedUser.id();
        service.delete(id, userId);
    }

}