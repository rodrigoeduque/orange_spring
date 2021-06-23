package br.com.rodrigoeduque.orangespring.controller;

import br.com.rodrigoeduque.orangespring.controller.dto.AlunoDTO;
import br.com.rodrigoeduque.orangespring.controller.dto.AlunoDetalheDto;
import br.com.rodrigoeduque.orangespring.controller.form.AlunoForm;
import br.com.rodrigoeduque.orangespring.modelo.Aluno;
import br.com.rodrigoeduque.orangespring.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

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
    @GetMapping()
    public List<AlunoDTO> listarTodos(String nomeAluno) {

        if (nomeAluno == null) {
            List<Aluno> alunos = alunoRepository.findAll();
            return AlunoDTO.converter(alunos);
        } else {
            System.out.println("Pesquisa: " + nomeAluno);
            List<Aluno> alunos = alunoRepository.findByNome(nomeAluno);
            return AlunoDTO.converter(alunos);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoDetalheDto> buscaDetalhada(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);

        if (aluno.isPresent()) {
            return ResponseEntity.ok(new AlunoDetalheDto(aluno.get()));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping
    public ResponseEntity<AlunoDTO> cadastrar(@RequestBody @Valid AlunoForm form, UriComponentsBuilder uriBuilder) {
        Aluno aluno = form.converter();
        alunoRepository.save(aluno);
        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(aluno.getId()).toUri();
        return ResponseEntity.created(uri).body(new AlunoDTO(aluno));
    }
}
