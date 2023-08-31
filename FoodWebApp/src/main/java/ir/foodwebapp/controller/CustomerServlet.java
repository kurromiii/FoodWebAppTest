package ir.foodwebapp.controller;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "customer", value = "/customer")
public class CustomerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter out = resp.getWriter();

        out.println(CustomerController.getCustomerController().add(
                req.getParameter("First Name"),
                req.getParameter("Last Name"),
                req.getParameter("Phone Number")));
    }

    public void destroy() {
    }
}