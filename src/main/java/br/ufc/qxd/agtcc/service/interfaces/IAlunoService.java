package br.ufc.qxd.agtcc.service.interfaces;

import java.util.List;

import br.ufc.qxd.agtcc.model.entities.Aluno;
import br.ufc.qxd.agtcc.model.entities.Usuario;

public interface IAlunoService {

	public Aluno save(Aluno aluno);

	public Aluno update(Aluno aluno);

	public Boolean delete(Long id);

	public List<Aluno> findAll();

	public Aluno findOne(Long id);

	public Aluno findByCpf(String cpf);
	
	public Aluno findByUsuario(Usuario usuario);
	
}
