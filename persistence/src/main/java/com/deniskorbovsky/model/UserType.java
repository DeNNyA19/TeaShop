package com.deniskorbovsky.model;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOfUser_roles")
    private int id;

    private int idOfUser;

    private int idOfRole;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOfUser() {
        return idOfUser;
    }

    public void setIdOfUser(int idOfUser) {
        this.idOfUser = idOfUser;
    }

    public int getIdOfRole() {
        return idOfRole;
    }

    public void setIdOfRole(int idOfRole) {
        this.idOfRole = idOfRole;
    }
}
