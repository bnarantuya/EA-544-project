package miu.edu.com.courseregistrationsystem.repository;

import miu.edu.com.courseregistrationsystem.domain.Registration;
import miu.edu.com.courseregistrationsystem.domain.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

    public List<Registration> getRegistrationsByStudent_Id(int studentId);
}
