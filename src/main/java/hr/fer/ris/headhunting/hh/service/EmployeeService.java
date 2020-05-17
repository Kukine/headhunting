package hr.fer.ris.headhunting.hh.service;

import hr.fer.ris.headhunting.hh.data.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getEmployees();

    Employee insert(Employee employee);

    List<Employee> getEmployeesBySkill(String skillName);

}
