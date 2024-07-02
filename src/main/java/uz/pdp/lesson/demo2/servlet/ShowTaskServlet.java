package uz.pdp.lesson.demo2.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.lesson.demo2.todo.Todo;
import uz.pdp.lesson.demo2.todo.TodoService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowTaskServlet", value = "/showTask")
public class ShowTaskServlet extends HttpServlet {
    private TodoService toDoService = new TodoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Todo> todos = toDoService.getAll();
        List<Todo> list = todos.stream().filter(todo -> todo.getOwner_id() == LoginServlet.USER.getId()).toList();
        req.setAttribute("todoList", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/showTask.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
