package br.com.app.fiocatalogo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.app.fiocatalogo.R;
import br.com.app.fiocatalogo.dao.CursoDAO;
import br.com.app.fiocatalogo.domain.CursoDTO;
import br.com.app.fiocatalogo.domain.ProfessorDTO;

public class ProfessorAdapter extends BaseAdapter {
    private Context c;
    private List<ProfessorDTO> listaProfessores;

    public ProfessorAdapter(Context c, List<ProfessorDTO> listaProfessores) {
        this.c = c;
        this.listaProfessores = listaProfessores;
    }

    @Override
    public int getCount() {
        return listaProfessores.size();
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
        View view = LayoutInflater.from(c).inflate(R.layout.view_professor, parent, false);
        ProfessorDTO professor = listaProfessores.get(position);

        if(professor != null){
            TextView txt_professor_name = (TextView) view.findViewById(R.id.txt_professor_nome);
            txt_professor_name.setText(professor.getNome());

            TextView txt_professor_curso = (TextView) view.findViewById(R.id.txt_professor_curso);
            txt_professor_curso.setText(professor.getCurso());

//            ImageView iv_professor_foto = (ImageView) view.findViewById(R.id.iv_professor_foto);
//            int id = c.getResources().getIdentifier(professor.getFoto().replace(".png", ""), "mipmap", c.getPackageName());
//            iv_professor_foto.setImageResource(id);
        }

        return view;
    }
}
