package servlet;

import model.User;
import service.FileService;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.File;
import java.io.IOException;

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");

        User user = new User(name, email);
        String filePath = getServletContext().getRealPath("/data/users.txt");

        File file = new File(filePath);
        file.getParentFile().mkdirs(); // create folder if missing
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }


        FileService.addUser(user, filePath);

        response.sendRedirect("viewUsers");
    }
}
