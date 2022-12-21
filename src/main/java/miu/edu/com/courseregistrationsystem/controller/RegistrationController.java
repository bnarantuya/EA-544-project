package miu.edu.com.courseregistrationsystem.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.com.courseregistrationsystem.domain.Registration;
import miu.edu.com.courseregistrationsystem.service.Registerer;
import miu.edu.com.courseregistrationsystem.service.implementation.RegistererImpl;
import miu.edu.com.courseregistrationsystem.service.implementation.RegistrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registrations")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationServiceImpl registrationService;
    @GetMapping("/{id}")
    public List<Registration> getRegistration(@PathVariable int id) {

        return registrationService.getRegistrations(id);

    }

}
