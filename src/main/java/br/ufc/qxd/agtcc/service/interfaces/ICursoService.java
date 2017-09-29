package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Curso;


public interface ICursoService {

	public Curso save(Curso curso);

	public Curso update(Curso curso);

	public void delete(Long id);

	public List<Curso> findAll();

	public Curso findOne(Long id);
	
}
