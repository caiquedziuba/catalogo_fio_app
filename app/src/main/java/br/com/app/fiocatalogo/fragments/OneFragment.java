package br.com.app.fiocatalogo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

import br.com.app.fiocatalogo.R;
import br.com.app.fiocatalogo.domain.CursoDTO;

public class OneFragment extends Fragment{
    private ImageView iv_curso_foto;
    private TextView txt_curso_titulo,
            txt_curso_subtitulo,
            txt_curso_valor,
            txt_curso_tempo,
            txt_curso_descricao;

    private CursoDTO curso;

    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    private DetalhesCursoListenner listenner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listenner = (DetalhesCursoListenner) context;
        }catch (ClassCastException cce){
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        init(view);
        try{
            curso = listenner.getDetalhesCurso();
            initCurso(curso);
        }catch (Exception e){
            Log.v("TAG", e.getMessage());
        }

        return view;
    }

    private void init(View view) {
        iv_curso_foto = (ImageView) view.findViewById(R.id.iv_curso_foto);
        txt_curso_titulo = (TextView) view.findViewById(R.id.txt_curso_titulo);
        txt_curso_subtitulo = (TextView) view.findViewById(R.id.txt_curso_subtitulo);
        txt_curso_valor = (TextView) view.findViewById(R.id.txt_curso_valor);
        txt_curso_tempo = (TextView) view.findViewById(R.id.txt_curso_tempo);
        txt_curso_descricao = (TextView) view.findViewById(R.id.txt_curso_descricao);
    }

    private void initCurso(CursoDTO curso) {
        txt_curso_titulo.setText(curso.getTitulo());
        txt_curso_subtitulo.setText(curso.getSubTitulo());
        txt_curso_valor.setText(nf.format(curso.getValor()));
        txt_curso_tempo.setText(curso.getTempo());
        txt_curso_descricao.setText(curso.getDescricao());

        int id = getResources().getIdentifier(curso.getFoto().replace(".png", ""), "mipmap", getActivity().getPackageName());
        iv_curso_foto.setImageResource(id);
    }

    public interface DetalhesCursoListenner {
        CursoDTO getDetalhesCurso();
    }
}
