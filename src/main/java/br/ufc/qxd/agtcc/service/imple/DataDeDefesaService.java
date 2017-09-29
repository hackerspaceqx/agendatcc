package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.DataDeDefesa;
import br.ufc.qxd.agtcc.repository.DataDeDefesaRepository;
import br.ufc.qxd.agtcc.service.interfaces.IDataDeDefesaService;


@Service
public class DataDeDefesaService implements IDataDeDefesaService {

	@Autowired
	private DataDeDefesaRepository dataDeDefesaRepository;
	
	@Override
	public DataDeDefesa save(DataDeDefesa dataDeDefesa) {
		return dataDeDefesaRepository.save(dataDeDefesa);
	}

	@Override
	public DataDeDefesa update(DataDeDefesa dataDeDefesa) {
		return dataDeDefesaRepository.save(dataDeDefesa);
	}

	@Override
	public void delete(Long id) {
		dataDeDefesaRepository.delete(id);
	}

	@Override
	public List<DataDeDefesa> findAll() {
		return dataDeDefesaRepository.findAll();
	}

	@Override
	public DataDeDefesa findOne(Long id) {
		return dataDeDefesaRepository.findOne(id);
	}

}
