package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Matricula;

public interface IMatriculaService {

	public Matricula save(Matricula matricula);

	public Matricula update(Matricula matricula);

	public void delete(Long id);

	public List<Matricula> findAll();

	public Matricula findOne(Long id);
	
}
