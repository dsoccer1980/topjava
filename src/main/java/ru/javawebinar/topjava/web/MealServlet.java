package ru.javawebinar.topjava.web;


import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.repository.InMemoryMealRepository;
import ru.javawebinar.topjava.repository.MealRepository;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


public class MealServlet extends HttpServlet {
    MealRepository repository;

    public MealServlet() {
        super();
        this.repository = new InMemoryMealRepository();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equalsIgnoreCase("add")) {
                String description = request.getParameter("description");
                LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("datetime"));
                int calories = Integer.parseInt(request.getParameter("calories"));
                repository.add(new Meal(dateTime, description, calories));
            } else if (action.equalsIgnoreCase("update")) {
                String description = request.getParameter("description");
                LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("datetime"));
                int calories = Integer.parseInt(request.getParameter("calories"));
                int id = Integer.parseInt(request.getParameter("id"));
                repository.update(id, new Meal(id, dateTime, description, calories));
            }
        }

        request.setAttribute("mealWithExceedList", repository.getAll());
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");


        String action = request.getParameter("action");

        if (action != null) {

            if (action.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                repository.delete(id);
            } else if (action.equalsIgnoreCase("update")) {
                int id = Integer.parseInt(request.getParameter("id"));

                request.setAttribute("meal", repository.get(id));
                request.getRequestDispatcher("/mealCreate.jsp").forward(request, response);
                return;
            }
        }

        request.setAttribute("mealWithExceedList", repository.getAll());
        request.getRequestDispatcher("/meals.jsp").forward(request, response);

    }
}
