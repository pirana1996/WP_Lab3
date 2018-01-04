package mk.ukim.finki.wp.demo.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PizzaOrder.do")
public class PizzaOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String size = req.getParameter("size");
        System.out.println("Pizza size: " + req.getParameter("size"));
        if(req.getSession(false) == null)
            System.out.println("Session created!");
        else
            System.out.println("Session already created!");

        req.getSession(true);
        req.getSession().setAttribute("size", size);
        resp.sendRedirect("/DeliveryInfo.html");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Inicijaliziram PizzaOrder servlet::");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("Destroy PizzaOrder servlet::");
        super.destroy();
    }
}
