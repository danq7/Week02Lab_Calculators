package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgeCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String age = request.getParameter("age_input");

        if (age == null || age.equals(" ") || age.equals("") || age.equals("0")) {

            request.setAttribute("age_message", "You must give your current age.");

            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;

        } else if (!age.matches("[0123456789]*")) {

            request.setAttribute("age_message", "You must enter a number.");

            getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
            return;
        }

        int parsedAge = 0;

        try {

            parsedAge = Integer.parseInt(age);

        } catch (Exception e) {

            request.setAttribute("age_message", "You must enter a number.");
        }

        int nextBDay = parsedAge + 1;

        request.setAttribute("age_message", "Your age next birthday will be " + nextBDay);

        getServletContext().getRequestDispatcher("/WEB-INF/agecalculator.jsp").forward(request, response);
    }

}
