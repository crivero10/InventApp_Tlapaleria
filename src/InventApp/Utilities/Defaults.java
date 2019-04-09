/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventApp.Utilities;

import InventApp.Utilities.Ctrl_Webcam.PictureType;

/**
 *
 * @author sergiohernandez
 */
public class Defaults {
    private static final String PHOTO_LOGIN_LOCATION = System.getProperty("user.dir") + "/img/login_photo";
    private static final String PHOTO_DEFAULT_LOCATION = System.getProperty("user.dir") + "/img/photo";

    
    public static class PictureLocation {
        public static String from(PictureType type){
            switch(type){
                case LOGIN:
                    String env_location = System.getenv("PHOTO_LOGIN_LOCATION");
                    if(env_location == null || env_location.isEmpty())
                        return PHOTO_LOGIN_LOCATION;
                    return env_location;
                default:
                    env_location = System.getenv("PHOTO_DEFAULT_LOCATION");
                    if(env_location == null || env_location.isEmpty())
                        return PHOTO_DEFAULT_LOCATION;
                    
                    return env_location;
            }
        }
    }
}
