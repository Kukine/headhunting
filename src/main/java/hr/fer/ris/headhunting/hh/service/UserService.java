package hr.fer.ris.headhunting.hh.service;

import hr.fer.ris.headhunting.hh.data.entity.Employee;
import hr.fer.ris.headhunting.hh.data.entity.Employer;
import hr.fer.ris.headhunting.hh.data.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(Employee employee);

    User register(Employer employer);

    User register(User user);
}
