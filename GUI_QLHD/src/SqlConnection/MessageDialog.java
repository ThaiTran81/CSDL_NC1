/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SqlConnection;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author huynhkha
 */
public class MessageDialog {
    
    public static void showMessageDialog(Component parent, String message, String title){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void showErrorDialog(Component parent, String message, String title){
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static int showConfirmDialog(Component parent, String message, String title){
        return JOptionPane.showConfirmDialog(parent, message, title, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
    }
    
}
