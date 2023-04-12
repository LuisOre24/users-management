package com.enterprise.Collaborator.service;

import java.util.List;

public interface ICRUD<T> {

    T registerObject(T entity);
    T updateObject(T entity);
    T getOject(int id);
    List<T> getObjects();
    void deleteObject(int id);

}
