package com.example.spinnerpam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner data;
    TextView spininblaini;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spininblaini = findViewById(R.id.texxxto);

        data = findViewById(R.id.data);

        //Array list

        final List<String> states = new ArrayList<String>();
        final List<String> capitals = new ArrayList<String>();
        final List<String> sigles = new ArrayList<String>();
        final List<String> pib = new ArrayList<String>();
        final List<String> idh = new ArrayList<String>();
        final List<String> populations = new ArrayList<String>();

        TextView stateTxt = (TextView) findViewById(R.id.stateTxt);
        TextView capitalTxt = (TextView) findViewById(R.id.capitalTxt);
        TextView sigleTxt = (TextView) findViewById(R.id.sigleTxt);
        TextView pibTxt = (TextView) findViewById(R.id.pibTxt);
        TextView idhTxt = (TextView) findViewById(R.id.idhTxt);
        TextView popTxt = (TextView) findViewById(R.id.popTxt);

        String[] states_array = {
                "Selecione...", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia",
                "Ceará", "Distrito Federal", "Espírito Santo",
                "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul",
                "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco",
                "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia",
                "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"
        };

        String[] capitals_array = {
                "Capital", "Rio Branco", "Maceió", "Macapá", "Manauas", "Salvador",
                "Fortaleza", "Brasília", "Vitória",
                "Goiânia", "São Luís", "Cuiabá", "Campo Grande",
                "Belo Horizonte", "Belém", "João Pessoa", "Curitiba", "Recife",
                "Teresina", "Rio de Janeiro", "Porto Alegre", "Porto Alegre",  "Porto Velho",
                "Boa Vista", "Florianópolis", "São Paulo", "Aracaju", "Palmas"
        };

        String[] sigles_array = {
                "sigla", "AC", "AL", "AP", "AM", "BA",
                "CE", "DF", "ES",
                "GO", "MA", "MT", "MS",
                "MG", "PA", "PB", "PR", "PE",
                "PI", "RJ", "RN", "RS", "RO",
                "RR", "SC", "SP", "SE", "TO"
        };

        String[] pib_array = {
                "PIB", "8.7 trilhões", "28 trilhões", "8.9 trilhões", "64 trilhões", "159 trilhões",
                "87 trilhões", "164 trilhões", "97 trilhões",
                "111 trilhões", "52 trilhões", "71 trilhões", "49 trilhões",
                "386 trilhões", "88 trilhões", "35 trilhões", "239 trilhões", "104 trilhões",
                "24 trilhões", "462 trilhões", "36 trilhões", "263 trilhões", "27 trilhões",
                "6.9 trilhões", "169 trilhões", "1.349 trilhões", "26 trilhões", "18 trilhões"
        };

        String[] idh_array = {
                "IDH", "0,751", "0,677", "0,780", "0,780", "0,742",
                "0,723", "0,874", "0,802",
                "0,800", "0,683", "0,796", "0,802",
                "0,800", "0,755", "0,718", "0,820", "0,718",
                "0,703", "0,832", "0,738", "0,832", "0,752",
                "0,750", "0,840", "0,833", "0,742", "0,756"
        };

        String[] population_array = {
                "População", "803 513", "3 340 932", "766 679", "3 38 336", "15 203 934",
                "8 904 349", "2 914 830", "3 929 911",
                "6 610 681", "6 904 231", "3 270 973", "2 651 235",
                "20 869 101", "8 175 113", "3 972 202", "11 163 018", "9 345 173",
                "3 204 028", "16 550 024", "3 442 175", "1 768 204",
                "505 665", "6 819 202", "6 819 190", "44 396 484",  "2 242 937", "1 515 126"
        };

        Collections.addAll(states, states_array);
        Collections.addAll(capitals, capitals_array);
        Collections.addAll(sigles, sigles_array);
        Collections.addAll(pib, pib_array);
        Collections.addAll(idh, idh_array);
        Collections.addAll(populations, population_array);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, states);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        data.setAdapter(adapter);

        data.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                // Get the string formatted
                String stateTemp = "Estado: " + states.get(position);
                String capitalTemp = "Capital: " + capitals.get(position);
                String sigleTemp = "Sigla: " + sigles.get(position);
                String pibTemp = "PIB: " + pib.get(position);
                String idhTemp = "IDH: " + idh.get(position);
                String popTemp = "População: " + populations.get(position);

                // Setting the text accordingly to array index
                stateTxt.setText(stateTemp);
                capitalTxt.setText(capitalTemp);
                sigleTxt.setText(sigleTemp);
                pibTxt.setText(pibTemp);
                idhTxt.setText(idhTemp);
                popTxt.setText(popTemp);

                // Setting image on imageView
                String uri = "@drawable/" + sigles.get(position).toLowerCase();
                int imageResource = getResources().getIdentifier(uri, null, getPackageName());
                ImageView imageView= (ImageView)findViewById(R.id.img);
                @SuppressLint("UseCompatLoadingForDrawables") Drawable res = getResources().getDrawable(imageResource);
                imageView.setImageDrawable(res);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}