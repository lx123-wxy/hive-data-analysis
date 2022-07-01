package controll;

import beans.User;
import dao.Dao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dao dao=new Dao();
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String date = request.getParameter("date");
        String sex = request.getParameter("sex");
        User user = new User();
        user.setName(name);
        user.setPassword(pwd);
        user.setDate(date);
        user.setSex(sex);
        try {
            dao.registrationUser(user);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
