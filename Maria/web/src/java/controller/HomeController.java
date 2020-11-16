/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CakeDAO;
import dao.InformationDAO;
import dao.IntroductionDAO;
import dao.ShareDAO;
import entity.Cake;
import entity.Information;
import entity.Introduction;
import entity.Share;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * HomeController class<br>
 *
 * <pre>
 * This class is a servlet that takes requests and responds to Home.jsp
 * Process:
 *  - processRequest (): handles requests from the side and sends responses
 * </pre>
 *
 * @author Tiennphe130789
 * @version 1.0
 */
public class HomeController extends HttpServlet {

    /**
     * process Home<br>
     *
     * <pre>
     * 
     *  - get data from MariaCafeDB
     *  - get the 2 lastest recent cakes
     *  - get information of share
     *  - get information of information
     *  - get information of introduction
     *  - Forward user to Home.jsp
     *
     * ◆ exception:
     *  if id doesn't exist then forward to ErrorPage.jsp
     * 
     * </pre>
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            Introduction introduction = new IntroductionDAO().selectIntroDuction();
            Information information = new InformationDAO().selectInformation();
            List<Cake> cakes = new CakeDAO().selectTop2Cake();
            List<Share> shares = new ShareDAO().selectShare();
            request.setAttribute("introduction", introduction);
            request.setAttribute("information", information);
            request.setAttribute("cakes", cakes);
            request.setAttribute("share", shares);
            request.setAttribute("currentPage",0);
            RequestDispatcher rd =request.getRequestDispatcher("/Home.jsp");
            rd.forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error","Error page!");
            RequestDispatcher rd=request.getRequestDispatcher("/ErrorPage.jsp");
            rd.forward(request, response);
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
