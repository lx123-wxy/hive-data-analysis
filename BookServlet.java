package controll;

import beans.book;
import dao.BookDao;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet",
        value = "/BookServlet"
        )
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Value = request.getParameter("value");
        if(Value.equals("s2")){
            BookDao bookDao = new BookDao();
            String query2 = "select books.title, ratings.rating from books join ratings on books.isbn = ratings.isbn order by ratings.rating desc limit 10";
            try {
                List<book> books2 = bookDao.Solution2(query2);
                request.setAttribute("books2", books2);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Main.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(Value.equals("s3")){
            BookDao bookDao = new BookDao();
            String query3 = "select books.title, books.author, ratings.rating from books join ratings on books.isbn = ratings.isbn order by ratings.rating desc limit 10";
            try {
                List<book> books3 = bookDao.Solution3(query3);
                request.setAttribute("books3", books3);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Main.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(Value.equals("s4")){
            BookDao bookDao = new BookDao();
            String query4 = "select author, count(*) from ( select * from books where yearofpublication<=2009 and yearofpublication>=2000)a group by author limit 50";
            try {
                List<book> books4 = bookDao.Solution4(query4);
                request.setAttribute("books4", books4);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Main.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(Value.equals("s5")){
            BookDao bookDao = new BookDao();
            String query5 = "select publisher, count(*) from (select books.publisher from books join ratings on books.isbn = ratings.isbn where ratings.rating>5)a group by publisher limit 5";
            try {
                List<book> books5 = bookDao.Solution5(query5);
                request.setAttribute("books5", books5);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Main.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(Value.equals("s6")){
            BookDao bookDao = new BookDao();
            String query6 = "select title, author from( select books.title, books.author from books join ratings on books.isbn = ratings.isbn where ratings.rating>4 and books.yearofpublication>=1995 and books.yearofpublication<=2004)a where length(author)<=20 or length(title)<=20 limit 20";
            try {
                List<book> books6 = bookDao.Solution6(query6);
                request.setAttribute("books6", books6);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Main.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
