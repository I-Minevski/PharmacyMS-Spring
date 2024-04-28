package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Drug;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long>{

}
