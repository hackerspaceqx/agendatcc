package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.LocalDeDefesa;
import br.ufc.qxd.agtcc.repository.LocalDeDefesaRepository;
import br.ufc.qxd.agtcc.service.interfaces.ILocalDeDefesaService;


@Service
public class LocalDeDefesaService implements ILocalDeDefesaService {

	@Autowired
	private LocalDeDefesaRepository localDeDefesaRepository;
	
	@Override
	public LocalDeDefesa save(LocalDeDefesa localDeDefesa) {
		return localDeDefesaRepository.save(localDeDefesa);
	}

	@Override
	public LocalDeDefesa update(LocalDeDefesa localDeDefesa) {
		return localDeDefesaRepository.save(localDeDefesa);
	}

	@Override
	public void delete(Long id) {
		localDeDefesaRepository.delete(id);
	}

	@Override
	public List<LocalDeDefesa> findAll() {
		return localDeDefesaRepository.findAll();
	}

	@Override
	public LocalDeDefesa findOne(Long id) {
		return localDeDefesaRepository.findOne(id);
	}

}
