package com.enterprise.Collaborator.entity;

import java.util.List;

public class Collaborator {

    private Integer idCollaborator;

    private String names;
    private String lastname;
    private Document document;
    private String nroDocument;
    private String telephone;
    private List<Project> projects;
    private List<Account> accounts;

    //
    private Integer idSupervisor;
}
