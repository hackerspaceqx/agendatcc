package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Aluno;
import br.ufc.qxd.agtcc.repository.AlunoRepository;
import br.ufc.qxd.agtcc.service.interfaces.IAlunoService;

@Service
public class AlunoService implements IAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno update(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public void delete(Long id) {
		alunoRepository.delete(id);
	}

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno findOne(Long id) {
		return alunoRepository.findOne(id);
	}

}
