package br.com.app.fiocatalogo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.app.fiocatalogo.adapter.ProfessorAdapter;
import br.com.app.fiocatalogo.dao.CursoDAO;
import br.com.app.fiocatalogo.dao.ProfessoresDAO;
import br.com.app.fiocatalogo.domain.CursoDTO;
import br.com.app.fiocatalogo.domain.ProfessorDTO;
import me.drakeet.materialdialog.MaterialDialog;

public class ProfessoresActivity extends AppCompatActivity {

    private ProfessoresDAO professoresDAO;
    private ProfessorAdapter adapter;
    private ListView rv_professores;
    private List<ProfessorDTO> listaProfessores;
    private MaterialDialog mMaterialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setNavigationIcon(R.drawable.ic_arrow_left_white_24dp);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
        setSupportActionBar(toolbar);

        professoresDAO = new ProfessoresDAO(this);

        listaProfessores = getProfessores();
        adapter = new ProfessorAdapter(this, listaProfessores);

        rv_professores = (ListView) findViewById(R.id.rv_professores);

        if (rv_professores != null) {
            rv_professores.setAdapter(adapter);
        }
        rv_professores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ProfessorDTO p = listaProfessores.get(position);

                callDialog(p.getEmail());
            }
        });
    }

    private List<ProfessorDTO> getProfessores() {
        return professoresDAO.getListObjet();
    }

    // UTIL
    private void callDialog( String message){
        mMaterialDialog = new MaterialDialog(this)
                .setTitle("Email")
                .setMessage( message )
                .setPositiveButton("Ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mMaterialDialog.dismiss();
                    }
                });
        mMaterialDialog.show();
    }
}
