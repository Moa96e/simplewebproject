package it.iagica.servlet;

import it.iagica.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static it.iagica.CustomerManager.getUser;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("It works the doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Customer user = getUser(username);
        System.out.println(user);
        RequestDispatcher rd = null;
        if(user != null && (user.getUsername().equals(username) && user.getPassword().equals(password))){
            req.setAttribute("username",user.getFirstName());
            rd = req.getRequestDispatcher("result.jsp");

        }
        else {
            rd = req.getRequestDispatcher("error.jsp");
        }
        rd.forward(req,resp);

    }
}
