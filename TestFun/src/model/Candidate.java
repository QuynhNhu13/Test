package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Candidate {
    private String id;
    private String name;
    private Date dateOfBirthday;
    private double grades;
    private String email;

    public Candidate(String id, String name, String dateOfBirthday, double grades, String email) {
        this.id = id;
        this.name = name;
        this.setDateOfBirthday(dateOfBirthday);
        this.grades = grades;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirthday() {
        return dateOfBirthday;
    }

    public double getGrades() {
        return grades;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirthday(String dateOfBirthday) {
        SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy");
        try {
            this.dateOfBirthday = a.parse(dateOfBirthday);
        } catch (ParseException e) {
            System.out.println("Invalid!!!");
            this.dateOfBirthday = new Date(); 
        }
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return  id + ", " + name + ", "
                + sdf.format(dateOfBirthday) + ", " +
                + grades + ", " + email ;
    }
}

