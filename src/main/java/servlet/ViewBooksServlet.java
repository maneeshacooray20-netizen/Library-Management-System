package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/viewBooks")
public class ViewBooksServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filePath = getServletContext().getRealPath("/data/books.txt");
        List<String> books = new ArrayList<>();

        File file = new File(filePath);

// ✅ Prevent crash if file doesn't exist
        if (!file.exists()) {
            file.createNewFile();
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) {   // avoid empty lines
                books.add(line);
            }
        }

        br.close();

        request.setAttribute("books", books);
        request.getRequestDispatcher("viewBooks.jsp").forward(request, response);
    }
}
