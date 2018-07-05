package ru.javawebinar.topjava.web;


import ru.javawebinar.topjava.repository.InMemoryMealRepository;
import ru.javawebinar.topjava.repository.MealRepository;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class MealServlet extends HttpServlet {
    MealRepository repository;

    public MealServlet() {
        super();
        this.repository = new InMemoryMealRepository();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action = request.getParameter("action");

        if (action != null ) {

            if (action.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                repository.delete(id);
            }
        }

        request.setAttribute("mealWithExceedList", repository.getAll());
        request.getRequestDispatcher("/meals.jsp").forward(request, response);

    }
}
