/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.todolist.model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Mandeep
 */
public class login implements Serializable {
    
   private static final long serialVersionUID =1L; 
   private  String username;
   private  String password;
   
   public String getUserName()
   {
       return username;
   }
   public void setUserName( String username)
   {
       this.username= username;
   }
   
   public String getPassword()
   {
       return password;
   }
   public void setPassword(String password)
   {
       this.password = password;
   }
   
}
