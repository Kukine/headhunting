package hr.fer.ris.headhunting.hh.service;

import hr.fer.ris.headhunting.hh.data.entity.Employer;

import java.util.List;

public interface EmployerService {

    List<Employer> getEmployers();

    Employer register(Employer Employer);
}
