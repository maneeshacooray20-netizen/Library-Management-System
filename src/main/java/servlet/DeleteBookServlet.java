package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String filePath = getServletContext().getRealPath("/data/books.txt");

        File inputFile = new File(filePath);
        File tempFile = new File(getServletContext().getRealPath("/data/temp.txt"));

        String bookName = request.getParameter("name");

        if (bookName == null) {
            response.sendRedirect("viewBooks");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(inputFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

        String line;

        while ((line = br.readLine()) != null) {

            if (line.trim().isEmpty()) continue;

            String[] data = line.split(",");

            if (data.length >= 1) {
                String currentBook = data[0];

                if (!currentBook.equals(bookName)) {
                    bw.write(line);
                    bw.newLine();
                }
            }
        }

        br.close();
        bw.close();

        inputFile.delete();
        tempFile.renameTo(inputFile);

        response.sendRedirect("viewBooks");
    }
}