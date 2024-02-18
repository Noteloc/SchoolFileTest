/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validate;

import dbconn.DBConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Validate", urlPatterns = {"/Validate"})
public class Validate extends HttpServlet {

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
        
        String username=request.getParameter("username");
        String adminUsername = request.getParameter("adminUsername");
        String password=request.getParameter("password");
        String logout=request.getParameter("logout");
        HttpSession session=request.getSession();
        
        //User logging out
        if (logout!=null)
        {
            session.invalidate();
            response.sendRedirect("index.jsp?message=Logged out");
        }
        //Admin logging in
        else if (adminUsername!=null && password!=null && !adminUsername.equals("") && !password.equals(""))
        {
            //Validate admin from db
            Connection conn = DBConn.getConnection();
            String sql="select count(*) from adminusers where username='" + adminUsername + "' and password='" + password + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int found=rs.getInt(1);
            rs.close();
            st.close();
            conn.close();
            
            if (found>0)
            {
                //Get standard welcome message from database to store as session attribute
                conn = DBConn.getConnection();
                sql="select * from welcome;";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                rs.next();
                String welcome = rs.getString(1);
                rs.close();
                st.close();
                conn.close();
                
                session.setAttribute("adminUsername", adminUsername);
                session.setAttribute("welcome", welcome);
                
                response.sendRedirect("admin.jsp");
            }
            else
            {
                session.invalidate();
                response.sendRedirect("adminLogin.jsp?message=Invalid username or password");
            }
        }
        //Normal user logging in
        else if (username!=null && password!=null && !username.equals("") && !password.equals(""))
        {
            //Validate user from db
            Connection conn = DBConn.getConnection();
            String sql="select * from accountholders where username='" + username + "' and password='" + password + "';";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            int found=0;
            boolean locked=false;
            
            while (rs.next()) //At most only one record will be returned
            {
                found++;
                locked=rs.getBoolean(4);
            }

            rs.close();
            st.close();
            conn.close();
            
            if (found>0 && !locked) //Valid user
            {
                //Get standard welcome message from database to store as session attribute
                conn = DBConn.getConnection();
                sql="select * from welcome;";
                st = conn.createStatement();
                rs = st.executeQuery(sql);
                rs.next();
                String welcome = rs.getString(1);
                rs.close();
                st.close();
                conn.close();
                
                //Session attributes for validated users
                session.setAttribute("username", username);
                session.setAttribute("welcome", welcome);
                
                //Set cookie with useful session-related data (username, date/time logged in, session ID(?)
                Cookie sessionDataCookie=new Cookie("sessionData", username + "," + (new Date()) + "," + session.getId());

                response.addCookie(sessionDataCookie);
                
                response.sendRedirect("transfer.jsp");
            }
            else if (found>0 && locked) //Locked-out user
            {
                session.invalidate();
                response.sendRedirect("index.jsp?message=Account locked");
            }
            else //Invalid user
            {
                session.invalidate();
                response.sendRedirect("index.jsp?message=Invalid username or password");
            }
        }
        else //Missing user details
            response.sendRedirect("index.jsp?message=Both username and password are required");
        
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
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Validate.class.getName()).log(Level.SEVERE, null, ex);
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
