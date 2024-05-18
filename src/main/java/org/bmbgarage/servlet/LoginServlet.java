package org.bmbgarage.servlet;

import org.bmbgarage.dao.Database;
import org.bmbgarage.dao.ClientDao;
import org.bmbgarage.domain.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static org.bmbgarage.util.ErrorUtils.sendError;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");

        try {
            Database.connect();
            Client client = Database.jdbi.withExtension(ClientDao.class, dao -> dao.getClient(username, userpassword));
            if (client != null) {
                HttpSession session = request.getSession();
                session.setAttribute("id", client.getId());
                session.setAttribute("username", client.getUsername());
                session.setAttribute("role", client.getRol());
                response.getWriter().print("ok");
            } else {
                sendError("El usuario no existe", response);
            }
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error", response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos", response);
        }
    }
}
