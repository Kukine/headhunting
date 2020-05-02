package hr.fer.ris.headhunting.hh.service.impl;

import hr.fer.ris.headhunting.hh.data.entity.Employee;
import hr.fer.ris.headhunting.hh.data.entity.Employer;
import hr.fer.ris.headhunting.hh.data.entity.User;
import hr.fer.ris.headhunting.hh.data.repository.UserRepository;
import hr.fer.ris.headhunting.hh.service.EmployeeService;
import hr.fer.ris.headhunting.hh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserDetailsServiceImpl implements UserService {

    private UserRepository userRepository;
    private EmployeeService employeeService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, EmployeeService employeeService, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.employeeService = employeeService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByEmail(username).orElseThrow(RuntimeException::new);

        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), new HashSet<>());
    }

    @Override
    public User register(Employee employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return this.employeeService.insert(employee);
    }

    @Override
    public User register(Employer employer) {
        return null;
    }

    public User register(User user){
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(newUser);
    }
}
