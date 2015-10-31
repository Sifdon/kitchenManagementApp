package com.kitchenApp;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

/**
 * @author afaherty
 * Date: 10/14/2015
 */
@WebServlet(
        name = "dishHome",
        urlPatterns = {"/dishwasher"}
)
public class DishHomeJSPRedirect extends HttpServlet {

    /**
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/dish/dish.jsp";
        response.sendRedirect(url);
    }
}
