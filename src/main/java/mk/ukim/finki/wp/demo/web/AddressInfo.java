package mk.ukim.finki.wp.demo.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/AddressInfo.do")
public class AddressInfo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String infoPizzaName = req.getParameter("infoName");
        String infoAddress = req.getParameter("infoAddress");
        HttpSession httpSession = req.getSession();
        httpSession.setAttribute("pizzaName", infoPizzaName);
        httpSession.setAttribute("infoAddress", infoAddress);
        System.out.println("Servlet toString = " + toString());
        //resp.sendRedirect("/Confirmation.html");
        PrintWriter out = resp.getWriter();
//        try(ServletOutputStream out = resp.getOutputStream()){
            out.print("<html><h2>Confirmation</h2></br>");
            out.print("<div>");
            out.print("<label>Pizza name: </label>" + "<label>" + httpSession.getAttribute("pizzaName") + "</label></br>");
            out.print("<label>Pizza size: </label>" + "<label>" + httpSession.getAttribute("size") + "</label></br>");
            out.print("<label>Address   : </label>" + httpSession.getAttribute("infoAddress") + "</label></br>");
            out.print("</div></html>");
            //  }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Inicijaliziram AddressInfo servlet::");
        super.init();
    }

    @Override
    public void destroy() {
        System.out.println("Destroy AddressInfo servlet::");
        super.destroy();
    }
}
