package miu.edu.com.courseregistrationsystem.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.com.courseregistrationsystem.domain.RegistrationEvent;
import miu.edu.com.courseregistrationsystem.domain.RegistrationStatus;
import miu.edu.com.courseregistrationsystem.service.RegistrationEventService;
import miu.edu.com.courseregistrationsystem.service.implementation.RegistrationEventServiceImpl;
import miu.edu.com.courseregistrationsystem.util.DateAndCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/registrationevents")
@RequiredArgsConstructor
public class RegistrationEventController {

//    @Autowired
    private final RegistrationEventServiceImpl registrationEventService;


    @GetMapping(value = "/get/{id}")
    public RegistrationEvent getRegistrationEvent(@PathVariable Integer id) {
        return registrationEventService.getRegistrationEvent(id);
    }

    @PostMapping(value = "/create")
    public RegistrationEvent create(@RequestBody RegistrationEvent registrationEvent) {
//        LocalDateTime start= DateAndCodeUtil.convertToDate(eventDto.getStartTime());
//        LocalDateTime end= DateAndCodeUtil.convertToDate(eventDto.getEndTime());
//        if (end.isBefore(start)){
//            new DateTimeException("End time must be after start time");
//        }
//        RegistrationEvent registrationEvent=new RegistrationEvent();
//            registrationEvent.setEndDateTime(end);
//        registrationEvent.setEndDateTime(start);
//        registrationEvent.setName(eventDto.getName());
        registrationEvent.setStatus(registrationEvent.getStartDateTime().isAfter(LocalDateTime.now())?RegistrationStatus.PENDING:RegistrationStatus.CLOSED);
        return registrationEventService.save(registrationEvent);
    }

    @GetMapping(value = "/all")
    public List<RegistrationEvent> getAllRegistrationEvent() {
        return registrationEventService.getAllRegistrationEvent();
    }

    @DeleteMapping(value = "/delete/{id}")
    public void delete(@PathVariable Integer id) {
        registrationEventService.delete(id);
    }

    @PatchMapping("updatestatus/{id}")
    public void updateStatus(@PathVariable("id") int id, @RequestParam Boolean processed){
        RegistrationStatus status = RegistrationStatus.PENDING;
        if (processed)
            status = RegistrationStatus.CLOSED;
        registrationEventService.updateStatus(id,status);
//        return ResponseEntity.ok(registrationEventService.updateStatus(id,status));
    }
    @PatchMapping("/addgroup/{id}")
    public ResponseEntity<?> addGroup(@PathVariable("id")int id, @RequestBody int group_id){

        return ResponseEntity.ok(registrationEventService.addRegGroup(id,group_id));
    }
    @GetMapping("latest")
    public ResponseEntity<RegistrationEvent> latestOne() {
        return registrationEventService.latestOne().map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("by-student-id/{id}")
    public ResponseEntity<RegistrationEvent> byStudentId(@PathVariable int id) {
        return registrationEventService.findByStudentId(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
