package br.com.rodrigoeduque.orangespring.controller;

import br.com.rodrigoeduque.orangespring.controller.dto.AlunoDTO;
import br.com.rodrigoeduque.orangespring.modelo.Aluno;
import br.com.rodrigoeduque.orangespring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    /*
    //Utilizado para fins de teste - Sem utilizar o DTO
    @GetMapping ("/todos")
    public List<Aluno> listarTodosTeste(){
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }
*/
    @GetMapping ()
    public List<AlunoDTO> listarTodos(String nomeAluno) {

        if (nomeAluno == null){
            List<Aluno> alunos = alunoRepository.findAll();
            return AlunoDTO.converter(alunos);
        } else {
            System.out.println("Pesquisa: " + nomeAluno);
            List<Aluno> alunos = alunoRepository.findByNome(nomeAluno);
            return AlunoDTO.converter(alunos);
        }


    }


}
