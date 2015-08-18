/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class DataBaseInteface {
    public  static String DRIVER = "com.mysql.jdbc.Driver";
    //数据库名
    public  static String databasename = "";
    public  static String URL = "" ;
    public  static String USERNAME = "root";
    public  static String PASSWORD = "root";
    
    private Connection connection = null;
    private Statement statement = null;
    ResultSet rs = null;
    
     String sqlResult = "";
    
     public DataBaseInteface(String database){
         setDatabaseName( database);
     }
     
     void setDatabaseName(String database){
         databasename = database;
         URL = "jdbc:mysql://localhost:3306/" + databasename;
         updataConn();
     }
     
     // 获得数据库连接
    public void updataConn() {
           try {
                    Class.forName(DRIVER);
           } catch (ClassNotFoundException e) {
                    e.printStackTrace();
           }
           try {
                    connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
           } catch (SQLException e) {
                    e.printStackTrace();
           }
    }
      
    // 关闭数据库连接
     public void closeAll(Connection conn, PreparedStatement prsts, ResultSet rs) {
            if (rs != null) {
                try {
                         rs.close();
                } catch (SQLException e) {
                         e.printStackTrace();
                }
            }
            if (prsts != null) {
                try {
                         prsts.close();
                } catch (SQLException e) {
                         e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                         conn.close();
                } catch (SQLException e) {
                         e.printStackTrace();
                }
            }
         }
 
    public void executeSQL(String sql){
      String sqlCommands = sql.trim();
      String[] commands = sqlCommands.replace('\n', ' ').split(";");

      for (String aCommand: commands) {
        if (aCommand.trim().toUpperCase().startsWith("SELECT")) {
          processSQLSelect(aCommand);
        }
        else {
          processSQLNonSelect(aCommand);
        }
      }
   }
       
     public boolean processSQLSelect(String sqlCommand) {
      sqlResult = "";
      try {
        statement = connection.createStatement();

        // Execute a SELECT SQL command
        ResultSet resultSet = statement.executeQuery(sqlCommand);

        // Find the number of columns in the result set
        int columnCount = resultSet.getMetaData().getColumnCount();
        String row = "";
        // Display column names
        for (int i = 1; i <= columnCount; i++) {
          row += resultSet.getMetaData().getColumnName(i) + "\t";
        }

        //显示属性名
        sqlResult = sqlResult + row + '\n';

        while (resultSet.next()) {
          row = "";

          for (int i = 1; i <= columnCount; i++) {
            // A non-String column is converted to a string
            row += resultSet.getString(i) + "\t";
          }

          //显示查询结果
          sqlResult = sqlResult + row + '\n';
      }
    }
    catch (SQLException ex) {
       sqlResult = ex.toString();
       return false;
    }
     return true;
  }
       
   public boolean processSQLNonSelect(String sqlCommand) {
    try {
      // Get a new statement for the current connection
      statement = connection.createStatement();

      // Execute a non-SELECT SQL command
      statement.executeUpdate(sqlCommand);

    }
    catch (SQLException ex) {
      sqlResult = ex.toString();
      return false;
    }
    return true;
  }
}
