package hr.fer.ris.headhunting.hh.service.impl;

import hr.fer.ris.headhunting.hh.data.entity.Employee;
import hr.fer.ris.headhunting.hh.data.entity.Experience;
import hr.fer.ris.headhunting.hh.data.entity.Skill;
import hr.fer.ris.headhunting.hh.data.entity.User;
import hr.fer.ris.headhunting.hh.data.repository.EmployeeRepository;
import hr.fer.ris.headhunting.hh.data.repository.SkillRepository;
import hr.fer.ris.headhunting.hh.data.repository.UserRepository;
import hr.fer.ris.headhunting.hh.service.EmployeeService;
import hr.fer.ris.headhunting.hh.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private ExperienceService experienceService;



    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, UserRepository userRepository, PasswordEncoder passwordEncoder, ExperienceService experienceService){
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.experienceService = experienceService;
    }

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee insert(Employee employee){
        Optional<User> byEmail = this.userRepository.findByEmail(employee.getEmail());
        if(byEmail.isPresent()){
            throw new RuntimeException("User with email already exists");
        }
        for(Experience exp: employee.getExperienceList()){
            exp.setUser(employee);
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return this.employeeRepository.save(employee);
    }

    public List<Employee> getEmployeesBySkill(String skillName){
        List<Experience> bySkill = experienceService.getBySkill(skillName);
        List<Employee> employees = new ArrayList<>();
        for(Experience experience : bySkill) {
            Employee byId = employeeRepository.findById(experience.getUser().getId()).orElseThrow(() -> new RuntimeException("no user found"));
            employees.add(byId);
        }
        return employees;
    }
}
