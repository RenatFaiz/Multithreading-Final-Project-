package ru.itpark.servlet;

import ru.itpark.service.FileVisitor;

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
import java.util.LinkedList;
import java.util.List;

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
            String resultFilePath = fullResultDirectory + "/" + resultFile;
            Path resultFileP = Paths.get(resultFilePath);
            Files.deleteIfExists(resultFileP);

            List<String> files = new LinkedList<>();
            for (Part part : req.getParts()) {

                String fileName = part.getSubmittedFileName();
                if (fileName != null && fileName.length() > 0) {
                    String filePath = fullSavePath + "/" + fileName;
                    part.write(filePath);
                    files.add(part.getSubmittedFileName());
                }
            }

            // Searching through downloaded files
            final FileVisitor visitor = new FileVisitor();
            String textForSearch = req.getParameter("text");
            visitor.setSearchString(textForSearch);
            Files.walkFileTree(uploadPath, visitor);

            req.setAttribute("counter", visitor.getMatchesCounter());
            req.setAttribute("files", files);
            getServletContext().getRequestDispatcher("/result.jsp").forward(req, resp);

        } catch (ServletException | IOException e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/error");
            throw new ServletException(e);
        }
    }
}
