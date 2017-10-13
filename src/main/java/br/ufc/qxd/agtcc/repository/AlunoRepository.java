package br.ufc.qxd.agtcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ufc.qxd.agtcc.model.entities.Aluno;
import br.ufc.qxd.agtcc.model.entities.Usuario;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

	public Aluno findByCpf(String cpf);

	public Aluno findByUsuario(Usuario usuario);
}
