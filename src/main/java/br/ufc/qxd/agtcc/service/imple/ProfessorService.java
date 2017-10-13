package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Professor;
import br.ufc.qxd.agtcc.repository.ProfessorRepository;
import br.ufc.qxd.agtcc.service.interfaces.IProfessorService;

@Service
public class ProfessorService implements IProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Override
	public Professor save(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public Professor update(Professor professor) {
		return professorRepository.save(professor);
	}

	@Override
	public void delete(Long id) {
		professorRepository.delete(id);
	}

	@Override
	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	@Override
	public Professor findOne(Long id) {
		return professorRepository.findOne(id);
	}
	
	

}
