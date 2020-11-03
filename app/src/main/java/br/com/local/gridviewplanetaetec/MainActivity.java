package br.com.local.gridviewplanetaetec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Declarar o gridview
    GridView gridView;

    String[] namePlanets = {"O Ladrão de Raios", "O Mar de Monstros", "A Maldição do Titã", "A Batalha do Labirinto",
            "O Último Olimpiano", "O Herói Perdido", "O Filho de Netuno", "A Marca de Atena",
            "A Casa de Hades", "O Sangue do Olimpo", "O Oráculo Oculto", "A Profecia das Sombras",
            "O Labirinto de Fogo", "A Tumba do Tirano", "A Espada do Verão", "O Martelo de Thor", "O Navio dos Mortos"
            ,"A Pirâmide Vermelha", "O Trono de Fogo", "A Sombra da Serpente"};
    int[] imagePlanets = {R.drawable.ladraio, R.drawable.marmon, R.drawable.maltita,
            R.drawable.batlab, R.drawable.ultolim, R.drawable.herperd,
            R.drawable.filnet, R.drawable.marcaten, R.drawable.cashad, R.drawable.sanoli
            , R.drawable.oracocul, R.drawable.profsomb, R.drawable.labfogo, R.drawable.tumbtir, R.drawable.espver,
            R.drawable.martthor, R.drawable.navmort, R.drawable.pirverm, R.drawable.tronfogo, R.drawable.sombserp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        //instanciar o meu adapter
        CustomAdapter customAdaper = new CustomAdapter();
        //gridview receber por parâmetro o adapter
        gridView.setAdapter(customAdaper);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), RecebePlaneta_Activity.class);

                intent.putExtra("name", namePlanets[position]);
                intent.putExtra("image", imagePlanets[position]);

                startActivity(intent);
            }
        });
    }

    public class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagePlanets.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view1 = getLayoutInflater().inflate(R.layout.modelo_layout, null);

            TextView name = view1.findViewById(R.id.txtPlanetas);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(namePlanets[position]);
            image.setImageResource(imagePlanets[position]);

            return view1;
        }
    }
}