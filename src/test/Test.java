/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import JetSetMag.DAO.AdminDAO;
import jetsetmag.entites.Admin;

/**
 *
 * @author Mehdi
 */
public class Test {
    
    
    
    public static void main(String[] args) {
         Admin a = new Admin();
        AdminDAO admin = new AdminDAO();
       
     a.setLogin("tahiya");   
     a.setPassword("tahiya");
     admin.InsertAdmin(a);
        
            
    }
}
