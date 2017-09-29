package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Professor;


public interface IProfessorService {

	public Professor save(Professor professor);

	public Professor update(Professor professor);

	public void delete(Long id);

	public List<Professor> findAll();

	public Professor findOne(Long id);
	
}
