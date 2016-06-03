package br.com.app.fiocatalogo.domain;

import java.io.Serializable;
import java.util.List;

public class CursoDTO implements Serializable {
    public static final String[] columns = {"_id", "titulo", "sub_titulo", "tempo", "descricao", "id_coordenador", "palavra", "valor", "foto"};

    private long _id;
    private String titulo;
    private String subTitulo;
    private String Descricao;
    private String tempo;
    private ProfessorDTO coordenador;
    private String palavraCoordenador;
    private Double valor;
    private List<MateriaCursoDTO> materiasCurso;
    private String foto;

    public CursoDTO() {
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubTitulo() {
        return subTitulo;
    }

    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public ProfessorDTO getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(ProfessorDTO coordenador) {
        this.coordenador = coordenador;
    }

    public String getPalavraCoordenador() {
        return palavraCoordenador;
    }

    public void setPalavraCoordenador(String palavraCoordenador) {
        this.palavraCoordenador = palavraCoordenador;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<MateriaCursoDTO> getMateriasCurso() {
        return materiasCurso;
    }

    public void setMateriasCurso(List<MateriaCursoDTO> materiasCurso) {
        this.materiasCurso = materiasCurso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
}
