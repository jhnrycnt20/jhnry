
package config;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbConnector {
    
    private Connection connect;
    
    public dbConnector(){
    
        try{
        
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tables", "root", "");
        
        }catch(SQLException e){
            System.out.println("Can't connect to Database: "+e.getMessage());
        
        }
    
    }
    
    public ResultSet getData(String sql) throws SQLException {
        
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    
    }
}
