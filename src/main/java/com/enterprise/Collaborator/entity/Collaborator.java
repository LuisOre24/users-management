package com.enterprise.Collaborator.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCollaborator;
    private String names;
    private String lastname;
    @OneToOne
    @JoinColumn(name = "id_document", referencedColumnName = "idDocument")
    private Document document;
    private String nroDocument;
    private String telephone;
    @ManyToOne
    @JoinColumn(name = "id_position", foreignKey = @ForeignKey(name = "fk_collaborator_position"))
    private  Position position;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "collaborator_project", joinColumns = @JoinColumn(name = "id_collaborator", referencedColumnName = "idCollaborator"), inverseJoinColumns = @JoinColumn(name = "id_project", referencedColumnName = "idProject"))
    private List<Project> projects;
    @OneToMany(mappedBy = "collaborator", cascade = {CascadeType.ALL})
    private List<Account> accounts;
    private Integer idSupervisor;
    private Integer state;


    public Integer getIdCollaborator() {
        return idCollaborator;
    }

    public void setIdCollaborator(Integer idCollaborator) {
        this.idCollaborator = idCollaborator;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getNroDocument() {
        return nroDocument;
    }

    public void setNroDocument(String nroDocument) {
        this.nroDocument = nroDocument;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(Integer idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
