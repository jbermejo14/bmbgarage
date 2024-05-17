package org.bmbgarage.servlet;

import org.bmbgarage.dao.CarDao;
import org.bmbgarage.dao.Database;
import org.bmbgarage.dao.UserDao;
import org.bmbgarage.domain.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static org.bmbgarage.util.ErrorUtils.sendError;


@WebServlet("/signup")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String role = "user";

        try {
            Database.connect();
            Database.jdbi.withExtension(UserDao.class, dao -> dao.addUser(username, email, phonenumber, userpassword, role));
            User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(username, userpassword));
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
            response.getWriter().print("ok");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error", response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos", response);
        }
    }
}
