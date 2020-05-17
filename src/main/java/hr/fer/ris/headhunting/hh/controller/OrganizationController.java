package hr.fer.ris.headhunting.hh.controller;

import hr.fer.ris.headhunting.hh.data.entity.Organization;
import hr.fer.ris.headhunting.hh.data.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

    private OrganizationRepository organizationRepository;

    @Autowired
    public OrganizationController(OrganizationRepository organizationRepository){
        this.organizationRepository = organizationRepository;
    }

    @GetMapping("")
    public List<Organization> getOrganizations(){
        return this.organizationRepository.findAll();
    }

}
