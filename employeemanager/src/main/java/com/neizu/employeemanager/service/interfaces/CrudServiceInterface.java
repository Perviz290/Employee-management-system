package com.neizu.employeemanager.service.interfaces;

import java.util.List;

public interface CrudServiceInterface <T,C,Long> {

    C create(T t);

    List<C> getAll();

    C update(Long id, T t);

    C findById(Long id);

    void deleteById(Long id);









}
