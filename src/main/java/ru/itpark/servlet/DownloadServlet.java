package ru.itpark.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.setHeader("Content-disposition","inline; filename=results.txt");

        String appPath = req.getServletContext().getRealPath("");
        String filePath = appPath + "result\\results.txt";
        File resultFile = new File(filePath);

        OutputStream os = resp.getOutputStream();
        FileInputStream is = new FileInputStream(resultFile);
        byte[] buffer = new byte[4096];
        int length;

        while ((length = is.read(buffer)) > 0){
            os.write(buffer, 0, length);
        }

        // освободить ресурсы
        is.close();
        os.flush();
        //
        //use inline if you want to view the content in browser, helpful for pdf file
        //response.setHeader("Content-Disposition","inline; filename=\"" + filename + "\"");

    }

}

