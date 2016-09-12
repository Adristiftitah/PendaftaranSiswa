package id.sch.smktelkom_mlg.learn.myapplication1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
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

    private void doClick() {

        String hasil = "Jurusan Anda : \n";
        if (rbLK.isChecked()) {
            hasil = rbLK.getText().toString();
        } else if (rbPM.isChecked()) {
            hasil = rbPM.getText().toString();
        }
        if (hasil == null) {
            tvHasil.setText("Belum memilih Jenis Kelamin");
        } else {
            tvHasil.setText("Jenis Kelamin Anda: " + hasil);
        }
        int startlen = hasil.length();
        if (cbRPL.isChecked()) hasil += cbRPL.getText() + "\n";
        if (cbTKJ.isChecked()) hasil += cbTKJ.getText() + "\n";
        if (cbMM.isChecked()) hasil += cbMM.getText() + "\n";

        if (hasil.length() == startlen) hasil += "Tidak ada pada pilihan";
        tvHasil.setText(hasil);

        tvHasil.setText("Wilayah Provinsi " + spProvinsi.getSelectedItem().toString());
    }


}




