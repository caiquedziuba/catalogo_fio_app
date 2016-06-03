package br.com.app.fiocatalogo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.app.fiocatalogo.R;
import br.com.app.fiocatalogo.domain.CursoDTO;

public class CursoAdapter extends BaseAdapter {
    private Context c;
    private List<CursoDTO> listaCursos;

    public CursoAdapter(Context c, List<CursoDTO> listaCursos) {
        this.c = c;
        this.listaCursos = listaCursos;
    }

    @Override
    public int getCount() {
        return listaCursos.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(c).inflate(R.layout.view_curso, parent, false);
        CursoDTO curso = listaCursos.get(position);

        if(curso != null){
            TextView txt_curso_name = (TextView) view.findViewById(R.id.txt_curso_titulo);
            txt_curso_name.setText(curso.getTitulo());

            ImageView iv_curso_foto = (ImageView) view.findViewById(R.id.iv_curso_foto);
            int id = c.getResources().getIdentifier(curso.getFoto().replace(".png", ""), "mipmap", c.getPackageName());
            iv_curso_foto.setImageResource(id);
        }

        return view;
    }
}
