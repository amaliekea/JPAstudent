package org.example.jpastudent2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Unicode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int unicode;
    char bogstav;
    String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnicode() {
        return unicode;
    }

    public void setUnicode(int unicode) {
        this.unicode = unicode;
    }

    public char getBogstav() {
        return bogstav;
    }

    public void setBogstav(char bogstav) {
        this.bogstav = bogstav;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
