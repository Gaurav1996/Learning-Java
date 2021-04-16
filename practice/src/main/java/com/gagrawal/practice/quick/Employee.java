package com.gagrawal.practice.quick;

/**
 * @author Gaurav
 * 24/03/21
 */
public class Employee {
    String name;
    Long empId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                '}';
    }
    public Employee(Employee that) {
        this.name =  that.getName();
        this.empId = that.getEmpId();
    }
    public Employee() {

    }
}
