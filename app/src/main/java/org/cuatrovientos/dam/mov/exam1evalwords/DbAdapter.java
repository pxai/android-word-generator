package org.cuatrovientos.dam.mov.exam1evalwords;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * DBAdapter
 * Esta es una clase intermediaria entre nuestro Activity y
 * la BBDD. Aquí meteremos todas las operaciones CRUD sobre
 * los datos
 * @author Pello Altadill
 *
 */
public class DbAdapter {

    // Este objeto nos permite meterle mano a SQLite
    private SQLiteDatabase db;

    // Aquí tenemos nuestro SqliteHelper
    // que se encarga de crear y actualizar
    private SqLiteHelper dbHelper;

    // El contexto nos servirá para referirnos a la Activity
    // en la que estamos
    private final Context contexto;


    /**
     * DbAdapter
     * Constructor de la clase
     * @param contexto Será la activity que usa esta clase
     */
    public DbAdapter(Context contexto) {
        this.contexto = contexto;
    }


    /**
     * open
     * Usa el SqLiteHelper para encargase de abrir la conexión.
     * El SqLiteHelper lo primero que hará es crear la BD si no existía.
     * @return Devuelve un objeto de clase SQLiteDatabase para gestionar la BD
     * @throws SQLException
     */
    public SQLiteDatabase open() throws SQLException {
        // Crea un objeto asistente de base de datos de clase SqLiteHelper.
        dbHelper = new SqLiteHelper(contexto);

        // Abre la base de datos en modo escritura (lectura permitida).
        db = dbHelper.getWritableDatabase();

        Log.d("DEBUG","BD obtenida: " + db.toString());

        // Devuelve el objeto de tipo SQLiteDatabase.
        return db;
    }

    /**
     * close
     * Cierra la base de datos mediante el dbHelper
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * insert
     * Inserts a name
     *
     * @param String name
     * @return returns inserted record id
     */
    public long insert (String name) {
        // Creamos un registro
        ContentValues registro = new ContentValues();

        // Agrega los datos.
        registro.put("name", name);

        // Inserta el registro y devuelve el resultado.
        return db.insert("names", null, registro);
    }


    /**
     * getNames
     * Obtiene todos los registros de la tabla todo.
     *
     * @return Cursor with all names
     */
    public Cursor getNames() {
        return db.query("names", new String[] {"_id","name"}, null, null, null, null, null);
    }




}