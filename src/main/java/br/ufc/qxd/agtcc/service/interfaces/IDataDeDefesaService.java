package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.DataDeDefesa;


public interface IDataDeDefesaService {

	public DataDeDefesa save(DataDeDefesa dataDeDefesa);

	public DataDeDefesa update(DataDeDefesa dataDeDefesa);

	public void delete(Long id);

	public List<DataDeDefesa> findAll();

	public DataDeDefesa findOne(Long id);
	
}
