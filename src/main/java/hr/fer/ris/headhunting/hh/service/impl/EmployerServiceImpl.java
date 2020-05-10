package hr.fer.ris.headhunting.hh.service.impl;

import hr.fer.ris.headhunting.hh.data.entity.Employer;
import hr.fer.ris.headhunting.hh.data.repository.EmployerRepository;
import hr.fer.ris.headhunting.hh.service.EmployerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    EmployerRepository employerRepository;

    public EmployerServiceImpl(EmployerRepository employerRepository){
        this.employerRepository = employerRepository;
    }

    @Override
    public List<Employer> getEmployers() {
        return this.employerRepository.findAll();
    }

    @Override
    public Employer register(Employer employer) {
        return this.employerRepository.save(employer);
    }
}
