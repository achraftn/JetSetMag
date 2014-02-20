/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JetSetMag.DAO ; 


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import jetsetmag.Connect.MyConnection;
import jetsetmag.entites.Admin;

/**
 *
 * @author Karray
 */
public class AdminDAO {

    public void InsertAdmin(Admin a) {

        String requete = "INSERT INTO admin (login,password) VALUES (?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, a.getLogin());
            ps.setString(2, a.getPassword());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion " + ex.getMessage());
        }
    }

    public void updateAdmin(Admin a) {
        String requete = "update admin set  password=? where login=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
              ps.setString(1, a.getPassword());
               ps.setString(2, a.getLogin());
          
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }

    public void deleteAdmin(int id) {
        String requete = "delete from admin where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Admin supprimée");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression " + ex.getMessage());
        }
    }

    public Admin findAdminById(int id) {
        Admin a = new Admin();
        String requete = "select * from admin where id =?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next()) {
                a.setId(resultat.getInt(1));
                a.setLogin(resultat.getString(2));
                a.setPassword(resultat.getString(3));
            }
            return a ;

        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot " + ex.getMessage());
            return null;
        }
    }

    public List<Admin> DisplayAllAdmin() {


        List<Admin> listeadmin = new ArrayList<Admin>();

        String requete = "select * from admin";
        try {
            Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while (resultat.next()) {
                Admin a = new Admin();
                a.setId(resultat.getInt(1));
                a.setLogin(resultat.getString(2));
                a.setPassword(resultat.getString(3));

                listeadmin.add(a);
            }
            return listeadmin;
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des depots " + ex.getMessage());
            return null;
        }
    }
}
