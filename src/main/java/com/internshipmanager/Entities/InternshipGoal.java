package com.internshipmanager.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "InternshipGoals")
public class InternshipGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Internship internship;

    @ManyToOne
    private Employee employee;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "place", length = 50)
    private String place;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

    @Column(name = "deadline")
    private Date deadline;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
