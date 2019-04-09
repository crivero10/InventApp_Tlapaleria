/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InventApp.Utilities;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import com.github.sarxos.webcam.Webcam;
import java.awt.Dimension;
/**
 *
 * @author sergiohernandez
 */
public class Ctrl_Webcam {
    private static Webcam cam;
    
    public static enum PictureType{
        LOGIN,
        SELL,
        LOGOUT,
        CHECKOUT
    }
    
    public static void takePicture(PictureType type){
        String photo_location = Defaults.PictureLocation.from(type);
        takePicture(photo_location);
    }
    
    private static void takePicture(String photo_location){        
        if(cam == null || !cam.isOpen()){
            startWebcam();
        }
        
        System.out.println(photo_location);
        try{
            ImageIO.write(cam.getDevice().getImage(), "PNG", new File(photo_location + ".png"));
        }catch(IOException e){
            System.err.println(e.toString());
        }finally{
            cam.close();
        }
    }
    
    private static void startWebcam(){
        cam = Webcam.getDefault();
        Dimension[] view_sizes = getViewSizes();
        for (int i = 0; i < view_sizes.length; i++) {
            Dimension d = view_sizes[i];
            System.out.println(d.toString());
            
        }
        setViewSize(view_sizes.length-1);
        
        cam.open();
    }
    
    private static Dimension[] getViewSizes(){
        return cam.getViewSizes();
    }
    
    private static boolean setViewSize(int index){
        Dimension[] view_sizes = getViewSizes();
        if(view_sizes.length > index){
            cam.setViewSize(view_sizes[index]);
            return true;
        }
        
        return false;
    }
}
