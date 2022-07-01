package controll;

import beans.User;
import dao.Dao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao=new Dao();
        String name= request.getParameter("name");
        String pwd= request.getParameter("pwd");
        User user = new User();
        user.setName(name);
        try {
            if(dao.UserExists(user.getName())){
                String datapwd = dao.LoginUser(user);
                if(datapwd.equals(pwd)){
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
                    requestDispatcher.forward(request, response);
                }else{
                    request.setAttribute("Password", "password is wrong");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
                    requestDispatcher.forward(request, response);
                }
            }else{
                request.setAttribute("not exist", "not exist");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
                requestDispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
