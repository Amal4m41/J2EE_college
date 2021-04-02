/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.sql.*;

/**
 *
 * @author Amal Sunil
 */
public class AddUser extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn=null;
        Statement stmt=null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
            String DB_URL = "jdbc:mysql://localhost/userlogin"; 
            String USER="root";
            String PASSWORD="";
            conn=DriverManager.getConnection(DB_URL,USER,PASSWORD);
            stmt=conn.createStatement();
            String sql="insert into user values (?,?,?)";
            PreparedStatement s=conn.prepareStatement(sql);
            
            
            s.setString(1,request.getParameter("username"));
            s.setString(2,request.getParameter("firstname"));
            s.setString(3,request.getParameter("lastname"));
            
            int r=s.executeUpdate();
            if(r>=0){
                out.print("<font size=10 color='green'><b>User added successfuly<b></font>");
            }
            
            
        }
        catch(SQLException ee){
            out.print(ee.getMessage());
        }
        catch(ClassNotFoundException e2){
            out.print(e2.getMessage());
        }
    }
}
