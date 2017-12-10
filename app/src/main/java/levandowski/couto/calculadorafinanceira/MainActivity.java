package levandowski.couto.calculadorafinanceira;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    public EditText etvalor1;
    public EditText etvalor2;
    private Button btncalcular;
    private MediaPlayer mp;
    private TextView tvResposta;
    private Spinner selecionar;
    private ArrayAdapter<String> adapter;
    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Refs.
        etvalor1= findViewById(R.id.ma_et_valor1);
        etvalor2 = findViewById(R.id.ma_et_valor2);
        tvResposta = findViewById(R.id.ma_tv_resposta);
        btncalcular = findViewById(R.id.btn_calcular);
        selecionar = findViewById(R.id.sl_spinner);
        ArrayList<String> opcoes = new ArrayList<>();
        opcoes.add("Selecione");
        opcoes.add("Somar");
        opcoes.add("Subtrair");
        opcoes.add("Dividir");
        opcoes.add("Multiplicar");
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, opcoes);
        selecionar.setAdapter(adapter);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculo c = new Calculo();
                try{
                    play(v,R.raw.sn_calc);
                c.setValor1(Double.parseDouble(etvalor1.getText().toString()));
                c.setValor2(Double.parseDouble(etvalor2.getText().toString()));
            }
               catch(NumberFormatException e)
            {
                Vibrar();
                tvResposta.setText("Obrigatório preencher Valores");
            }
                    if (selecionar.getSelectedItemPosition() == 0) {
                        Vibrar();
                        String selecao = selecionar.getSelectedItem().toString();
                        Toast.makeText(
                                getBaseContext(), "Selecione alguma das Opções de Cálculo",
                                LENGTH_LONG).show();
                    } else if (selecionar.getSelectedItemPosition() == 1) {
                        tvResposta.setText("RESULTADO: " + c.somar());
                    } else if (selecionar.getSelectedItemPosition() == 2) {
                        tvResposta.setText("RESULTADO: " + c.subtrair());
                    } else if (selecionar.getSelectedItemPosition() == 3) {
                        tvResposta.setText("RESULTADO: " + c.dividir());
                    } else if (selecionar.getSelectedItemPosition() == 4) {
                        tvResposta.setText("RESULTADO: " + c.multiplicar());
                    }

                }
        });
    }
    public void LimparCampos(View view) {
        play(v,R.raw.sn_limp);
      etvalor1.setText(null);
      etvalor2.setText(null);
    }
    public void play(View v, int som){
        try{
            mp = MediaPlayer.create(MainActivity.this, som);
            mp.start();
        }catch(Exception e){
        }
    }
    private void Vibrar()
    {
        Vibrator rr = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        long milliseconds = 600;
        rr.vibrate(milliseconds);
    }
}
