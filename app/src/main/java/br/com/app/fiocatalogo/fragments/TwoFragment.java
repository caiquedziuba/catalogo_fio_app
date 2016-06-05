package br.com.app.fiocatalogo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.app.fiocatalogo.R;
import br.com.app.fiocatalogo.domain.CursoDTO;

public class TwoFragment extends Fragment{
    private TextView txt_curso_coordenado,
            txt_curso_palavra;

    private DetalhesCoordenadorCursoListenner listenner;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            listenner = (DetalhesCoordenadorCursoListenner) context;
        }catch (ClassCastException cce){
            throw new ClassCastException(context.toString()
                    + " must implement IFragmentToActivity");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        init(view);
        CursoDTO curso = listenner.getCoordenadorCurso();
        initCurso(curso);

        return view;
    }


    private void init(View view) {
        txt_curso_coordenado = (TextView) view.findViewById(R.id.txt_curso_coordenador);
        txt_curso_palavra = (TextView) view.findViewById(R.id.txt_curso_palavra);
    }

    private void initCurso(CursoDTO curso) {
        txt_curso_coordenado.setText(curso.getCoordenador().getNome());
        txt_curso_palavra.setText(curso.getPalavraCoordenador());
    }

    public interface DetalhesCoordenadorCursoListenner {
        CursoDTO getCoordenadorCurso();
    }
}
