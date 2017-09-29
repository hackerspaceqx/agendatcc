package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Documento;


public interface IDocumentoService {

	public Documento save(Documento documento);

	public Documento update(Documento documento);

	public void delete(Long id);

	public List<Documento> findAll();

	public Documento findOne(Long id);
	
}
