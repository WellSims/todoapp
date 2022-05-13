/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.event.EventListenerList;
import javax.swing.table.AbstractTableModel;
import model.Task;

/**
 *
 * @author welli
 */
public class TaskTableModel extends AbstractTableModel {

    String [] columns = {"Nome", "Descrição","Prazo","Tarefa Concluída","Editar","Excluir"}; 
    List<Task> listTasks = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return listTasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex){
        return columns[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == 3;
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listTasks.isEmpty()) {
            return Object.class;
        }
        
        switch(columnIndex){
            
            case 0 :
                return String.class;
                
            case 1 :
                return String.class;
               
            case 2 :
                return String.class;
            
            case 3 :
                return Boolean.class;
                
            case 4 :
                return Object.class;
                
            case 5 :
               return Object.class;
               
            default:
                return Object.class;
        }
       
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        listTasks.get(rowIndex).setCompleted((boolean) aValue);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch(columnIndex){
            
            case 0 :
                return listTasks.get(rowIndex).getName();
                
            case 1 :
                return listTasks.get(rowIndex).getDescription();
               
            case 2 :
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return simpleDateFormat.format(listTasks.get(rowIndex).getDeadline());
            
            case 3 :
                return listTasks.get(rowIndex).getCompleted();
                
            case 4 :
                return "";
                
            case 5 :
                return "";
            
            default:
                return "Dados não encontrados";
            
        }
        
    }

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getListTasks() {
        return listTasks;
    }

    public void setListTasks(List<Task> listTasks) {
        this.listTasks = listTasks;
    }

    
    
    
    
}
