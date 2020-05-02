package hr.fer.ris.headhunting.hh.controller;

import hr.fer.ris.headhunting.hh.data.entity.Employee;
import hr.fer.ris.headhunting.hh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getEmployees(){
        return this.employeeService.getEmployees();
    }

    @PostMapping("/register")
    public Employee register(@RequestBody Employee employee){
        return employeeService.insert(employee);
    }
}
