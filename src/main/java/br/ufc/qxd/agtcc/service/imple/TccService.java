package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Professor;
import br.ufc.qxd.agtcc.model.entities.Tcc;
import br.ufc.qxd.agtcc.repository.ProfessorRepository;
import br.ufc.qxd.agtcc.repository.TccRepository;
import br.ufc.qxd.agtcc.service.interfaces.ITccService;


@Service
public class TccService implements ITccService {

	@Autowired
	private TccRepository tccRepository;

	@Autowired
	private ProfessorRepository professorRepository;
	
	
	@Override
	public Tcc save(Tcc tcc) {
		return tccRepository.save(tcc);
	}

	@Override
	public Tcc update(Tcc tcc) {
		return tccRepository.save(tcc);
	}

	@Override
	public void delete(Long id) {
		tccRepository.delete(id);
	}

	@Override
	public List<Tcc> findAll() {
		return tccRepository.findAll();
	}

	@Override
	public Tcc findOne(Long id) {
		return tccRepository.findOne(id);
	}

	
	public void alocarProfessor(Long idTcc,Long idProfessor){
		Tcc tcc = tccRepository.findOne(idTcc); 
		Professor professor = professorRepository.findOne(idProfessor);
		if(!tcc.getBancaDeDefesa().contains(professor)){
			tcc.addProfessorBancaDeDefesa(professor);			
			tccRepository.save(tcc);
		}
	}

	public void desalocarProfessor(Long idTcc,Long idProfessor){
		Tcc tcc = tccRepository.findOne(idTcc); 
		Professor professor = professorRepository.findOne(idProfessor);
		tcc.removeProfessorBancaDeDefesa(professor);
		tccRepository.save(tcc);
	}

	
}
