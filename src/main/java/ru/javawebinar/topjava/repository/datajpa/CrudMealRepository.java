package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.List;

public interface CrudMealRepository extends JpaRepository<Meal, Integer> {

    @Override
    @Transactional
    Meal save(Meal meal);

    Meal getByIdAndUserId(Integer id, Integer userId);

    @Transactional
    @Modifying
    @Query(name = Meal.DELETE)
    int delete(@Param("id") int id, @Param("userId") int userId);

    List<Meal> findByDateTimeBetweenAndUserId(LocalDateTime startDate, LocalDateTime endDate, Integer userId, Sort sort);

    List<Meal> findAllByUserId(Integer userId, Sort sort);

}
