package br.com.rodrigoeduque.orangespring.controller.form;

import br.com.rodrigoeduque.orangespring.modelo.Aluno;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlunoForm {

    @Size(max = 30)
    @NotNull
    @NotEmpty
    private String nome;
    @Size(max = 30)
    @NotNull
    @NotEmpty
    private String email;
    @Min(18)
    private Integer idade;

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Aluno converter() {
    return new Aluno(nome,email,idade);
    }

}
