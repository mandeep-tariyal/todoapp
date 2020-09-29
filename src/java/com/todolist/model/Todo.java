/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.model;

import java.time.LocalDate;


public class Todo {

    private long id;
    private String title;
    private String description;
    private boolean status;
    private LocalDate date;
   
  

    protected Todo(){}
    public Todo(long id, String title, String description, LocalDate date, boolean done) {
        super();
        this.id = id;
        this.title=title;
      
        this.description= description;
        this.date= date;
        this.status = done;
    }
    
    
    public Todo(String title, String description, LocalDate date, boolean done) {
        super();
        this.title = title;
      
        this.description = description;
        this.date = date;
        this.status = done;
    }
    
  
    public void setId(int id)
    {
        this.id = id;
    }
    public long getId()
    {return id ;}
    
    public void setTitle(String title)
    {this.title=title;}
    public String getTitle()
    {return title;}
    
    public void setDescription(String description)
    {this.description=description;}
    public String getDescription()
    {return description;}
    
    public void setStatus(boolean status)
    {this.status = status;}
    public boolean getStatus()
    {return status;}
    
    public void setDate(LocalDate date)
    {this.date=date;}
    public LocalDate getDate()
    {return date;}
    
     public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
