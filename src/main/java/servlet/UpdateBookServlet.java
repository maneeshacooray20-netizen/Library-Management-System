package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;
import java.util.*;

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String oldAuthor = request.getParameter("oldAuthor");
        String newName = request.getParameter("name");
        String newAuthor = request.getParameter("author");

        String filePath = getServletContext().getRealPath("/data/books.txt");

        List <String> books= new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;

        while((line = br.readLine()) != null){
            if (line.contains(oldAuthor)){
                //replace with updated data
                books.add(newName + ", " + newAuthor);
            }
            else {
                books.add(line);
            }
        }

        br.close();

        //rewrite file
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        for (String book: books){
            bw.write(book);
            bw.newLine();
        }

        bw.close();

        response.sendRedirect("viewBooks");
    }

}
