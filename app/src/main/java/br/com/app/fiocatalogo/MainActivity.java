package br.com.app.fiocatalogo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.app.fiocatalogo.adapter.CursoAdapter;
import br.com.app.fiocatalogo.dao.CursoDAO;
import br.com.app.fiocatalogo.dao.ProfessoresDAO;
import br.com.app.fiocatalogo.domain.CursoDTO;
import br.com.app.fiocatalogo.domain.ProfessorDTO;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private GridView gridCursos;
    private List<CursoDTO> listaCursos;
    private CursoAdapter adapter;
    private CursoDAO cursoDAO;
    private ProfessoresDAO professoresDAO;
    private CardView cv_facul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cursoDAO = new CursoDAO(this);
        professoresDAO = new ProfessoresDAO(this);

//        geraProfessores();
//        geraCursos();

        listaCursos = populaCursos();
        adapter = new CursoAdapter(this, listaCursos);
        gridCursos = (GridView) findViewById(R.id.gridCursos);
        gridCursos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CursoDTO curso = listaCursos.get(position);
                Intent i = new Intent(MainActivity.this, CursoDetalhesActivity.class);
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


    private void geraProfessores() {
        ProfessorDTO professor = new ProfessorDTO();
        professor.setNome("Me. Adriano Aranão");
        professor.setEmail("adriano@fio.com.br");

        professoresDAO.salvar(professor);

        ProfessorDTO professor2 = new ProfessorDTO();
        professor2.setNome("Dr. Claudinei Paulo de Lima");
        professor2.setEmail("claudinei@fio.com.br");

        professoresDAO.salvar(professor2);

        ProfessorDTO professor3 = new ProfessorDTO();
        professor3.setNome("Drª Paula Ione C. Q. Fiochi");
        professor3.setEmail("paula@fio.com.br");

        professoresDAO.salvar(professor3);

        ProfessorDTO professor4 = new ProfessorDTO();
        professor4.setNome("Mestre Sérgio Roberto Delfino");
        professor4.setEmail("sergio@fio.com.br");

        professoresDAO.salvar(professor4);
    }
    private void geraCursos() {
        ProfessoresDAO professoresDAO = new ProfessoresDAO(this);

        CursoDTO curso = new CursoDTO();
        curso.setTitulo("Direito");
        curso.setSubTitulo("Direito nas Fio");
        curso.setTempo("5 anos ou 10 semestres");
        curso.setCoordenador(professoresDAO.getObject(1));
        curso.setDescricao("O curso oferece uma formação que capacita o profissional para a solução de problemas do mundo real, por meio da construção de modelos computacionais, da utilização da Tecnologia da Informação e de sua efetiva implementação para dar suporte à tomada de decisões nas organizações.");
        curso.setPalavraCoordenador("O Curso de Sistemas de Informação é uma junção de administração com computação. O profissional não precisa necessariamente trabalhar com a parte técnica, pode trabalhar liderando equipes'");
        curso.setValor(951.45);
        curso.setFoto("thumbnail_direito.png");

        cursoDAO.salvar(curso);

        CursoDTO curso2 = new CursoDTO();
        curso2.setTitulo("Agronomia");
        curso2.setSubTitulo("Agronomia nas Fio");
        curso2.setTempo("4 anos ou 8 semestres");
        curso2.setCoordenador(professoresDAO.getObject(2));
        curso2.setDescricao("O curso oferece uma formação que capacita o profissional para a solução de problemas do mundo real, por meio da construção de modelos computacionais, da utilização da Tecnologia da Informação e de sua efetiva implementação para dar suporte à tomada de decisões nas organizações.");
        curso2.setPalavraCoordenador("O Curso de Sistemas de Informação é uma junção de administração com computação. O profissional não precisa necessariamente trabalhar com a parte técnica, pode trabalhar liderando equipes'");
        curso2.setValor(1130.70);
        curso2.setFoto("thumbnail_agronomia.png");

        cursoDAO.salvar(curso2);

        CursoDTO curso3 = new CursoDTO();
        curso3.setTitulo("Psicologia");
        curso3.setSubTitulo("Psicologia nas Fio");
        curso3.setTempo("4 anos ou 8 semestres");
        curso3.setCoordenador(professoresDAO.getObject(3));
        curso3.setDescricao("O curso oferece uma formação que capacita o profissional para a solução de problemas do mundo real, por meio da construção de modelos computacionais, da utilização da Tecnologia da Informação e de sua efetiva implementação para dar suporte à tomada de decisões nas organizações.");
        curso3.setPalavraCoordenador("O Curso de Sistemas de Informação é uma junção de administração com computação. O profissional não precisa necessariamente trabalhar com a parte técnica, pode trabalhar liderando equipes'");
        curso3.setValor(1041.60);
        curso3.setFoto("thumbnail_psicologia.png");

        cursoDAO.salvar(curso3);

        CursoDTO curso4 = new CursoDTO();
        curso4.setTitulo("Sistema de Informação");
        curso4.setSubTitulo("Sistema de Informação nas Fio");
        curso4.setTempo("4 anos ou 8 semestres");
        curso4.setCoordenador(professoresDAO.getObject(4));
        curso4.setDescricao("O curso oferece uma formação que capacita o profissional para a solução de problemas do mundo real, por meio da construção de modelos computacionais, da utilização da Tecnologia da Informação e de sua efetiva implementação para dar suporte à tomada de decisões nas organizações.");
        curso4.setPalavraCoordenador("O Curso de Sistemas de Informação é uma junção de administração com computação. O profissional não precisa necessariamente trabalhar com a parte técnica, pode trabalhar liderando equipes'");
        curso4.setValor(623.90);
        curso4.setFoto("thumbnail_bsi.png");

        cursoDAO.salvar(curso4);
    }

    private List<CursoDTO> populaCursos() {
        return new CursoDAO(this).getListObjet();
    }

    @Override
    protected void onStart() {
        cv_facul = (CardView) findViewById(R.id.cv_facul);
        cv_facul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, FaculdadeActivity.class);
                startActivity(i);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setLogo(R.drawable.logo_fio);
        }
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        super.onStart();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_facul) {
            // Handle the camera action
            Intent i = new Intent(MainActivity.this, FaculdadeActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_cursos) {
            Intent i = new Intent(MainActivity.this, CursosActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_professores) {
            Intent i = new Intent(MainActivity.this, ProfessoresActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
