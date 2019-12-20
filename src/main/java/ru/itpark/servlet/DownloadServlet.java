package ru.itpark.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String appPath = req.getServletContext().getRealPath("");
        String filePath = appPath + "result\\results.txt";
        String notFound = req.getContextPath() + "/notfound";

        try (FileReader reader = new FileReader(filePath)) {
            resp.setContentType("text/plain");
            resp.setHeader("Content-disposition", "inline; filename=results.txt");
            PrintWriter writer = resp.getWriter();
            int length;
            while ((length = reader.read()) != -1) {
                writer.write(length);
            }
            reader.close();
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
            resp.sendRedirect(notFound);
            throw new IOException(e);
        }

    }
}

// Content Types: application/pdf, text/plain, text/html, image/jpg
// response.setContentType("ТИП_ДАННЫХ_MIME");
//response.setHeader("Content-disposition","attachment; filename=ВАШЕ_КАСТОМНОЕ_ИМЯ_ФАЙЛА.ext");

//use inline if you want to view the content in browser (helpful for pdf file)
// or to download only "Content-Disposition","attachment;
//response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\"");