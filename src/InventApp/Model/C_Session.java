/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventApp.Model;

import InventApp.DB_INFO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sergiohernandez
 */
public class C_Session {    
    private Integer id_session;
    private C_User user;
    private Timestamp login_date;
    private Timestamp logout_date;
    
   public C_Session(){}

    public C_Session(C_User user) {
        this.user = user;
        this.login_date = Timestamp.from(Instant.now());
    }
    
    public boolean logout(){
        this.logout_date = Timestamp.from(Instant.now());
        boolean update_successful = C_Session.updateSession(this);
        return update_successful;
    }

    public Integer getId_session() {
        return id_session;
    }

    public C_User getUser() {
        return user;
    }

    public Timestamp getLogin_date() {
        return login_date;
    }

    public Timestamp getLogout_date() {
        return logout_date;
    }
    
    // insert a new user
     public static boolean insertSession(C_Session session)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("INSERT INTO `session`(`id_user`, `login_date`) VALUES (?,?)");

            ps.setInt(1, session.getUser().getId());
            ps.setTimestamp(2, session.getLogin_date());

            if(ps.executeUpdate() != 0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
     // update user
    public static boolean updateSession(C_Session session)
    {
        Connection con = DB_INFO.getConnection();
        PreparedStatement ps;
        
        try {
            ps = con.prepareStatement("UPDATE `session` SET `logout_date` = ? WHERE `id_user` = ?");
            ps.setTimestamp(1, session.getLogout_date());
            ps.setInt(2, session.getUser().getId());

            if(ps.executeUpdate() != 0){
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(C_User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
