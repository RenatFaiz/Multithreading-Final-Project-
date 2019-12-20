package ru.itpark.servlet;

import ru.itpark.service.FileVisitor2;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/search")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 3,
        maxRequestSize = 1024 * 1024 * 4)
public class MainServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setContentType("text/html");

            // Gets absolute path to root directory of web app.
            String appPath = req.getServletContext().getRealPath("");
//        appPath = appPath.replace('\\', '/');
            System.out.println("Директория приложения " + appPath);
//        System.out.println(getServletContext());
//        System.out.println(getServletConfig());
//        ServletContext context = getServletContext();
//        System.out.println(context.getInitParameterNames());

            // The directory to save uploaded file
            final String saveDirectory = "upload";
            String fullSavePath = appPath + saveDirectory;
            Path uploadPath = Paths.get(fullSavePath);
            Files.createDirectories(uploadPath);

            // The directory to results folder
            final String resultDirectory = "result";
            String fullResultDirectory = appPath + resultDirectory;
            Path resultPath = Paths.get(fullResultDirectory);
            Files.createDirectories(resultPath);


            // Path to file with searching results
            final String resultFile = "results.txt";
            String resultFilePath = fullResultDirectory + "\\" + resultFile;
            Path resultFileP = Paths.get(resultFilePath);
            System.out.println("Путь к файлу c результатами: " + resultFilePath);
            Files.deleteIfExists(resultFileP);


            for (Part part : req.getParts()) {
                String fileName = part.getSubmittedFileName();
                //if (part.getSubmittedFileName().startsWith("filename"))
                if (fileName != null && fileName.length() > 0) {
                    System.out.println("Write attachment to file: " + fileName);
                    String filePath = fullSavePath + "\\" + fileName;
                    part.write(filePath);
                }
            }

            final FileVisitor2 visitor2 = new FileVisitor2();
            String textForSearch = req.getParameter("text");
            System.out.println("Searching text: " + textForSearch);

            visitor2.setSearchString(textForSearch);
            Files.walkFileTree(uploadPath, visitor2);

            req.setAttribute("counter", visitor2.getMatchesCounter());
            getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/notfound");
            throw new ServletException(e);
        }

    }

}
