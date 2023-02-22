package edu.iest.relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bnCambiar = findViewById(R.id.bnCambiar);
        EditText etCanal = findViewById(R.id.etCanal);
        TextView tvCanal = findViewById(R.id.tvCanal);

        Spinner spProgramas = findViewById(R.id.spPrograma);
        ivContinuara = findViewById(R.id.ivContinuara);

        spProgramas.setOnItemSelectedListener(this);

        bnCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Aqui la logica que hacer al dar click
                //Obtendremos el valor del edittext y lo asignaremos al textview inferior
                String texto = etCanal.getText().toString();
                Toast.makeText(MainActivity.this, "El valor era "+ texto, Toast.LENGTH_SHORT).show();
                tvCanal.setText(texto);
            }
        });

        ivContinuara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spProgramas = findViewById(R.id.spPrograma);
                EditText etCanal = findViewById(R.id.etCanal);
                Intent i = new Intent(MainActivity.this, DatosActivity.class);
                i.putExtra("canal", etCanal.getText().toString());
                i.putExtra("programa", spProgramas.getSelectedItem().toString());
                startActivity(i);
            }
        });
    }

    private ImageView ivContinuara;

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long idFila) {
        String programa = adapterView.getItemAtPosition(position).toString();
        Snackbar.make(adapterView, "Programa selecccionado " + programa, Snackbar.LENGTH_LONG).show();

        if(position == 0){
            ivContinuara.setImageResource(R.drawable.to_be_continued);
        }else if(position == 1){
            ivContinuara.setImageResource(R.drawable.to_be_continued_dos);
        }else if(position == 2){
            ivContinuara.setImageResource(R.drawable.to_be_continued_tres);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}