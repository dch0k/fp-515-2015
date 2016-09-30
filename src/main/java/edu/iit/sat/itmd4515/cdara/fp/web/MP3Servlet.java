/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.cdara.fp.web;

import edu.iit.sat.itmd4515.cdara.fp.domain.Admin;
import edu.iit.sat.itmd4515.cdara.fp.domain.Assistant;
import edu.iit.sat.itmd4515.cdara.fp.domain.Panel;
import edu.iit.sat.itmd4515.cdara.fp.domain.PanelLogin;
import edu.iit.sat.itmd4515.cdara.fp.domain.Paneldetails;
import edu.iit.sat.itmd4515.cdara.fp.service.AdminService;
import edu.iit.sat.itmd4515.cdara.fp.service.AssistantService;
import edu.iit.sat.itmd4515.cdara.fp.service.AccountService;
import edu.iit.sat.itmd4515.cdara.fp.service.PanelService;
import edu.iit.sat.itmd4515.cdara.fp.service.PanelLoginService;
import edu.iit.sat.itmd4515.cdara.fp.service.BankService;
import edu.iit.sat.itmd4515.cdara.fp.service.CardService;
import edu.iit.sat.itmd4515.cdara.fp.service.PaneldetailsService;
import edu.iit.sat.itmd4515.cdara.fp.service.RewardsService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author darac
 */
@WebServlet(name = "MP3Servlet", urlPatterns = {"/MP3Servlet"})
public class MP3Servlet extends HttpServlet {

    @EJB
    AccountService accountService;

    @EJB
    AdminService adminService;

    @EJB
    AssistantService assistantService;

    @EJB
    BankService bankService;

    @EJB
    CardService cardService;

    @EJB
    PanelService panelService;

    @EJB
    PanelLoginService panelloginService;

    @EJB
    PaneldetailsService paneldetailsService;

    @EJB
    RewardsService rewardsService;

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MP3Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet MP3Servlet at " + request.getContextPath() + "</h1>");
            System.out.println("Remote User " + request.getRemoteUser());
            if (request.isUserInRole("ASSISTANT")) {
                Assistant a = assistantService.findByUsername(request.getRemoteUser());
                out.println("<h1>Welcome  " + a.getUser().getUserName() + "</h1>");

                out.println("<h2><b>Panel Details</b></h2>");
                for (Paneldetails pd : paneldetailsService.findAll()) {
                    out.println("<br>___________________________________");

                    out.println("<br>___________Panel ID:" + pd.getId() + "___________");
                    out.println("<br>First Name: " + pd.getFirstName());
                    out.println("<br>Last Name: " + pd.getLastName());
                    out.println("<br>Gender: " + pd.getGender());
                    out.println("<br>Date of Birth: " + pd.getDateOfBirth());
                    out.println("<br>Phone: " + pd.getPhone());
                    out.println("<br>Email: " + pd.getEmail());
                    out.println("<br>Address: " + pd.getAddress());
                    out.println("<br>State: " + pd.getState());
                    out.println("<br>ZIP: " + pd.getZip());
                }

            } else if (request.isUserInRole("ADMIN")) {
                Admin a = adminService.findByUsername(request.getRemoteUser());
                out.println("<h1>Welcome  " + a.getUser().getUserName() + "</h1>");

                out.println("<h2><b>Assistant Details</b></h2>");
                for (Assistant at : assistantService.findAll()) {
                    out.println("<br>___________________________________");

                    out.println("<br>___________Assistant ID: " + at.getId() + "___________");
                    out.println("<br>Assistant Username: " + at.getUser().getUserName());
                }
            } else if (request.isUserInRole("PANEL")) {
                PanelLogin pl = panelloginService.findByUsername(request.getRemoteUser());
                out.println("<h1>Welcome  " + pl.getUser().getUserName() + "</h1>");

                out.println("<h2><b>Hello!<br>For details contact your survey Assistant</b></h2>");
            } else {
                out.println("<h1>You are not in any roles.</h1>");
            }

            out.println("<br><b><a href=\"" + request.getContextPath() + "/LogoutServlet\">LOGOUT</a></b>");

            out.println("</body>");
            out.println("</html>");

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
