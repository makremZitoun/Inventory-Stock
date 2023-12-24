package tn.arabsoft.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.arabsoft.entities.Famille;

public interface FamilleRepository extends JpaRepository<Famille,Integer> {

}
