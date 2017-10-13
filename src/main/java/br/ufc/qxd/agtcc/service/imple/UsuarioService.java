package br.ufc.qxd.agtcc.service.imple;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.qxd.agtcc.model.entities.Aluno;
import br.ufc.qxd.agtcc.model.entities.Usuario;
import br.ufc.qxd.agtcc.repository.UsuarioRepository;
import br.ufc.qxd.agtcc.service.interfaces.IAlunoService;
import br.ufc.qxd.agtcc.service.interfaces.IUsuarioService;

@Transactional
@Service
public class UsuarioService implements IUsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private IAlunoService alunoService;
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	public Usuario update(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(long id) {
		Aluno aluno = alunoService.findByUsuario(this.findOne(id));
		if(aluno != null && aluno.getUsuario() != null) {
			aluno.setUsuario(null);
			alunoService.update(aluno);
		}
		usuarioRepository.delete(id);
	}

	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findOne(long id) {
		return usuarioRepository.findOne(id);
	}

	@Override
	public Usuario findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}
	
}
