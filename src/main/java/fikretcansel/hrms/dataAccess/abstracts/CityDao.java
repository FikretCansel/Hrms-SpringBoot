package fikretcansel.hrms.dataAccess.abstracts;

import fikretcansel.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City,Integer> {
}
