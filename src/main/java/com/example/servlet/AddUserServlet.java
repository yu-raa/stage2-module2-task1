package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        User user = new User((String)req.getAttribute("firstName"), (String)req.getAttribute("lastName"));
        if (user.getFirstName() != null && user.getLastName() != null) {
            Warehouse.getInstance().addUser(user);
        }
        resp.addHeader("user", (String)req.getAttribute("user"));
    }
}
