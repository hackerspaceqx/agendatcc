package br.ufc.qxd.agtcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.qxd.agtcc.model.entities.Aluno;

public interface AlunoRespository extends JpaRepository<Aluno, Long> {

	
	
}
