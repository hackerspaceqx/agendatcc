package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Matricula;
import br.ufc.qxd.agtcc.repository.MatriculaRepository;
import br.ufc.qxd.agtcc.service.interfaces.IMatriculaService;

@Service
public class MatriculaService implements IMatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Override
	public Matricula save(Matricula Matricula) {
		return matriculaRepository.save(Matricula);
	}

	@Override
	public Matricula update(Matricula Matricula) {
		return matriculaRepository.save(Matricula);
	}

	@Override
	public void delete(Long id) {
		matriculaRepository.delete(id);
	}

	@Override
	public List<Matricula> findAll() {
		return matriculaRepository.findAll();
	}

	@Override
	public Matricula findOne(Long id) {
		return matriculaRepository.findOne(id);
	}

}
