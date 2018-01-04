package mk.ukim.finki.wp.demo.web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Listener implements ServletRequestListener{
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request Destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request Initialized");
    }
}
