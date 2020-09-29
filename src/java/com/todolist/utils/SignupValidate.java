/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.utils;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/registerValidate")
public class SignupValidate extends HttpServlet{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
         String firstName = req.getParameter("fname");
    String lastName = req.getParameter("lname");
    String userName = req.getParameter("username");
    String password = req.getParameter("pass");
        
             HttpSession session = req.getSession();
             session.setAttribute("fname",firstName);
             session.setAttribute("lname",lastName);
         session.setAttribute("username", userName);
         session.setAttribute("pass", password);
        
        
             
        if(userName =="" || password =="")
        {
            res.sendRedirect("register.jsp");
        }else{
            res.sendRedirect("register");
    }
    }
}
