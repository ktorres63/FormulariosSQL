/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formsjava_mysql;

/**
 *
 * @author karlo
 */
public class Conexion_MYSQL {

   static String dbName = "cop_Ahor2";
   static String userName = "karlo";
   static String password = "qwerty123";
   static String url = "jdbc:mysql://localhost:3306/";
   static String driver = "com.mysql.cj.jdbc.Driver";

    public static String getDbName() {
        return dbName;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getPassword() {
        return password;
    }

    public static String getUrl() {
        return url;
    }

    public static String getDriver() {
        return driver;
    }
    
}
