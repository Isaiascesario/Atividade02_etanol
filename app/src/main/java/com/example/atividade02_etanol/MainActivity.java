package com.example.atividade02_etanol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private TextView recomendationTextView;
    private TextView valorGasolinaTextView;
    private TextView valorEtanolTextView;
    private SeekBar gasolinaSeekBar;
    private SeekBar etanouSeekBar;
    private ImageView combustivelImagem;


    private double gasolinaProgress = 50;
    private double etanolProgress = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaSeekBar = findViewById(R.id.gasosaSeekBar);
        etanouSeekBar = findViewById(R.id.etanouSeekBar);
        recomendationTextView = findViewById(R.id.respTextView);
        combustivelImagem = findViewById(R.id.imageView);
        valorGasolinaTextView = findViewById(R.id.valorGasolinaTextView);
        valorEtanolTextView = findViewById(R.id.valorEtanolTextView);

        gasolinaSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                gasolinaProgress = progress / 10.0;
                valorGasolinaTextView.setText(currencyFormat.format(gasolinaProgress));
                trocarImagem();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valorGasolinaTextView.setText(currencyFormat.format(gasolinaProgress));

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valorGasolinaTextView.setText(currencyFormat.format(gasolinaProgress));

            }
        });

        etanouSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                etanolProgress = progress / 10.0;
                valorEtanolTextView.setText(currencyFormat.format(etanolProgress));
                trocarImagem();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                valorEtanolTextView.setText(currencyFormat.format(etanolProgress));

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valorEtanolTextView.setText(currencyFormat.format(etanolProgress));
            }
        });

    }
    private void trocarImagem(){
        if(etanolProgress / gasolinaProgress  >= 0.7){
            combustivelImagem.setImageResource(R.drawable.gasolina);
            recomendationTextView.setText(R.string.recomendationTextGasolina);
        }
        else{
            combustivelImagem.setImageResource(R.drawable.cana);
            recomendationTextView.setText(R.string.recomendationTextEtanol);
        }
    }
}
