package br.com.fiap.petshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    CheckBox chkFemea;
    CheckBox chkVacinas;
    CheckBox chkAdestrado;
    RadioGroup rdgCaes;
    TextView txtRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkAdestrado = findViewById(R.id.chkAdestrado);
        chkFemea = findViewById(R.id.chkFemea);
        chkVacinas = findViewById(R.id.chkVacinas);
        rdgCaes = findViewById(R.id.rdgCaes);
        txtRes = findViewById(R.id.txtRes);
    }

    public void calcular(View view) {
        double res = 0;
        int selecionado = rdgCaes.getCheckedRadioButtonId();
        switch (selecionado){
            case R.id.rdbBorder:
                res = 800;
                break;
            case R.id.rdbPastor:
                res = 700;
                break;
            case R.id.rdbPastorCan:
                res = 800;
                break;
            case R.id.rdbPit:
                res = 750;
                break;
        }
        if (chkVacinas.isChecked()){
            res += 200;
        }
        if (chkFemea.isChecked()){
            res += 180;
        }
        if (chkAdestrado.isChecked()){
            res += 400;
        }

        DecimalFormat form = new DecimalFormat("0.00");
        txtRes.setText("R$ " + String.valueOf(form.format(res)));
    }
}
