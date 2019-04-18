package com.internshipmanager.Entities;

import javax.persistence.*;

@Entity
public class InternshipAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    private Internship internship;

    @Column(name = "title", nullable = false, length = 50)
    private String name;

    @Column(name = "url", nullable = false)
    private String url;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}