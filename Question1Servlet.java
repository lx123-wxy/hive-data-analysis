package controll;

import beans.book;
import com.alibaba.fastjson.JSON;
import dao.BookDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Question1Servlet", value = "/Question1Servlet")
public class Question1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            BookDao bookDao = new BookDao();
            String query1 = "select yearofpublication, count(*) from (select * from books where yearofpublication<=1999 and yearofpublication>=1990)a group by yearofpublication";
            try {
                List<book> books1 = bookDao.Solution1(query1);
                String str = JSON.toJSONString(books1);
                System.out.println(str);
                response.getWriter().write(str);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
