/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.dao;

import com.todolist.model.Todo;
import com.todolist.utils.JdbcUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class TodoDao
{
    public String insert_sql = "insert into todo"+"(title,description,isdone,targetdate)" +"values(?,?,?,?) ";
    public String select_all ="select * from todo";
    public String select_by_id = "select id,title,description,targetdate,isdone from todo where id=?";
    public String update_todo ="update todo set title=?, description=? ,targetdate=?, isdone=?  where id=?";
    public String delete_sql_by_id = "delete from todo where id =?";
    public void insert(Todo todo)
    {
        try//try will auto-close connection .
        {
            Connection con =JdbcUtils.getConnection();
            PreparedStatement st = con.prepareStatement(insert_sql);
         
            st.setString(1, todo.getTitle());
           
            st.setString(2,todo.getDescription());
            st.setBoolean(3, todo.getStatus());
            st.setDate(4,JdbcUtils.getSQLDate(todo.getDate()));
            
            st.executeUpdate();
                    
        }
        catch(Exception e){System.out.println(e);}
    }
    
    public List <Todo> selectAllTodo()
    {
        List <Todo> todos = new ArrayList();
        try
        {
            Connection con = JdbcUtils.getConnection();
            PreparedStatement st = con.prepareStatement(select_all);
            ResultSet rs =st.executeQuery();
            
            while(rs.next())
            {
                Long id = rs.getLong("id");
                String title = rs.getString("title");
                String desc = rs.getString("description");
                LocalDate date = rs.getDate("targetdate").toLocalDate();
                Boolean status = rs.getBoolean("isdone");
                todos.add(new Todo(id,title,desc,date,status));
            }
        }catch(Exception e){System.out.println(e);}
        
        
        return todos;
        
    }
    
    public boolean update( Todo todo)
    {
        boolean updated = false;
        try
        {
            Connection con = JdbcUtils.getConnection();
            PreparedStatement st = con.prepareStatement(update_todo);
            st.setString(1, todo.getTitle());
            st.setString(2, todo.getDescription());
            st.setDate(3, JdbcUtils.getSQLDate(todo.getDate()));
            st.setBoolean(4,todo.getStatus());
            st.setLong(5, todo.getId());
            
            updated = st.executeUpdate()>0;
        }catch(Exception e){System.out.println(e);}
        return updated   ;
    }

    public Todo selectTodo(long id) {
        Todo todo = null;
        
        try
        {
            Connection con = JdbcUtils.getConnection();
            PreparedStatement st = con.prepareStatement(select_by_id);
            st.setLong(1,id );
            ResultSet rs = st.executeQuery();
           
            while (rs.next())
            {
                long Lid = rs.getLong("id");
               String title = rs.getString("title");
               String desc = rs.getString("description");
               LocalDate date = rs.getDate("targetdate").toLocalDate();
               Boolean isDone = rs.getBoolean("isdone");
               
               todo = new Todo(Lid,title,desc,date,isDone);
            }
            
            
            
        }catch(Exception e){System.out.println(e);}
        return todo;
    }
    
    public boolean deleteTodo( long id)
    {
        boolean rowDeleted = false;
        try
        {
            Connection con = JdbcUtils.getConnection();
            PreparedStatement st = con.prepareStatement(delete_sql_by_id);
            st.setLong(1, id );
            rowDeleted =st.executeUpdate()>0;
        }catch(Exception e){System.out.println(e);}
        return rowDeleted;
    }
    
  
    
    
}
