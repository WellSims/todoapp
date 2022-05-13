/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 *
 * @author welli
 */
public class TaskController {

    public void save(Task task) {

        String querySql = "INSERT INTO tasks(idProject,"
                + "name,"
                + "description,"
                + "notes,"
                + "completed,"
                + "deadline,"
                + "createdAt,"
                + "updatedAt) VALUES(?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(querySql);

             //INSERINDO DADOS A SEREM DA TASK
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.getCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            //EXECUTANDO A QUERY
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa "
                    + e.getMessage(), e);
        } finally {
            //FECHANDO A CONEXÃO COM O BANCO
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int taskId) {
        String querySql = "DELETE FROM tasks WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(querySql);
            statement.setInt(1, taskId);
             //EXECUTANDO A QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar a terefa"
                    + ex.getMessage(), ex);
        } finally {
            //FECHANDO A CONEXÃO COM O BANCO
            ConnectionFactory.closeConnection(connection, statement);

        }
    }

    public void update(Task task) {
        String querySQL = "UPDATE tasks SET "
                + "idProject = ?, "
                + "name = ?, "
                + "description = ?, "
                + "notes = ?, "
                + "completed = ?, "
                + "deadline = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(querySQL);
            
            //INSERINDO DADOS A SEREM ATUALIZADOS NA TASK
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.getCompleted());
            statement.setDate(6, new Date(task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date(task.getUpdatedAt().getTime()));
            statement.setInt(9,task.getId());
            
            //EXECUTANDO A QUERY
            statement.execute();
        } catch (Exception e) {
           throw new RuntimeException("Erro ao atualizar a tarefa " 
                   + e.getMessage(),e);
        } finally {
            //FECHANDO A CONEXÃO COM O BANCO
            ConnectionFactory.closeConnection(connection,statement);
        }

    }

    public List<Task> getAll(int idProject) {
        List<Task> taskList = new ArrayList<Task>();
        String sqlQuery = "SELECT * FROM tasks WHERE idProject = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(sqlQuery);
           statement.setInt(1, idProject);
           
            //EXECUTANDO A QUERY
           resultSet = statement.executeQuery();
                      
           while (resultSet.next()){
               Task task = new Task();
               
               
               //CAPTURANDO DADOS A SEREM RETORNADOS PARA A VIEW
               task.setId(resultSet.getInt("id"));
               task.setIdProject(resultSet.getInt("idProject"));
               task.setName(resultSet.getString("name"));
               task.setDescription(resultSet.getString("description"));
               task.setNotes(resultSet.getString("notes"));
               task.setCompleted(resultSet.getBoolean("completed"));
               task.setDeadline(resultSet.getDate("deadline"));
               task.setCreatedAt(resultSet.getDate("createdAt"));
               task.setUpdatedAt(resultSet.getDate("updatedAt"));   
               
               taskList.add(task);
           }
           
        } catch (Exception e) {
            throw new RuntimeException("Erro ao retornar as tarefas " + e.getMessage(),e);
        } finally {
            //FECHANDO A CONEXÃO COM O BANCO
            ConnectionFactory.closeConnection(connection,statement,resultSet);
        }
        return taskList;
       
    }
}
