/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CakeDAO;
import dao.ShareDAO;
import entity.Cake;
import entity.Share;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * ListCakeController class<br>
 *
 * <pre>
 * This class is a servlet that takes action to receive requests and send responses to ListCake.jsp
 * In this class, the following processing will be done:
 *  - processRequest (): handles requests from the side and sends responses
 * </pre>
 *
 * @author nghialdnse05508
 * @version 1.0
 */
public class ListCakeController extends HttpServlet {
    
    /**
     * List Cake<br>
     *
     * <pre>
     * 
     *  - get page 
     *  - get data from database
     *  - get total number pages
     *  - get cakes by pages
     *  - get information of share
     *  - check sPage for null and match regex
     *  - check page is larger than pages or equal to 0
     *  - Forward user to ListCake.jsp
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
            CakeDAO cakeDAO = new CakeDAO();
            int pages = cakeDAO.getTotalPages();
            int page;
            String sPage = request.getParameter("page");
            String regex = "\\d{1,}";
            if(sPage==null){
                page=1;
            }else{
                if(!sPage.matches(regex)){
                    page=1;
                }else{
                    page=Integer.parseInt(sPage);
                    if(page>pages){
                        page=1;
                    }
                }
            }
            List<Cake> cakes=cakeDAO.selectCakeByPage(page);
            List<Share> shares=new ShareDAO().selectShare();
            request.setAttribute("pages", pages);
            request.setAttribute("page", page);
            request.setAttribute("cakes",cakes);
            request.setAttribute("share",shares);
            request.setAttribute("currentPage",1);
            request.getRequestDispatcher("/ListCake.jsp").forward(request, response);
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
