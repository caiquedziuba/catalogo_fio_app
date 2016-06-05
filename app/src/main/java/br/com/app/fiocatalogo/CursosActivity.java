package br.com.app.fiocatalogo;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.List;

import br.com.app.fiocatalogo.adapter.CursoAdapter;
import br.com.app.fiocatalogo.dao.CursoDAO;
import br.com.app.fiocatalogo.domain.CursoDTO;

public class CursosActivity extends AppCompatActivity {

    private GridView gridCursos;
    private List<CursoDTO> listaCursos;
    private CursoAdapter adapter;
    private CursoDAO cursoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        listaCursos = populaCursos();
        adapter = new CursoAdapter(this, listaCursos);
        gridCursos = (GridView) findViewById(R.id.gridCursos);
        gridCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CursoDTO curso = listaCursos.get(position);
                Intent i = new Intent(CursosActivity.this, CursoDetalhesActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("curso", curso);
                i.putExtras(b);
                startActivity(i);
            }
        });
        if (gridCursos != null) {
            gridCursos.setAdapter(adapter);
        }
    }

    private List<CursoDTO> populaCursos() {
        return new CursoDAO(this).getListObjet();
    }

    @Override
    protected void onStart() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_left_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }

        super.onStart();
    }
}
