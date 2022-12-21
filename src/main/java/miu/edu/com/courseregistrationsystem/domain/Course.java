package miu.edu.com.courseregistrationsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    @Column(unique = true)
    private String code;
    @ManyToMany
    private List<Course> prerequisite = new ArrayList<Course>();
}
