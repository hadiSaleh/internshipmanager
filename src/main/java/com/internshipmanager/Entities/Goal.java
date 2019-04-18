package com.internshipmanager.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    private Internship internship;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "place", length = 50)
    private String place;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "deadline", nullable = false)
    private Date deadline;

    @Column(name = "attachment_count")
    private int attachmentCount = 0;

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

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    public int getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(int attachmentCount) {
        this.attachmentCount = attachmentCount;
    }
}
