package in.ineuron.controller;

import java.time.LocalDate;

public class EmployeeDTO {


    private String name;
    private LocalDate DOB;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", DOB=" + DOB +
                ", email='" + email + '\'' +
                '}';
    }
}
