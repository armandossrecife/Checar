package br.ufpi.es.checar.Visao;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.File;

import br.ufpi.es.checar.Controle.FachadaControle;
import br.ufpi.es.checar.R;

public class TelaNovaPlaca extends AppCompatActivity {


    private static final String TAG = "Checar.java";
    FachadaControle fachadaControle;


    private final int CAMERA_CAPTURE = 1; //Fotografia
    private final int CROP_PIC = 2; //Recorte


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        fachadaControle = new FachadaControle();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_nova_placa);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //Log.i(TAG, "resultCode: " + resultCode);

        if (resultCode == Activity.RESULT_OK) {
            if(requestCode == CAMERA_CAPTURE){
                //startActivityForResult(fachadaControle.configurarIntentRecorte(this), 2);
                //Intent intent = new Intent(this, TelaAlterarDadosCNH.class);
                String codigo = "b";
                Intent intent = new Intent(TelaNovaPlaca.this, TelaRecorteImagem.class);
                intent.putExtra("codigo", codigo);
                startActivity(intent);
            }
            else{
                if(requestCode == CROP_PIC){

                    //get the returned data
                    Bundle extras = data.getExtras();
                    //get the cropped bitmap
                    Bitmap thePic = extras.getParcelable("data");



                    Intent intent = new Intent(this, TelaAlterarDadosPlaca.class);
                    startActivity(intent);
                }
            }

        } else {
            Log.v(TAG, "Cancelado Pelo Usuário");
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView =
//                (SearchView) MenuItemCompat.getActionView(searchItem);

        // Configure the search info and add any event listeners...



        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case R.id.action_settings:
//                // User chose the "Settings" item, show the app settings UI...
//                return true;

            case R.id.action_favorite:
                Toast.makeText(TelaNovaPlaca.this, "Sou um Button sem Configuracao :(", Toast.LENGTH_SHORT).show();
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }


    public void cameraPlaca(View view){
        //Toast.makeText(TelaNovoCNH.this, "Sou um Button sem Configuracao :(", Toast.LENGTH_SHORT).show();

        File file = new File(fachadaControle.getDiretorioImagem());
        Uri outputFileUri = Uri.fromFile(file);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

        startActivityForResult(intent, 1);
    }




}