/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.*;

/**
 *
 * @author Amal Sunil
 */
public class EMI extends HttpServlet {

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
            
//fetching the data from the request object by specifying the name.
            int p_val=Integer.valueOf(request.getParameter("pa"));     
            int n=Integer.valueOf(request.getParameter("tenure"));
            String d=request.getParameter("bank");
            
//extracting the value for the parameters specified in the web.xml(giving global access to these values from all servlets with in the application)
            ServletConfig config=getServletConfig();
            String hdfc=config.getInitParameter("hdfc");   
            String axis=config.getInitParameter("axis");
            String sbi=config.getInitParameter("sbi");
            
//            out.println("<h1 style='color:red'>Rate of Interest by HDFC "+hdfc+"</h1>");
//            out.println("<h1 style='color:green'>Rate of Interest by AXIS "+axis+"</h1>");
//            out.println("<h1 style='color:blue'>Rate of Interest by SBI "+sbi+"</h1>");
            
            double r=0.0;
            System.out.println(d);
            if(d.equals("hdfc")){
                r=Double.valueOf(hdfc)/(12*100);
            }
            else if(d.equals("axis")){
                r=Double.valueOf(axis)/(12*100);
            }
            else{
                r=Double.valueOf(sbi)/(12*100);
            }
            DecimalFormat numberFormat = new DecimalFormat("#.00");
//            System.out.println(numberFormat.format(number));
            double EMI=(p_val*r*Math.pow((1+r),n))/(Math.pow((1+r),n)-1);
            out.println("<h2 style='color:red'> EMI : "+numberFormat.format(EMI)+"</h2>");
            out.println("<h2 style='color:green'> Bank : "+d+"</h2>");
            out.println("<h2 style='color:orange'> Tenure in months : "+n+"</h2>");
            out.println("<h2 style='color:orange'> Principal amount : "+p_val+"</h2>");
            out.println("<h2 style='color:orange'> Rate of Interest : "+String.valueOf(numberFormat.format(r*100*12))+"% </h2>");
            
        }
        catch(Exception e){
            System.out.println(e);
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
