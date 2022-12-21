package miu.edu.com.courseregistrationsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationGroup {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private  String title;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> student = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AcademicBlock> blocks = new ArrayList<>();

}
