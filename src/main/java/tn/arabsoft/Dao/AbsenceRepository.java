package tn.arabsoft.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.arabsoft.entities.Absence;

public interface AbsenceRepository extends JpaRepository<Absence,Integer> {

}
