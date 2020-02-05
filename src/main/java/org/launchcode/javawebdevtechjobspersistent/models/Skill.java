package org.launchcode.javawebdevtechjobspersistent.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Skill extends AbstractEntity {

    @NotBlank (message = "Description is Required.")
    @Size(max = 150)
    private String description;

    @ManyToMany(mappedBy = "skills")
        private final List<Job>jobs = new ArrayList<>();

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

    public List<Job> getJobs() {
        return jobs;
    }
}