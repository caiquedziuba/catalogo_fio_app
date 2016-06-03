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

public class ProfessoresDAO {
    private Context context;
    private SQLiteDatabase database;
    String[] columns = ProfessorDTO.columns;

    public ProfessoresDAO(Context context) {
        this.context = context;
        this.database = new SqliteDatabaseHelper(context).getWritableDatabase();
    }

    public long salvar(ProfessorDTO obj) {
        ContentValues values = new ContentValues();
        values.put(columns[1], obj.getNome());

        try {
            long id = database.insert(SqliteDatabaseHelper.DATASE_TABLE_PROFESSOR, null, values);
            Log.v("SQLITE", "Registro salvo com sucesso!");
            return id;
        }catch (Exception e){
            Log.v("SQLITE", "Erro ao tentar salvar o registro!");
        }

        return 0;
    }

    public void update(ProfessorDTO obj) {
        ContentValues values = new ContentValues();
        values.put(columns[1], obj.getNome());

        try {
            database.update(SqliteDatabaseHelper.DATASE_TABLE_PROFESSOR, values, "id=?", new String[]{String.valueOf(obj.get_id())});
            Log.v("SQLITE", "Registro alterado com sucesso!");
        }catch (Exception e){
            Log.v("SQLITE", "Erro ao tentar alterar o registro!");
        }
    }

    public void deletar(long id) {
        try {
            database.delete(SqliteDatabaseHelper.DATASE_TABLE_PROFESSOR, "_id = ?", new String[]{String.valueOf(id)});
            Log.v("SQLITE", "Registro deletado com sucesso!");
        }catch (Exception e){
            Log.v("SQLITE", "Erro ao  deletar registro com sucesso!");
        }
    }

    public ProfessorDTO getObject(long id) {
        ProfessorDTO professor = new ProfessorDTO();
        Cursor cursor = null;

        try{
            cursor = database.query(SqliteDatabaseHelper.DATASE_TABLE_PROFESSOR, columns, "_id = ?",  new String[]{String.valueOf(id)}, null, null, null);

            if(cursor.moveToFirst()){
                professor.set_id(cursor.getInt(cursor.getColumnIndex(columns[0])));
                professor.setNome(cursor.getString(cursor.getColumnIndex(columns[1])));
            }
        } catch (Exception e){
            Log.v("SQLITE", "Erro ao buscar todos os registros");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return professor;
    }

    public List<ProfessorDTO> getListObjet() {
        List<ProfessorDTO> listaProfessores= new ArrayList<>();
        Cursor cursor = null;
        try{
            cursor = database.query(SqliteDatabaseHelper.DATASE_TABLE_PROFESSOR, columns, null, null, null, null, null);

            while(cursor.moveToNext()){
                ProfessorDTO professor = new ProfessorDTO();

                professor.set_id(cursor.getInt(cursor.getColumnIndex(columns[0])));
                professor.setNome(cursor.getString(cursor.getColumnIndex(columns[1])));

                listaProfessores.add(professor);
            }
        } catch (Exception e){
            Log.v("SQLITE", "Erro ao buscar todos os registros");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return listaProfessores;
    }
}
