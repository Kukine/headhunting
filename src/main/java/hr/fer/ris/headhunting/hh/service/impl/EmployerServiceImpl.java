package hr.fer.ris.headhunting.hh.service.impl;

import hr.fer.ris.headhunting.hh.data.entity.Employer;
import hr.fer.ris.headhunting.hh.data.entity.Organization;
import hr.fer.ris.headhunting.hh.data.repository.EmployerRepository;
import hr.fer.ris.headhunting.hh.data.repository.OrganizationRepository;
import hr.fer.ris.headhunting.hh.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployerServiceImpl implements EmployerService {

    EmployerRepository employerRepository;
    OrganizationRepository organizationRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository, OrganizationRepository organizationRepository, PasswordEncoder passwordEncoder){
        this.employerRepository = employerRepository;
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Employer> getEmployers() {
        return this.employerRepository.findAll();
    }

    @Override
    public Employer register(Employer employer) {
        if(employer.getOrganization().getId() == null){
            Optional<Organization> byName = organizationRepository.findByName(employer.getOrganization().getName());
            if(byName.isPresent()){
                employer.setOrganization(byName.get());
            }
            else{
                Organization save = organizationRepository.save(employer.getOrganization());
                employer.setOrganization(save);
            }
        }
        employer.setPassword(passwordEncoder.encode(employer.getPassword()));
        return this.employerRepository.save(employer);
    }
}
