package com.myapplication.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            //create a database
            SQLiteDatabase dataBase = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //create the table
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS pessoas ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            //Insert data
           dataBase.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mariana', 18) ");
            dataBase.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Pedro', 37) ");
            dataBase.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Layon', 28) ");
            dataBase.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Marina', 27)");
            dataBase.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Joao', 50) ");

            //Update data
            //dataBase.execSQL("UPDATE pessoas SET idade = 15 WHERE id = 2");

            //Delete tupla
            //dataBase.execSQL("DELETE FROM pessoas WHERE id = 1");

            //Delete all tuplas
            //dataBase.execSQL("DELETE FROM pessoas");

            //Delete table
            //dataBase.execSQL("DROP TABLE pessoas");

            //recover date
            /*String consulta =
                    "SELECT nome, idade " +
                    "FROM pessoas WHERE nome = 'Layon' AND idade = 28";*/

            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas WHERE idade > 28 OR idade = 18";*/

            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas WHERE idade IN(18,35)";*/

            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas WHERE nome IN('Maria','Layon')";*/

            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas WHERE idade BETWEEN 30 AND 55";*/

            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas WHERE nome LIKE '%edro%'";*/

            /*String consulta =
                    "SELECT nome, idade " +
                            "FROM pessoas WHERE 1=1 ORDER BY idade ASC LIMIT 3"; //ASC or DESC*/

            String consulta =
                    "SELECT * FROM pessoas";

            Cursor cursor = dataBase.rawQuery(consulta, null);

            //table indexes
            int indexId = cursor.getColumnIndex("id");
            int indexName = cursor.getColumnIndex("nome");
            int indexOld = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null) {

                String id = cursor.getString(indexId);
                String nome = cursor.getString(indexName);
                String idade = cursor.getString(indexOld);

                Log.i("RESULTADO", "id: " + id + " nome: " + nome + " idade: " + idade);
                cursor.moveToNext();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}