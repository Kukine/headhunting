package hr.fer.ris.headhunting.hh.data.repository;

import hr.fer.ris.headhunting.hh.data.entity.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
