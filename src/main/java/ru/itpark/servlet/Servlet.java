package ru.itpark.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/search")
public class Servlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//        resp.setContentType("text/html");
//
//        String path = "/index.html";
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(path);
//        dispatcher.forward(req, resp);
//
//    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        String text = req.getParameter("text");
        String file = req.getParameter("file");

        // req.getRequestDispatcher("/index.jsp").forward(req, resp);
//        if (text == null && file == null) {
//            String path = req.getContextPath() + "/notfound";
//            resp.sendRedirect(path);
//        }

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("<p>Searching text: " + text + "</p>");
            writer.println("<p>File for search: " + file + "</p>");

        }
    }

}
