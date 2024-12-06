package mk.ukim.finki.webaud.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="goodbye",urlPatterns = "/goodbye")
public class GoodByeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        String surname=req.getParameter("surname");
        PrintWriter writer=resp.getWriter();
        writer.format("<html><head></head><body><h1>DOVIDUVANJE %s %s! </h1></body></html>",name, surname);
        writer.flush();
    }
}
