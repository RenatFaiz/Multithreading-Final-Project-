package ru.itpark.servlet;

import ru.itpark.service.FileVisitor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@WebServlet("/search")
public class Servlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        final FileVisitor visitor = new FileVisitor();
        Path path = Paths.get("D:\\Coding\\Destination");
        Path path1 = Paths.get("Destination/").toAbsolutePath();

        String textForSearch = req.getParameter("text");
        System.out.println(textForSearch);
        visitor.setSearchString(textForSearch);

        //PrintWriter writer = resp.getWriter();
        Files.walkFileTree(path, visitor);
        List<String> results = visitor.getResult();
        req.setAttribute("results", results);
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
