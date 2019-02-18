package com.example.yesiaplorina.projectinput;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1
    EditText edSisi, edHasil;
    Button btnHitung;
    Spinner pilihan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // ini juga inisialisasi loh
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //2

        edSisi       = findViewById(R.id.ed_hitung);
        edHasil      = findViewById(R.id.ed_hasil);
        btnHitung    = findViewById(R.id.btn_hitung);
        pilihan      = findViewById(R.id.spinner);

        //3
        final String[] dataPilihan = {"Luas Permukaan","Keliling","Volume"};

        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, dataPilihan);

        pilihan.setAdapter(adapter);

        //ketika tombol hitung dipencet

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (pilihan.getSelectedItem().equals(dataPilihan[0])){
                   Double sisi = Double.valueOf(edSisi.getText().toString());
                   Double luas = sisi*sisi;

                   edHasil.setText(luas.toString()+" Meter");
               }
               else if (pilihan.getSelectedItem().equals(dataPilihan[1])){
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    Double luas = (sisi*sisi)*6;

                    edHasil.setText(luas.toString()+" Meter");
                }
                else if(pilihan.getSelectedItem().equals(dataPilihan[2])){
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    Double luas = sisi*sisi*sisi;

                    edHasil.setText(luas.toString()+ " Meter");
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Toast.makeText(this, "Tes", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_call) {
            Toast.makeText(this, "Tes", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.action_call2) {
            Intent telpon = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:085740482440"));
            startActivity(telpon);
            Toast.makeText(this, "Tes", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
