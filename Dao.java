package dao;

import beans.User;

import java.sql.*;

public class Dao {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    public static String url = "jdbc:mysql://localhost:3306/bookpro?serverTimeZone=UTC";
    public static String userName = "root";
    public static String passWord = "lixu20020224";

    public Dao(){

    }
    public static Connection getConnection() throws SQLException {
        Connection connection = null;

        try {
            String driverName = "com.mysql.cj.jdbc.Driver";
            Class.forName(driverName);
        } catch (ClassNotFoundException var2) {
            var2.printStackTrace();
        }
        connection = DriverManager.getConnection(url, userName, passWord);

        return connection;
    }
    public void registrationUser(User user) throws SQLException {
        try (Connection connection = getConnection()) {
            String sql = "insert into User (User_Name, User_Pwd, User_Date, User_Sex) values (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getDate());
            preparedStatement.setString(4,user.getSex());
            preparedStatement.executeUpdate();
        } catch (SQLException var9) {
            var9.printStackTrace();
        } finally {
            if(resultSet != null){
                resultSet.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(!getConnection().isClosed()){
                getConnection().close();
            }
        }
    }
    public String LoginUser(User user) throws SQLException {
            try (Connection connection = getConnection()) {
                String sql = "select * from User where User_Name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,user.getName());
                System.out.println(user.getName());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()){
                    return resultSet.getString("User_Pwd");
                }
            } catch (SQLException var9) {
                var9.printStackTrace();
            } finally {
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
                if(!getConnection().isClosed()){
                    getConnection().close();
                }
            }
        return "not exist";
    }
    public boolean UserExists(String Name) throws SQLException {

        try (Connection connection = getConnection()) {
            String sql = "select * from User where User_Name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException var9) {
            var9.printStackTrace();
        } finally {
           if(resultSet != null){
               resultSet.close();
           }
           if(preparedStatement != null){
               preparedStatement.close();
           }
           if(!getConnection().isClosed()){
               getConnection().close();
           }
        }
        return false;
    }
}
