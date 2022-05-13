/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import model.Task;

/**
 *
 * @author welli
 */
public class ButtonColumnCellRenderer extends DefaultTableCellRenderer {

    public ButtonColumnCellRenderer(String buttonType) {
        this.buttonType = buttonType;
    }
     private String buttonType;
     
     @Override
     public Component getTableCellRendererComponent(JTable table, Object value,
     boolean isSelected, boolean hasFocus, int row, int column) {
        
         JLabel label = (JLabel) super.getTableCellRendererComponent(table, 
                 value, isSelected, hasFocus, row, column);
         label.setHorizontalAlignment(CENTER);
         label.setIcon(new ImageIcon(getClass().getResource("/"+buttonType+".png")));
         
         return label;
         
     }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }
    
}
