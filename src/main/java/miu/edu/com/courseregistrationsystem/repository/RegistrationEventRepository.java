package miu.edu.com.courseregistrationsystem.repository;

import miu.edu.com.courseregistrationsystem.domain.RegistrationEvent;
import miu.edu.com.courseregistrationsystem.domain.RegistrationGroup;
import miu.edu.com.courseregistrationsystem.domain.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RegistrationEventRepository extends JpaRepository<RegistrationEvent, Integer> {

    List<RegistrationEvent> findAllByStatusInOrderByEndDateTimeDesc(RegistrationStatus[] statuses); // [0, 1, 2]
    Optional<RegistrationEvent> findByGroup(RegistrationGroup group);
}
