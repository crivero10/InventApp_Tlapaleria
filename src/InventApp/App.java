/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventApp;

import InventApp.Model.C_Session;
import InventApp.Model.C_User;

/**
 *
 * @author sergiohernandez
 */
public class App {
    private static C_User current_user;
    private static C_Session current_session;

    public static C_User getCurrent_user() {
        return current_user;
    }

    public static void setCurrent_user(C_User current_user) {
        App.current_user = current_user;
    }

    public static C_Session getCurrent_session() {
        return current_session;
    }

    public static void setCurrent_session(C_Session current_session) {
        App.current_session = current_session;
    }
    
    
}
