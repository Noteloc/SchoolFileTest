/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import dbconn.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
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

@WebServlet(name = "Admin", urlPatterns = {"/Admin"})
public class Admin extends HttpServlet {

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
        
        //Get any/all user accounts to be locked
        String[] locked=request.getParameterValues("locked");
        //Get new welcome message (if any)
        String welcome=request.getParameter("welcome");

        //Update welcome message
        if (welcome!=null && !welcome.equals(""))
        {
            //Update welcome message
            Connection conn = DBConn.getConnection();
            String sql="update welcome set welcome='" + welcome + "';";
            Statement st = conn.createStatement();
            st.execute(sql);            
            st.close();
            conn.close();
        }
        else if (welcome!=null && welcome.equals(""))
        {
            response.sendRedirect("admin.jsp?message=No updated welcome message was provided");
        }
        else if (locked==null)
        {
            //Unlock all accounts
            Connection conn = DBConn.getConnection();
            String sql="update accountholders set locked=0;";
            Statement st = conn.createStatement();
            st.execute(sql);      
            st.close();
            conn.close();
        }
        else if (locked!=null)
        {
            //Unlock all accounts to begin with
            Connection conn = DBConn.getConnection();
            String sql="update accountholders set locked=0;";
            Statement st = conn.createStatement();
            st.execute(sql);
        
            for (String username: locked)
            {
                sql="update accountholders set locked=1 where username='" + username + "';";
                st.execute(sql);
            }

            st.close();
            conn.close();
        }
        
        response.sendRedirect("admin.jsp");
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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
