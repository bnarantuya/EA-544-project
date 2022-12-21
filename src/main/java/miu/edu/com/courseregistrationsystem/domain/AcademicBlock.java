package miu.edu.com.courseregistrationsystem.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AcademicBlock {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(unique = true)
    String code;

    private String semester;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "academic_block_id")

    private List<CourseOffering> courseOfferings = new ArrayList<>();

}
