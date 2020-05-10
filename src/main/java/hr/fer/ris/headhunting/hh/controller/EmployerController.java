package hr.fer.ris.headhunting.hh.controller;

import hr.fer.ris.headhunting.hh.data.entity.Employer;
import hr.fer.ris.headhunting.hh.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employer")
public class EmployerController {

    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService){
        this.employerService = employerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Employer> register(@RequestBody Employer employer){
        Employer register = this.employerService.register(employer);
        return ResponseEntity.ok(register);
    }

    @GetMapping("")
    public ResponseEntity<List<Employer>> getAllEmployers(){
        List<Employer> employers = this.employerService.getEmployers();
        return ResponseEntity.ok(employers);
    }
}
