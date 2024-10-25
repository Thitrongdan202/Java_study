/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demo251024;

import java.awt.event.WindowListener;

/**
 *
 * @author hasu
 */
public class Demo251024 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame("My frame").setVisible(true);
//                new MyFrame2("My frame2").setVisible(true);
            }
        });
        
    }
    
}
