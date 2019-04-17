import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.net.*;
@WebServlet(name = "Servlet", urlPatterns = {"/add"})

public class Servlet extends HttpServlet {

    private ServletContext context;
    private PrintWriter out;

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        out = resp.getWriter();
        prepareForm(out);
        String[] nums = req.getParameterValues("num");
        if(nums.length == 2){
            try {

                int num1 = Integer.parseInt(nums[0]);
                int num2 = Integer.parseInt(nums[1]);
                int numout = num1+num2;
                String output = "" + numout;
                out.write(output);
            }catch (NumberFormatException e){
                out.write("STOP WASTING MY COMPUTING POWER ON INCORRECT INPUT, HUMAN");
            }
        }
        closeForm(out);
        out.close();
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req,resp);
    }

    public void prepareForm(PrintWriter out){
        out.write(
                "<html>" +
                        "<body>" +
                        "<form action = \"add\">" +
                        "First number: <input type = \"text\" name = \"num\">" +
                        "<br />" +
                        "Second number: <input type = \"text\" name = \"num\" />" +
                        "<br />" +
                        "<input type = \"submit\" formmethod=\"get\" value = \"GET\" />" +
                        "<br />" +
                        "<input type = \"submit\" formmethod=\"get\" value = \"POST\" />" +
                        "</form>" +
                        "_______________________________________________________________" +
                        "<br />"


        );
    }

    public void closeForm(PrintWriter out){
        out.write(  "</body>" +
                "</html>");
    }



}