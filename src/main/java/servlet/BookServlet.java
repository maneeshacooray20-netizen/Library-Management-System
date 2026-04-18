package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/addBook")
public class BookServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException {

        String name = request.getParameter("name");
        String author = request.getParameter("author");

        String filePath = getServletContext().getRealPath("/data/books.txt");

        FileWriter fw = new FileWriter(filePath, true);
        fw.write(name + ", " + author + "\n");
        fw.close();

        response.sendRedirect("viewBooks");
    }
}
