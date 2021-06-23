package br.com.rodrigoeduque.orangespring.controller.dto;

import br.com.rodrigoeduque.orangespring.modelo.Aluno;

public class AlunoDetalheDto {

    private String nome;
    private String email;

    public AlunoDetalheDto(Aluno aluno) {
        this.nome = aluno.getNome();
        this.email = aluno.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

