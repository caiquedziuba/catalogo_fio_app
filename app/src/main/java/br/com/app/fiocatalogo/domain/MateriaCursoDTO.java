package br.com.app.fiocatalogo.domain;

import java.io.Serializable;

public class MateriaCursoDTO implements Serializable{

    private long _id;
    private MateriaDTO materia;
    private int cargaHorario;

    public MateriaCursoDTO() {
    }

    public MateriaDTO getMateria() {
        return materia;
    }

    public void setMateria(MateriaDTO materia) {
        this.materia = materia;
    }

    public int getCargaHorario() {
        return cargaHorario;
    }

    public void setCargaHorario(int cargaHorario) {
        this.cargaHorario = cargaHorario;
    }
}
