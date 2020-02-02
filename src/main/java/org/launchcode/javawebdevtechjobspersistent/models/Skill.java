package org.launchcode.javawebdevtechjobspersistent.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank (message = "Description is Required.")
    @Size(max = 150)
    private String description;

    public Skill(@Size(max = 150) String description) {
        this.description = description;
    }
    public Skill  () {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}