package hr.fer.ris.headhunting.hh.data.repository;

import hr.fer.ris.headhunting.hh.data.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByName(String name);
}
