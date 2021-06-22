package br.com.rodrigoeduque.orangespring.controller.dto;

import br.com.rodrigoeduque.orangespring.modelo.Aluno;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoDTO {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;

    public AlunoDTO(Aluno aluno) {
        this.id = aluno.getId();
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
        this.idade = aluno.getIdade();
    }

    public static List<AlunoDTO> converter(List<Aluno> alunos) {
        return alunos.stream().map(AlunoDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Integer getIdade() {
        return idade;
    }
}
