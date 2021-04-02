/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Amal Sunil
 */
public class Userlogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Userlogin</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Userlogin at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
            String un=request.getParameter("username");
            String pwd=request.getParameter("password");
            if(un.equals("Amal") && pwd.equals("password")){
                out.println("<h1 style='color:green'>Welcome "+un+"</h1>");
            }
            else if(un.equals("Amal")){
                out.println("<h1 style='color:red'>Wrong password please try again</h1>");
                RequestDispatcher r=request.getRequestDispatcher("index.html");
                r.include(request, response);
            }
            else if(pwd.equals("password")){
                out.println("<h1 style='color:red'>Wrong username please try again</h1>");
                RequestDispatcher r=request.getRequestDispatcher("index.html");
                r.include(request, response);
            }
            else{
                out.println("<h1 style='color:red'>Wrong username and password please try again</h1>");
                RequestDispatcher r=request.getRequestDispatcher("index.html");
                r.include(request, response);                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
