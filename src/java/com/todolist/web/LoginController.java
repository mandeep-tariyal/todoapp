/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.web;

import com.todolist.dao.loginDAO;
import com.todolist.model.login;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/login")
public class LoginController extends HttpServlet
{
    private static final long serialVersionUID= 1L;
    private loginDAO logindao;
   public void init()
   {
       logindao = new loginDAO();
   }
   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
   {
       authenticate(req,res);
   }
   public void authenticate( HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
   {
       String uname = req.getParameter("username");
       String pass= req.getParameter("password");
       
       login user =new login();
       user.setUserName(uname);
       user.setPassword(pass);
       try{
       if(logindao.validate(user))
       {
           HttpSession sessionn = req.getSession();
             sessionn.setAttribute("user", user);
           RequestDispatcher ds= req.getRequestDispatcher("/todo-list.jsp");
           ds.forward(req, res);
       }else
       {
                            res.sendRedirect("register.jsp");
       }
       
       }catch(Exception e)
       {
           System.out.println(e);
       }
   }        
}
