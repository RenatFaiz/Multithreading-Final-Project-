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
public class Servlet extends HttpServlet {

    public static final String SAVE_DIRECTORY = "upload";

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        // Gets absolute path to root directory of web app.
        String appPath = req.getServletContext().getRealPath("");
//        appPath = appPath.replace('\\', '/');

        // The directory to save uploaded file
        String fullSavePath = appPath + SAVE_DIRECTORY;
        Path uploadPath = Paths.get(fullSavePath);
        Files.createDirectories(uploadPath);

        for (Part part : req.getParts()) {
            String fileName = part.getSubmittedFileName();
            //if (part.getSubmittedFileName().startsWith("filename"))
            if (fileName != null && fileName.length() > 0) {
                System.out.println("Write attachment to file: " + fileName);
                String filePath = fullSavePath + "/" + fileName;
                part.write(filePath);
            }
        }

        final FileVisitor2 visitor2 = new FileVisitor2();

        String textForSearch = req.getParameter("text");
        System.out.println(textForSearch);
        visitor2.setSearchString(textForSearch);
        Files.walkFileTree(uploadPath, visitor2);

//        //PrintWriter writer = resp.getWriter();
//
//        int wordsCounter = visitor2.getWordsCounter();
//        req.setAttribute("counter", wordsCounter);
//        List<String> results = visitor.getResult();
//        req.setAttribute("results", results);
        getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);

//        String page = "/result.jsp";
//        ServletContext context = getServletContext();
//        RequestDispatcher dispatcher = context.getRequestDispatcher(page);
//        dispatcher.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
