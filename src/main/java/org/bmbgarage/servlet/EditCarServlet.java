package org.bmbgarage.servlet;
import org.bmbgarage.dao.CarDao;
import org.bmbgarage.dao.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;

import static org.bmbgarage.util.ErrorUtils.sendError;
import static org.bmbgarage.util.ErrorUtils.sendMessage;

@WebServlet("/edit-car")
@MultipartConfig
public class EditCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession currentSession = request.getSession();
        if (currentSession.getAttribute("role") != null) {
            if (!currentSession.getAttribute("role").equals("admin")) {
                response.sendRedirect("/bmbgarage");
            }
        }

        try {
            int id = 0;
            if (request.getParameter("id") != null) {
                id = Integer.parseInt(request.getParameter("id"));
            }

            String licenseplate = request.getParameter("licenseplate");
            String brand = request.getParameter("brand");
            String carmodel = request.getParameter("carmodel");
            int dateregistration = 2024;
            float price = Float.parseFloat(request.getParameter("price"));

            String finalFilename2 = "no-photo.png";
            Database.connect();

            int affectedRows = Database.jdbi.withExtension(CarDao.class,
                    dao -> dao.addCar(licenseplate, brand, carmodel, dateregistration, price, finalFilename2));
            sendMessage("Coche registrado correctamente", response);

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error", response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos", response);
        }
    }
}
