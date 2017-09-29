package br.ufc.qxd.agtcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.agtcc.model.entities.DataDeDefesa;

@Repository
public interface DataDeDefesaRepository extends JpaRepository<DataDeDefesa, Long>{

}
