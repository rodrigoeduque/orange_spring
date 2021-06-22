package br.com.rodrigoeduque.orangespring.repository;

import br.com.rodrigoeduque.orangespring.modelo.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long> {

    List<Aluno> findByNome(String nomeAluno);
}
