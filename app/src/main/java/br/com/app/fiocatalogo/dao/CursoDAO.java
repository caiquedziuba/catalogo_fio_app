package br.com.app.fiocatalogo.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.app.fiocatalogo.domain.CursoDTO;
import br.com.app.fiocatalogo.domain.ProfessorDTO;
import br.com.app.fiocatalogo.util.SqliteDatabaseHelper;

public class CursoDAO {
    private Context context;
    private SQLiteDatabase database;
    private ProfessoresDAO professoresDAO;
    String[] columns = CursoDTO.columns;

    public CursoDAO(Context context) {
        this.context = context;
        this.professoresDAO = new ProfessoresDAO(context);
        this.database = new SqliteDatabaseHelper(context).getWritableDatabase();
    }

    public long salvar(CursoDTO obj) {
        ContentValues values = new ContentValues();
        values.put(columns[1], obj.getTitulo());
        values.put(columns[2], obj.getSubTitulo());
        values.put(columns[3], obj.getTempo());
        values.put(columns[4], obj.getDescricao());
        values.put(columns[5], obj.getCoordenador().get_id());
        values.put(columns[6], obj.getPalavraCoordenador());
        values.put(columns[7], obj.getValor());
        values.put(columns[8], obj.getFoto());

        try {
            long id = database.insert(SqliteDatabaseHelper.DATASE_TABLE_CURSO, null, values);
            Log.v("SQLITE", "Registro salvo com sucesso!");
            return id;
        }catch (Exception e){
            Log.v("SQLITE", "Erro ao tentar salvar o registro!");
        }

        return 0;
    }

    public void update(CursoDTO obj) {
        ContentValues values = new ContentValues();
        values.put(columns[1], obj.getTitulo());
        values.put(columns[2], obj.getSubTitulo());
        values.put(columns[3], obj.getTempo());
        values.put(columns[4], obj.getDescricao());
        values.put(columns[5], obj.getCoordenador().get_id());
        values.put(columns[6], obj.getPalavraCoordenador());
        values.put(columns[7], obj.getValor());
        values.put(columns[8], obj.getFoto());

        try {
            database.update(SqliteDatabaseHelper.DATASE_TABLE_CURSO, values, "id=?", new String[]{String.valueOf(obj.get_id())});
            Log.v("SQLITE", "Registro alterado com sucesso!");
        }catch (Exception e){
            Log.v("SQLITE", "Erro ao tentar alterar o registro!");
        }
    }

    public void deletar(long id) {
        try {
            database.delete(SqliteDatabaseHelper.DATASE_TABLE_CURSO, "_id = ?", new String[]{String.valueOf(id)});
            Log.v("SQLITE", "Registro deletado com sucesso!");
        }catch (Exception e){
            Log.v("SQLITE", "Erro ao  deletar registro com sucesso!");
        }
    }

    public CursoDTO getObject(long id) {
        CursoDTO curso = new CursoDTO();
        Cursor cursor = null;

        try{
            cursor = database.query(SqliteDatabaseHelper.DATASE_TABLE_CURSO, columns, "_id = ?",  new String[]{String.valueOf(id)}, null, null, null);

            if(cursor.moveToFirst()){
                curso.set_id(cursor.getInt(cursor.getColumnIndex(columns[0])));
                curso.setTempo(cursor.getString(cursor.getColumnIndex(columns[1])));
                curso.setSubTitulo(cursor.getString(cursor.getColumnIndex(columns[2])));
                curso.setTempo(cursor.getString(cursor.getColumnIndex(columns[3])));
                curso.setDescricao(cursor.getString(cursor.getColumnIndex(columns[4])));
                // get Professor pelo id
                long idProfessores = cursor.getLong(cursor.getColumnIndex(columns[5]));
                ProfessorDTO professor = professoresDAO.getObject(idProfessores);

                curso.setCoordenador(professor);

                curso.setPalavraCoordenador(cursor.getString(cursor.getColumnIndex(columns[6])));
                curso.setValor(cursor.getDouble(cursor.getColumnIndex(columns[7])));
                curso.setFoto(cursor.getString(cursor.getColumnIndex(columns[8])));
            }
        } catch (Exception e){
            Log.v("SQLITE", "Erro ao buscar todos os registros");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return curso;
    }

    public List<CursoDTO> getListObjet() {
        List<CursoDTO> listaCursos= new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = database.query(SqliteDatabaseHelper.DATASE_TABLE_CURSO, columns, null, null, null, null, null);

            while(cursor.moveToNext()){
                CursoDTO curso = new CursoDTO();

                curso.set_id(cursor.getInt(cursor.getColumnIndex(columns[0])));
                curso.setTitulo(cursor.getString(cursor.getColumnIndex(columns[1])));
                curso.setSubTitulo(cursor.getString(cursor.getColumnIndex(columns[2])));
                curso.setTempo(cursor.getString(cursor.getColumnIndex(columns[3])));
                curso.setDescricao(cursor.getString(cursor.getColumnIndex(columns[4])));

                // get Professor pelo id
                long idProfessores = cursor.getLong(cursor.getColumnIndex(columns[5]));
                ProfessorDTO professor = professoresDAO.getObject(idProfessores);

                curso.setCoordenador(professor);

                curso.setPalavraCoordenador(cursor.getString(cursor.getColumnIndex(columns[6])));
                curso.setValor(cursor.getDouble(cursor.getColumnIndex(columns[7])));
                curso.setFoto(cursor.getString(cursor.getColumnIndex(columns[8])));

                listaCursos.add(curso);
            }
        } catch (Exception e){
            Log.v("SQLITE", "Erro ao buscar todos os registros");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return listaCursos;
    }

    public String getCursoForCoordenador(long idCoordenador) {
        String nomeCurso = "";
        Cursor cursor = null;
        try{
            cursor = database.query(SqliteDatabaseHelper.DATASE_TABLE_CURSO, columns, columns[5].concat(" = ?"), new String[]{String.valueOf(idCoordenador)}, null, null, null, "1");

            if(cursor.moveToFirst()){
                nomeCurso = cursor.getString(cursor.getColumnIndex(columns[1]));
            }

        } catch (Exception e){
            Log.v("SQLITE", "Erro ao buscar todos os registros" + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return nomeCurso;
    }
}
