package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Aluno;
import br.ufc.qxd.agtcc.model.entities.Usuario;
import br.ufc.qxd.agtcc.repository.AlunoRepository;
import br.ufc.qxd.agtcc.service.interfaces.IAlunoService;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioService;

@Service
public class AlunoService implements IAlunoService {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private IUsuarioService usuarioService;

	
	@Override
	public Aluno save(Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@Override
	public Aluno update(Aluno aluno) {
		aluno.setUsuario(usuarioService.findOne((alunoRepository.findOne(aluno.getId())).getUsuario().getId()));
		return alunoRepository.save(aluno);
	}

	@Override
	public Boolean delete(Long id) {
		Usuario usuario = (alunoRepository.findOne(id)).getUsuario();
		if(usuario != null) {
			usuarioService.delete(usuario.getId());
		}
		alunoRepository.delete(id);
		return true;
	}

	@Override
	public List<Aluno> findAll() {
		return alunoRepository.findAll();
	}

	@Override
	public Aluno findOne(Long id) {
		return alunoRepository.findOne(id);
	}

	@Override
	public Aluno findByCpf(String cpf) {
		return alunoRepository.findByCpf(cpf);
	}

	@Override
	public Aluno findByUsuario(Usuario usuario) {
		return alunoRepository.findByUsuario(usuario);
	}

}
