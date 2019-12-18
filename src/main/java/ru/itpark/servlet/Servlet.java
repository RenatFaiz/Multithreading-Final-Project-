package ru.itpark.servlet;

import ru.itpark.service.FileVisitor;
import ru.itpark.service.FileVisitor2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        Path path = Paths.get("D:\\Coding\\Destination");
        Path path1 = Paths.get("Destination/").toAbsolutePath();

        // Gets absolute path to root directory of web app.
        String appPath = req.getServletContext().getRealPath("");
//        appPath = appPath.replace('\\', '/');

        // The directory to save uploaded file
        String fullSavePath = appPath + SAVE_DIRECTORY;
//        if (appPath.endsWith("\"")) {
//            fullSavePath = appPath + SAVE_DIRECTORY;
//        } else {
//            fullSavePath = appPath + "/" + SAVE_DIRECTORY;
//        }

        // Creates the save directory if it does not exists
        File fileSaveDir = new File(fullSavePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }


//        final FileVisitor visitor = new FileVisitor();
//        final FileVisitor2 visitor2 = new FileVisitor2();
//
//        String textForSearch = req.getParameter("text");
//        System.out.println(textForSearch);
//        visitor2.setSearchString(textForSearch);
//
//        //PrintWriter writer = resp.getWriter();
//        Files.walkFileTree(path, visitor2);
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
