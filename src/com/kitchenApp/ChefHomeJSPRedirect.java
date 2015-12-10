package com.kitchenApp;

import com.kitchenApp.database.dataAccess.RecipeDao;
import org.apache.log4j.Logger;

import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;

/**
 * @author afaherty
 * Date: 10/14/2015
 */
@WebServlet(
        name = "chefHome",
        urlPatterns = {"/chef"}
)

/**
 * redirect class for chef.jsp page
 */
public class ChefHomeJSPRedirect extends HttpServlet {

    private final Logger log = Logger.getLogger(ChefHomeJSPRedirect.class);
    /**
     *
     * @param request HttpServletRequest object
     * @param response HttpServletResponse object
     * @throws ServletException if there is a servlet error
     * @throws IOException if there is an input output error
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        displayRecipeList(request);
        String url = "/chef/chef.jsp";

        log.info("Accessing: " + url);

        response.sendRedirect(url);
    }

    /** Retrieves user list to display to the web page
     * @param request HttpServletRequest object
     */
    public void displayRecipeList(HttpServletRequest request) {

        ServletContext context = getServletContext();
        RecipeDao recipeDao = new RecipeDao();

        HttpSession session = request.getSession();

        session.setAttribute("displayRecipes", recipeDao.getRecipeList());

        log.info("loading recipe list");
    }
}
