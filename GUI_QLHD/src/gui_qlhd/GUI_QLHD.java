/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gui_qlhd;

/**
 *
 * @author ThaiTran
 */
public class GUI_QLHD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                new Tab().createAndShowGUI();

            }
        });
    }

}
