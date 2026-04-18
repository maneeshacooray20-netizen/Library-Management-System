package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/viewUsers")
public class ViewUserServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filePath = getServletContext().getRealPath("/data/users.txt");

        File file = new File(filePath);
        file.getParentFile().mkdirs(); // create folder if missing
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        List<String> users = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine()) != null) {
            users.add(line);
        }

        br.close();

        request.setAttribute("users", users);
        request.getRequestDispatcher("viewUsers.jsp").forward(request, response);
    }
}
