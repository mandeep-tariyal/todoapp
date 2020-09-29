/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.web;

import com.todolist.dao.UserDAO;
import com.todolist.model.user;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class UserController extends HttpServlet{
private static final long serialVersionUID =1;
private UserDAO userDao;
public void init()
{
    userDao = new UserDAO();
}
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
{
    register(req,res);
}

private void register(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
{
    HttpSession sess = req.getSession();
    String firstName = sess.getAttribute("fname").toString();
    String lastName = sess.getAttribute("lname").toString();
    String userName = sess.getAttribute("username").toString();
    String password = sess.getAttribute("pass").toString();
   
    
   
    
     
     
    user employee = new user();
    employee.setFirstName(firstName);
    employee.setLastName(lastName);
    employee.setPassword(password);
    employee.setUsername(userName);
    
    
   
    
    try{
        int result =userDao.registerEmployee(employee);
        if(result ==1)
        {
            req.setAttribute("NOTIFICATION", "User Registered Succesfully");
        }
    }catch(Exception e)
    {System.out.println(e);}
RequestDispatcher ds= req.getRequestDispatcher("/login.jsp");
ds.forward(req,res);
}

}
