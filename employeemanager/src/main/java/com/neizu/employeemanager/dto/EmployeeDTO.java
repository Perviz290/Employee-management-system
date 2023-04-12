package com.neizu.employeemanager.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EmployeeDTO implements Serializable {

    private String name;
    private String email;
    private String jobTitle;
    private String phone;

}
