package am.itspace.myfriend.servlet;


import am.itspace.myfriend.model.User;
import am.itspace.myfriend.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = userService.grtByEmailAndPassword(req.getParameter("email"), req.getParameter("password"));
        if (user != null) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/");
        }else {
            req.setAttribute("msg", "Invalid email or password");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }
    }
}
