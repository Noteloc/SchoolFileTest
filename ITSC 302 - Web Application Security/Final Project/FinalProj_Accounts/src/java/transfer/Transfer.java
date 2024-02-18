/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import dbconn.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Transfer", urlPatterns = {"/Transfer"})
public class Transfer extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String amount = request.getParameter("amount");
        
        //Don't allow money transfer in the same account (from==to) - causes calculation problems
        if (from!=null && to!=null && from.equals(to))
        {
            response.sendRedirect("transfer.jsp?message=\"From\" account cannot be the same as \"to\" account");
        }
        else if (from!=null && to!=null && amount!=null && !amount.equals(""))
        {
            float fAmount = Float.parseFloat(amount);
            
            Connection conn = DBConn.getConnection();
            
            //Get "from" balance
            String sql="select accountBalance from accounts where accountID=" + from + ";";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            float fromBalance = rs.getFloat(1);
            rs.close();
            
            //Get "to" balance
            sql="select accountBalance from accounts where accountID=" + to + ";";
            //Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            float toBalance = rs.getFloat(1);
            rs.close();

            //Subtract amount from "from" account
            sql="update accounts set accountBalance=" + (fromBalance-fAmount) + " where accountID = '" + from + "';";
            System.out.println("DEBUG1: " + sql);
            st.executeUpdate(sql);
            
            //Add amount to "to" account
            sql="update accounts set accountBalance=" + (toBalance+fAmount) + " where accountID = '" + to + "';";
            System.out.println("DEBUG2: " + sql);
            st.executeUpdate(sql);  
            
            st.close();
            conn.close();
            
            response.sendRedirect("transfer.jsp?message=Transfer succeeded");
            
        }
        else
            response.sendRedirect("transfer.jsp?message=Amount is required for transfer");
        
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Transfer.class.getName()).log(Level.SEVERE, null, ex);
        }
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
