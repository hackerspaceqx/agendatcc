package br.ufc.qxd.agtcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.agtcc.model.entities.Tcc;

@Repository
public interface TccRepository extends JpaRepository<Tcc, Long>{

}
