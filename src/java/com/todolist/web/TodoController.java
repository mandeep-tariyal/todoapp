/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.web;

import com.todolist.dao.TodoDao;
import com.todolist.model.Todo;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/")
public class TodoController extends HttpServlet {
     private static final long serialVersionUID = 1L;
    TodoDao tododao;
    public void init()
    {
        tododao = new TodoDao();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {doGet(req,res);}
    
    protected void service(HttpServletRequest req,HttpServletResponse res)
    {
        String action = req.getServletPath();
        try
        {
            switch (action)
            {
                case "/new":
                    showNewForm(req,res);
                break;
                
                case"/insert":
                    insertToDo(req,res);
                    break;
                    case"/delete":
                        deleteTodo(req,res);
                
                case"/edit":
                    showEditForm(req,res);
                    break;
                 
                case"/update":
                    updateTodo(req,res);
                    break;
                    
                 case"/list":
                     showList(req,res);
                     break;
                     
                     
                 default:
                     RequestDispatcher ds = req.getRequestDispatcher("login.jsp");
                     ds.forward(req, res);
                     break;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
       
    
    public void insertToDo(HttpServletRequest req, HttpServletResponse res ) throws IOException, ServletException
    {
        
        
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        
        LocalDate date = LocalDate.parse(req.getParameter("targetDate"));
        boolean isDone = Boolean.valueOf(req.getParameter("isDone"));
        Todo updateTodo = new Todo(title,description,date,isDone);
        tododao.insert(updateTodo);
        
        res.sendRedirect("list");
    }

    private void showList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List <Todo> listTodo = tododao.selectAllTodo();
        req.setAttribute("listTodo",listTodo);
        RequestDispatcher ds = req.getRequestDispatcher("/todo-list.jsp");
        ds.forward(req, res);
    }

    private void updateTodo(HttpServletRequest req, HttpServletResponse res) throws IOException {
        long id =Long.parseLong(req.getParameter("id"));
        String title = req.getParameter("title");
        String desc = req.getParameter("description");
        LocalDate date = LocalDate.parse(req.getParameter("targetDate"));
        Boolean isDone= Boolean.valueOf(req.getParameter("isDone"));
        
        Todo updateTodo = new Todo(id,title,desc,date,isDone);
        tododao.update(updateTodo);
        
        res.sendRedirect("list");
    }
    
    private void deleteTodo( HttpServletRequest req, HttpServletResponse res) throws IOException
    {
        long id = Long.parseLong(req.getParameter("id"));
        tododao.deleteTodo(id);
        res.sendRedirect("list");
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       long id = Long.parseLong(req.getParameter("id"));
       Todo existingTodo = tododao.selectTodo(id);
       RequestDispatcher ds = req.getRequestDispatcher("/todo-form.jsp");
       req.setAttribute("todo",existingTodo);
       ds.forward(req, res);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       RequestDispatcher ds = req.getRequestDispatcher("/todo-form.jsp");
       ds.forward(req, res);
    }

   
    
}
