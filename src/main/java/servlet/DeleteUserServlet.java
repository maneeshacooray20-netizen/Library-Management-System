package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{

        String emailToDelete = request.getParameter("email");

        String filePath = getServletContext().getRealPath("/data/users.txt");

        File file = new File(filePath);
        file.getParentFile().mkdirs(); // create folder if missing
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }

        List <String> users = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = br.readLine())!= null){
            if (!line.contains(emailToDelete)){
                users.add(line);
            }
        }

        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for (String user : users){
            bw.write(user);
            bw.newLine();
        }

        bw.close();

        response.sendRedirect("viewUsers");
    }
}
