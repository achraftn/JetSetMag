/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jetsetmag.entites;

/**
 *
 * @author Mehdi
 */
public class Admin {
    
    private int id ; 
    private String login ;
    private String password;

    public Admin() {
    }

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" + "login=" + login + ", password=" + password + '}';
    }
    
    
    
    
}
