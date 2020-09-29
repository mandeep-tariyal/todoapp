/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.web;

import com.todolist.model.user;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        HttpSession sess = req.getSession();
        sess.removeAttribute("user");
        sess.invalidate();;
        res.sendRedirect("login.jsp");
    }
    
}
