package ru.javawebinar.topjava.service;



import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.Profiles;


@ActiveProfiles(Profiles.JDBC)
public class MealJDBCServiceTest extends MealServiceTest {

}