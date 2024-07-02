package uz.pdp.lesson.demo2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import uz.pdp.lesson.demo2.file.File;
import uz.pdp.lesson.demo2.file.FileService;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "DownloadServlet", urlPatterns = "/downloadPage")
@MultipartConfig
public class DownloadServlet extends HttpServlet {
    private final FileService fileService = new FileService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int fileId = Integer.parseInt(request.getParameter("fileId"));
        File file = fileService.getFileById(fileId);

        if (Objects.nonNull(file)) {
            response.addHeader("Content-Type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getOriginalName());
            response.getOutputStream().write(file.getFileData());
        } else {
            response.getWriter().println("File not found!");
        }
    }
}
