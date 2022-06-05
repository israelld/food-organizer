package dev.israelld.foodorganizer.models;

import javax.persistence.*;

@Entity
public class Diet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;
    private String nameIdentifier;

    public Diet() {
    }

    public Diet(User user, String nameIdentifier) {
        this.user = user;
        this.nameIdentifier = nameIdentifier;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getNameIdentifier() {
        return nameIdentifier;
    }
    public void setNameIdentifier(String nameIdentifier) {
        this.nameIdentifier = nameIdentifier;
    }
}
