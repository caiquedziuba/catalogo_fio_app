package br.com.app.fiocatalogo.util;

import android.content.ContentValues;
import android.util.Log;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDatabaseHelper extends SQLiteOpenHelper {
    public static final String TAG = "SQLITE";

    public static final String DATABASE_NAME = "db_catalogo";
    public static final int DATABASE_VERSION = 45;

    public static final String DATASE_TABLE_FACUL = "faculdade";
    public static final String DATASE_TABLE_CURSO = "curso";
    public static final String DATASE_TABLE_MATERIA = "materia";
    public static final String DATASE_TABLE_CURSOS_MATERIAS = "cursos_materias";
    public static final String DATASE_TABLE_PROFESSOR = "professor";

    public SqliteDatabaseHelper(Context c) {
        super(c, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder table_facul = new StringBuilder();
        table_facul.append("create table if not exists " + DATASE_TABLE_FACUL);
        table_facul.append("(_id integer not null primary key autoincrement,");
        table_facul.append("nome text not null,");
        table_facul.append("latitude text not null,");
        table_facul.append("longitude text not null,");
        table_facul.append("cep text not null,");
        table_facul.append("cnpj text not null,");
        table_facul.append("cidade text not null,");
        table_facul.append("telefone text not null);");

        StringBuilder table_curso = new StringBuilder();
        table_curso.append("create table if not exists " + DATASE_TABLE_CURSO);
        table_curso.append("(_id integer not null primary key autoincrement,");
        table_curso.append("titulo text not null,");
        table_curso.append("sub_titulo text not null,");
        table_curso.append("descricao varchar(255) not null,");
        table_curso.append("tempo text not null,");
        table_curso.append("id_coordenador integer not null,");
        table_curso.append("palavra varchar(155) not null,");
        table_curso.append("valor real not null,");
        table_curso.append("foto real not null);");

        StringBuilder table_materia = new StringBuilder();
        table_materia.append("create table if not exists " + DATASE_TABLE_MATERIA);
        table_materia.append("(_id integer not null primary key autoincrement,");
        table_materia.append("nome text not null);");

        StringBuilder table_curso_materias = new StringBuilder();
        table_curso_materias.append("create table if not exists " + DATASE_TABLE_CURSOS_MATERIAS);
        table_curso_materias.append("(_id integer not null primary key autoincrement,");
        table_curso_materias.append("id_curso integer not null,");
        table_curso_materias.append("id_materia integer not null,");
        table_curso_materias.append("qnt_horas integer not null);");

        StringBuilder table_professor = new StringBuilder();
        table_professor.append("create table if not exists " + DATASE_TABLE_PROFESSOR);
        table_professor.append("(_id integer not null primary key autoincrement,");
        table_professor.append("nome text not null);");

        try {
            db.execSQL(table_facul.toString());
            db.execSQL(table_curso.toString());
            db.execSQL(table_curso_materias.toString());
            db.execSQL(table_materia.toString());
            db.execSQL(table_professor.toString());
//
            StringBuilder sb = new StringBuilder();
            sb.append("insert into " + DATASE_TABLE_FACUL);
            sb.append("(nome, cep, cnpj, cidade, telefone)");
            sb.append("values");
            sb.append("('Faculdade Integradas de Ourinhos',");
            sb.append("'18950',");
            sb.append("'12831236594',");
            sb.append("'Ourinhos',");
            sb.append("'0800 770 8788');");

            Log.v(TAG, "Database create with success");
        } catch(Exception e){
            Log.v(TAG, "Error on create database: " + e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL("DROP TABLE IF EXISTS " + DATASE_TABLE_FACUL);
            db.execSQL("DROP TABLE IF EXISTS " + DATASE_TABLE_CURSO);
            db.execSQL("DROP TABLE IF EXISTS " + DATASE_TABLE_CURSOS_MATERIAS);
            db.execSQL("DROP TABLE IF EXISTS " + DATASE_TABLE_MATERIA);
            db.execSQL("DROP TABLE IF EXISTS " + DATASE_TABLE_PROFESSOR);
            onCreate(db);
        }catch(Exception e){
            Log.v(TAG, "Error on upgrade database: " + e.getMessage());
        }
    }
}

