package br.com.app.fiocatalogo.domain;

import java.io.Serializable;

public class ProfessorDTO implements Serializable {
    public static final String[] columns = {"_id", "nome", "email"};

    private long _id;
    private String nome;
    private String email;
    private String curso;

    public ProfessorDTO() {
    }

    public ProfessorDTO(String nome, String email, String curso) {
        this.nome = nome;
        this.email = email;
        this.curso = curso;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
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

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
