package id.sch.smktelkom_mlg.learn.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    RadioGroup rgJK;
    RadioButton rbLK, rbPM;
    CheckBox cbRPL, cbTKJ, cbMM;
    Spinner spProvinsi;
    TextView tvHasil, tvJurusan;
    int nJurusan;

    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvJurusan = (TextView) findViewById(R.id.textViewJurusan);
        etNama = (EditText) findViewById(R.id.editTextNama);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        rbLK = (RadioButton) findViewById(R.id.radioButtonLK);

        rbPM = (RadioButton) findViewById(R.id.radioButtonPM);

        cbRPL = (CheckBox) findViewById(R.id.checkBoxRPL);
        cbTKJ = (CheckBox) findViewById(R.id.checkBoxTKJ);
        cbMM = (CheckBox) findViewById(R.id.checkBoxMM);

        spProvinsi = (Spinner) findViewById(R.id.spinnerProvinsi);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String hasil = "";
        String jeniskelamin = null;
        if(rgJK.getCheckedRadioButtonId() !=-1){
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            jeniskelamin = rb.getText().toString() + "\n";
        }
        int startlen = hasil.length();
        if (cbRPL.isChecked()) hasil += cbRPL.getText() + "\n";
        if (cbTKJ.isChecked()) hasil += cbTKJ.getText() + "\n";
        if (cbMM.isChecked()) hasil += cbMM.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada pada pilihan";
        tvHasil.setText(hasil);


            tvHasil.setText(nama + " Jurusan Anda " + hasil + "Jenis Kelamin anda " + jeniskelamin + " Asal Provinsi " + spProvinsi.getSelectedItem().toString());

    }


}




