package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Curso;
import br.ufc.qxd.agtcc.repository.CursoRepository;
import br.ufc.qxd.agtcc.service.interfaces.ICursoService;

@Service
public class CursoService implements ICursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso save(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public Curso update(Curso curso) {
		return cursoRepository.save(curso);
	}

	@Override
	public void delete(Long id) {
		cursoRepository.delete(id);
	}

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso findOne(Long id) {
		return cursoRepository.findOne(id);
	}

}
