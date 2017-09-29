package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Aluno;

public interface IAlunoService {

	public Aluno save(Aluno aluno);

	public Aluno update(Aluno aluno);

	public void delete(Long id);

	public List<Aluno> findAll();

	public Aluno findOne(Long id);
	
}
