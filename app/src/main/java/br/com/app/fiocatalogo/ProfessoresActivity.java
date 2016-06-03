package br.com.app.fiocatalogo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.List;

import br.com.app.fiocatalogo.adapter.ProfessorAdapter;
import br.com.app.fiocatalogo.dao.ProfessoresDAO;
import br.com.app.fiocatalogo.domain.CursoDTO;
import br.com.app.fiocatalogo.domain.ProfessorDTO;

public class ProfessoresActivity extends AppCompatActivity {

    private ProfessoresDAO professoresDAO;
    private ProfessorAdapter adapter;
    private ListView rv_professores;
    private List<ProfessorDTO> listaProfessores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        professoresDAO = new ProfessoresDAO(this);
//        geraProfessores();

        listaProfessores = getProfessores();
        adapter = new ProfessorAdapter(this, listaProfessores);

        rv_professores = (ListView) findViewById(R.id.rv_professores);

        rv_professores.setAdapter(adapter);
    }

    private List<ProfessorDTO> getProfessores() {
        return professoresDAO.getListObjet();
    }

    private void geraProfessores() {
        ProfessorDTO professor = new ProfessorDTO();
        professor.setNome("Me. Adriano Aranão");

        professoresDAO.salvar(professor);

        ProfessorDTO professor2 = new ProfessorDTO();
        professor2.setNome("Dr. Claudinei Paulo de Lima");

        professoresDAO.salvar(professor2);

        ProfessorDTO professor3 = new ProfessorDTO();
        professor3.setNome("Drª Paula Ione C. Q. Fiochi");

        professoresDAO.salvar(professor3);

        ProfessorDTO professor4 = new ProfessorDTO();
        professor4.setNome("Mestre Sérgio Roberto Delfino");

        professoresDAO.salvar(professor4);
    }
}
