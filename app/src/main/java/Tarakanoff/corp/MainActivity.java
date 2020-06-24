package Tarakanoff.corp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String adminLogin = "admin";
    private final static String adminPassword = "admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.bt_login);

        final EditText et_login = findViewById(R.id.et_login);
        final EditText et_password = findViewById(R.id.et_password);

        final Intent main_activity = new Intent(this, MainActivity2.class);


        btn.setOnClickListener(v -> {
            String login = et_login.getText().toString();
            String password = et_password.getText().toString();

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