package br.ufc.qxd.agtcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.agtcc.model.entities.UsuarioPapel;


@Repository
public interface UsuarioPapelRepository extends JpaRepository<UsuarioPapel, Long>{
	
}
