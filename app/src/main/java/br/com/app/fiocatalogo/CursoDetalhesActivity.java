package br.com.app.fiocatalogo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import br.com.app.fiocatalogo.dao.CursoDAO;
import br.com.app.fiocatalogo.domain.CursoDTO;

public class CursoDetalhesActivity extends AppCompatActivity {
    private CursoDTO curso;
    private ImageView iv_curso_foto;
    private TextView txt_curso_titulo,
            txt_curso_subtitulo,
            txt_curso_valor,
            txt_curso_tempo,
            txt_curso_coordenado,
            txt_curso_descricao;

    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso_detalhes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        iv_curso_foto = (ImageView) findViewById(R.id.iv_curso_foto);
        txt_curso_titulo = (TextView) findViewById(R.id.txt_curso_titulo);
        txt_curso_subtitulo = (TextView) findViewById(R.id.txt_curso_subtitulo);
        txt_curso_valor = (TextView) findViewById(R.id.txt_curso_valor);
        txt_curso_tempo = (TextView) findViewById(R.id.txt_curso_tempo);
        txt_curso_coordenado = (TextView) findViewById(R.id.txt_curso_coordenador);
        txt_curso_descricao = (TextView) findViewById(R.id.txt_curso_descricao);

        Bundle b = getIntent().getExtras();
        if(b != null) {
            curso = (CursoDTO) b.getSerializable("curso");

            int id = getResources().getIdentifier(curso.getFoto().replace(".png", ""), "mipmap", getPackageName());
            iv_curso_foto.setImageResource(id);

            txt_curso_titulo.setText(curso.getTitulo());
            txt_curso_subtitulo.setText(curso.getSubTitulo());
            txt_curso_valor.setText(nf.format(curso.getValor()));
            txt_curso_tempo.setText(curso.getTempo());
            txt_curso_coordenado.setText(curso.getCoordenador().getNome());
            txt_curso_descricao.setText(curso.getDescricao());
        }
    }
}
