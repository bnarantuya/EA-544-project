package miu.edu.com.courseregistrationsystem.controller;

import miu.edu.com.courseregistrationsystem.dto.RegistrationRequestDTO;
import miu.edu.com.courseregistrationsystem.service.RegistrationService;
import miu.edu.com.courseregistrationsystem.service.implementation.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/registration")
public class RegistrationRequestController {
    @Autowired
    RegistrationServiceImpl registrationService;
    @PostMapping("/")
   public ResponseEntity<?> registration(@RequestBody RegistrationRequestDTO registrationRequestDTO){

        System.out.println("ADASDASDASDA");
        return ResponseEntity.ok( registrationService.request(registrationRequestDTO));
    }
}
