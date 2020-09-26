package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ArithmeticCalculatorServlet", urlPatterns = {"/arithmetic"})
public class ArithmeticCalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("resultMessage", "---");

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String string1 = request.getParameter("first_number");
        String string2 = request.getParameter("second_number");

        request.setAttribute("firstNum", string1);
        request.setAttribute("secondNum", string2);

        if (string1 == null || string1.equals(" ") || string1.equals("") || string2 == null
                || string2.equals(" ") || string2.equals("")) {

            request.setAttribute("resultMessage", "invalid");

            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;

        } else if (!string1.matches("[0123456789]*") || !string2.matches("[0123456789]*")) {

            request.setAttribute("resultMessage", "invalid");

            getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
            return;
        }

        int parsedNum1 = Integer.parseInt(string1);
        int parsedNum2 = Integer.parseInt(string2);

        if (request.getParameter("addition") != null) {

            request.setAttribute("resultMessage", add(parsedNum1, parsedNum2));

        } else if (request.getParameter("subtraction") != null) {

            request.setAttribute("resultMessage", subtract(parsedNum1, parsedNum2));

        } else if (request.getParameter("multiplication") != null) {

            request.setAttribute("resultMessage", multiply(parsedNum1, parsedNum2));

        } else if (request.getParameter("modulus") != null) {

            request.setAttribute("resultMessage", mod(parsedNum1, parsedNum2));
        }

        getServletContext().getRequestDispatcher("/WEB-INF/arithmeticcalculator.jsp").forward(request, response);
    }

    protected int add(int num1, int num2) {
        return num1 + num2;
    }

    protected int subtract(int num1, int num2) {
        return num1 - num2;
    }

    protected int multiply(int num1, int num2) {
        return num1 * num2;
    }

    protected int mod(int num1, int num2) {
        return num1 % num2;
    }

}
