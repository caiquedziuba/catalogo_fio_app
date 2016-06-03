package br.com.app.fiocatalogo.domain;

import java.io.Serializable;

public class ProfessorDTO implements Serializable {
    public static final String[] columns = {"_id", "nome"};

    private long _id;
    private String nome;

    public ProfessorDTO() {
    }

    public ProfessorDTO(long _id, String nome) {
        this._id = _id;
        this.nome = nome;
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
}
