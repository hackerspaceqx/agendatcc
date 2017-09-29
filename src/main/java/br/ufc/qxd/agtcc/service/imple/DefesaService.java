package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Defesa;
import br.ufc.qxd.agtcc.repository.DefesaRepository;
import br.ufc.qxd.agtcc.service.interfaces.IDefesaService;


@Service
public class DefesaService implements IDefesaService {

	@Autowired
	private DefesaRepository defesaRepository;
	
	@Override
	public Defesa save(Defesa defesa) {
		return defesaRepository.save(defesa);
	}

	@Override
	public Defesa update(Defesa defesa) {
		return defesaRepository.save(defesa);
	}

	@Override
	public void delete(Long id) {
		defesaRepository.delete(id);
	}

	@Override
	public List<Defesa> findAll() {
		return defesaRepository.findAll();
	}

	@Override
	public Defesa findOne(Long id) {
		return defesaRepository.findOne(id);
	}

}
