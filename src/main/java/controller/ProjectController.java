/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Date;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Project;


/**
 *
 * @author welli
 */
public class ProjectController {
    
    public void save(Project project) {

        String querySql = "INSERT INTO projects (name,"
                + "description,"
                + "createdAt,"
                + "updatedAt) VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(querySql);
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            
            //EXECUTANDO A QUERY
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o projeto "
                    + e.getMessage(), e);
        } finally {
            //FECHANDO A CONEXÃO COM O BANCO
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int projectId) {
        String querySql = "DELETE FROM projects WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(querySql);
            statement.setInt(1, projectId);
             //EXECUTANDO A QUERY
            statement.execute();
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar o projeto"
                    + ex.getMessage(), ex);
        } finally {
            //FECHANDO A CONEXÃO COM O BANCO
            ConnectionFactory.closeConnection(connection, statement);

        }
    }

    public void update(Project project) {
        String querySQL = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
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
            
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            
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

    public List<Project> getAll() {
        List<Project> projectList = new ArrayList<Project>();
        String sqlQuery = "SELECT * FROM projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            //ESTABELECENDO CONEXÃO COM O BANCO DE DADOS
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(sqlQuery);
           
            //EXECUTANDO A QUERY
           resultSet = statement.executeQuery();
                      
           while (resultSet.next()){
               Project project = new Project();
               
               //CAPTURANDO DADOS A SEREM RETORNADOS PARA A VIEW
               project.setId(resultSet.getInt("id"));
               project.setName(resultSet.getString("name"));
               project.setDescription(resultSet.getString("description"));
               project.setCreatedAt(resultSet.getDate("createdAt"));
               project.setUpdatedAt(resultSet.getDate("updatedAt"));
               
               projectList.add(project);
           }
           
        } catch (Exception e) {
            throw new RuntimeException("Erro ao retornar as tarefas " + e.getMessage(),e);
        } finally {
            //FECHANDO A CONEXÃO COM O BANCO
            ConnectionFactory.closeConnection(connection,statement,resultSet);
        }
        return projectList;
       
    }

    
}
