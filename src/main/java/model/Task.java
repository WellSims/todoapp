/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;



/**
 *
 * @author welli
 */
public class Task {
    
    private int id;
    private int idProject;
    private String name;
    private String notes;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Date deadline;
    private Boolean completed;

    public Task(int id, int idProject, String name, String notes, String description, Date createdAt, Date updatedAt, Date deadline, Boolean completed) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.notes = notes;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deadline = deadline;
        this.completed = completed;
    }

    public Task(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.deadline = new Date();
        this.completed = false;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" +
                name + ", notes=" + notes + ", description=" + description + 
                ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + 
                ", deadline=" + deadline + ", completed=" + completed + '}';
    }

    
    
}
