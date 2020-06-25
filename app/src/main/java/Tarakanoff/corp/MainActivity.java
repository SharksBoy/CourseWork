package Tarakanoff.corp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    String name[] = {"Nikita", "Maria"};
    String sName[] = {"Tarakanov", "Ivanova"};
    String mName[] = {"Igorevich", "Ivanovna"};
    String kafedra[] = {"Inostraniy Yazik", "FizMat"};
    String email[] = {"gsdg@gmail.com", "Idgsdg@mail.ru"};
    int phone[] = {1234567891, 891055566};

    String name_std[] = {"NikitaS", "MariaS"};
    String sName_std[] = {"TarakanovS", "IvanovaS"};
    String mName_std[] = {"IgorevichS", "IvanovnaS"};
    String group_std[] = {"Isit", "PopS"};
    String email_std[] = {"dsgsd@mail.ru", "edsgs@gmail.com"};
    int phone_std[] = {888888888, 999999999};

    String login[] = {"admin", "Mimi"};
    String password[] = {"admin", "Mimi1"};

    DBHelper dbHelper;

    private final static String adminLogin = "admin";
    private final static String adminPassword = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.query("TEACHERS", null, null, null, null, null, null);

        if (c.getCount() == 0) {
            ContentValues cv = new ContentValues();
            for (int i = 0; i < 2; i++) {
                cv.put("name", name[i]);
                cv.put("sName_std", sName[i]);
                cv.put("mName_std", mName[i]);
                cv.put("kafedra", kafedra[i]);
                cv.put("email_std", email[i]);
                cv.put("phone_std", phone[i]);
            }
        }
        c.close();
        c = db.query("STUDENTS", null, null, null, null, null, null);
        if (c.getCount() == 0) {
            ContentValues cv = new ContentValues();
            for (int i = 0; i < 2; i++) {
                cv.put("name_std", name_std[i]);
                cv.put("sName", sName_std[i]);
                cv.put("mName", mName_std[i]);
                cv.put("group_std", group_std[i]);
                cv.put("email", email_std[i]);
                cv.put("phone", phone_std[i]);
            }
        }
        c.close();
        c = db.query("AUTHENTICATION", null, null, null, null, null, null);
        if (c.getCount() == 0) {
            ContentValues cv = new ContentValues();
            for (int i = 0; i < 2; i++) {
                cv.put("login", login[i]);
                cv.put("password", password[i]);
            }
        }
        dbHelper.close();


        Button btn = findViewById(R.id.bt_login);

        final EditText et_login = findViewById(R.id.et_login);
        final EditText et_password = findViewById(R.id.et_password);

        final Intent main_activity = new Intent(this, MainActivity2.class);


        btn.setOnClickListener(v -> {
            String login = et_login.getText().toString();
            String password = et_password.getText().toString();


//            switch (v.getId()) {
//                case R.id.btnReadTch:
//                    Cursor cursor = database.query(DBHelper.TABLE_TEACHERS, null, null, null, null, null, null, null);
//                    if (cursor.moveToFirst()) {
//                        int idIndex = cursor.getColumnIndex(DBHelper.KEY_ID);
//                        int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
//                        int fnameIndex = cursor.getColumnIndex(DBHelper.KEY_FNAME);
//                        int mnameIndex = cursor.getColumnIndex(DBHelper.KEY_MNAME);
//                        int kafedraIndex = cursor.getColumnIndex(DBHelper.KEY_KAFEDRA);
//                        int emailIndex = cursor.getColumnIndex(DBHelper.KEY_EMAIL);
//                        int phoneIndex = cursor.getColumnIndex(DBHelper.KEY_PHONE);
//                        do {
//                            Log.d("mLog", "ID = " + cursor.getInt(idIndex) +
//                                    ", name = " + cursor.getString(nameIndex) +
//                                    ", email = " + cursor.getString(emailIndex));
//                        } while (cursor.moveToNext());
//
//                    } else {
//                        Log.d("mLog", "0 rows");
//                    }
//                    cursor.close();
//                    break;
//
//                case R.id.btnReadStd:
//
//
//
//
//                    break;
//            }

            if (login.equals(adminLogin) && password.equals(adminPassword)) {
                Toast.makeText(this, "Welcome " + "name", Toast.LENGTH_LONG).show();
                startActivity(main_activity);
            } else {
                Toast.makeText(this, "False", Toast.LENGTH_LONG).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void openWebPage(String url) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.ab_TKSU:
                openWebPage("https://tksu.ru/");
                break;

            case R.id.ab_map:
                showMap(Uri.parse("geo:54.509661,36.274092?q=Kaluzhskiy+Gosudarstvennyy+Universitet"));
                break;

            case R.id.ab_moodle:
                openWebPage("https://moodle.tksu.ru/");
                break;

            case R.id.ab_outlook:
                openWebPage("https://outlook.office.com/");
                break;

        }
        return (true);
    }
}