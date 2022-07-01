package dao;
import beans.book;
import beans.ratings;
import org.apache.hive.jdbc.HiveDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    public Connection getConnection() throws SQLException {
        try {
            String driverClass = "org.apache.hive.jdbc.HiveDriver";
            Class.forName(driverClass);
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
            System.exit(1);
        }
        Connection connection = DriverManager.getConnection("jdbc:hive2://Hadoop01:10000/project","root","Lixu20020224!");
        return connection;
    }

    public List Solution1(String query) throws SQLException {

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Running: " + query);
        List<book> books = new ArrayList<>();
        while(resultSet.next()){
            book book = new book();
            book.setYearofpublication(resultSet.getInt(1));
            book.setCount(resultSet.getInt(2));
            books.add(book);
        }
        resultSet.close();

        statement.close();

        connection.close();

        return books;
    }
    public List Solution2(String query) throws SQLException {

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Running: " + query);
        List<Object> together = new ArrayList<>();
        while(resultSet.next()){
            together.add(resultSet.getString(1));
            together.add(resultSet.getInt(2));
        }
        resultSet.close();

        statement.close();

        connection.close();

        return together;
    }
    public List Solution3(String query) throws SQLException {

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Running: " + query);
        List<Object> together = new ArrayList<>();
        while(resultSet.next()){
            together.add(resultSet.getString(1));
            together.add(resultSet.getString(2));
            together.add(resultSet.getInt(3));
        }
        resultSet.close();

        statement.close();

        connection.close();

        return together;
    }
    public List Solution4(String query) throws SQLException {

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Running: " + query);
        List<book> books = new ArrayList<>();
        while(resultSet.next()){
            book book = new book();
            book.setAuthor(resultSet.getString(1));
            book.setCount(resultSet.getInt(2));
            books.add(book);
        }
        resultSet.close();

        statement.close();

        connection.close();

        return books;
    }
    public List Solution5(String query) throws SQLException {

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Running: " + query);
        List<book> books = new ArrayList<>();
        while(resultSet.next()){
            book book = new book();
            book.setPublisher(resultSet.getString(1));
            book.setCount(resultSet.getInt(2));
            books.add(book);
        }
        resultSet.close();

        statement.close();

        connection.close();

        return books;
    }
    public List<book> Solution6(String query) throws SQLException {

        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        System.out.println("Running: " + query);
        List<book> books = new ArrayList<>();
        while(resultSet.next()){
            book book = new book();
            book.setTitle(resultSet.getString(1));
            book.setAuthor(resultSet.getString(2));
            books.add(book);
        }
        resultSet.close();

        statement.close();

        connection.close();

        return books;
    }
//    public static void main(String[] args) throws SQLException {
//        String query1 = "select yearofpublication, count(*) from (select * from books where yearofpublication<=1999 and yearofpublication>=1990)a group by yearofpublication";
//        String query2 = "select books.title, ratings.rating from books join ratings on books.isbn = ratings.isbn order by ratings.rating desc limit 10";
//        String query3 = "select books.title, books.author, ratings.rating from books join ratings on books.isbn = ratings.isbn order by ratings.rating desc limit 10";
//        String query4 = "select author, count(*) from ( select * from books where yearofpublication<=2009 and yearofpublication>=2000)a group by author limit 50";
//        String query5 = "select publisher, count(*) from (select books.publisher from books join ratings on books.isbn = ratings.isbn where ratings.rating>5)a group by publisher limit 5";
//        String query6 = "select title, author from( select books.title, books.author from books join ratings on books.isbn = ratings.isbn where ratings.rating>4 and books.yearofpublication>=1995 and books.yearofpublication<=2004)a where length(author)<=20 or length(title)<=20 limit 20";
//        BookDao demoMain = new BookDao();
//        List<book> list1 = demoMain.Solution1(query1);
//        for(book book : list1){
//            System.out.println(book.getYearofpublication());
//            System.out.println(book.getCount());
//        }
//        List list2 = demoMain.Solution2(query2);
//        for(Object ignored : list2){
//            System.out.println(ignored.toString());
//        }
//        List list3 = demoMain.Solution3(query3);
//        for(Object object : list3){
//            System.out.println(object.toString());
//        }
//         List<book> list4 = demoMain.Solution4(query4);
//         for(book book : list4){
//             System.out.println(book.getAuthor());
//             System.out.println(book.getCount());
//         }
//        List<book> list5 = demoMain.Solution5(query5);
//         for(book book : list5){
//             System.out.println(book.getPublisher());
//             System.out.println(book.getCount());
//         }
//        List<book> list6 = demoMain.Solution6(query6);
//        for(book book : list6){
//            System.out.println(book.getTitle());
//            System.out.println(book.getAuthor());
//        }
//    }
}
