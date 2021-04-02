/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trial_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amal Sunil
 */
public class Trial_JDBC {

    /**
     * @param args the command line arguments
     */
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";   //specifying the driver name
    static final String DB_URL = "jdbc:mysql://localhost/student";  //specifying database url
    
    //Database credentials
    static final String USER = "root";
    static final String PASSWORD = "";
    public static void main(String[] args) 
    {
        // TODO code application logic here
        //establishing a connection
        Connection conn=null;
        Statement st=null;
        try
        {
            //Registering the driver(translator)
            Class.forName(JDBC_DRIVER);
            
            //Open a connection(like a road)
            System.out.println("Connecting to database");
            conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
            
            //Execute a query(statement object carries the sql query and the database engine queries/processes it and sends the response as a resultset object)
            System.out.println("Creating statement");
            st=conn.createStatement();
            String sql;
            
//            st.executeUpdate("insert into employee values (4,'Mbappe',22,'Paris'),(6,'Di Maria',29,'Paris')");
            sql="Select * from stud";
            ResultSet rs=st.executeQuery(sql);
            
            //Extract data from the result set
            while(rs.next())
            {
                //Retrieving by column name 
//                int id=rs.getInt("id");
//                String name=rs.getString("name");
//                String loc=rs.getString("location");
                int id=rs.getInt(1);
                String name=rs.getString(2);
                String loc=rs.getString(3);
                
                //Display the extracted data
                System.out.print("ID: "+id+"    Name :"+name+"   Location: "+loc+"\n");
            }
            rs.close();
            conn.close();
            st.close();
        }
        catch(SQLException se)
        {
            //Handle error for jdbc
            se.printStackTrace();
        }
        catch(Exception e)
        {
            //Handle error for Class.forName
            e.printStackTrace();
        }

        
    }
    
}
