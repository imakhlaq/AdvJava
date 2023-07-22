package test;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/test"},loadOnStartup = 1)
public class DemoServlet extends HttpServlet {

    public void init(){}

    public void service(HttpServletRequest request,
                        HttpServletResponse response){
        System.out.println("Controller fired");
    }

    public void destroy(){

    }
}
