package com.example.percobaan1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtwidth;
    private EditText edtheigth;
    private EditText edtlength;
    private Button btncalculate;
    private TextView tvresult;


    @Override
    protected void onCreate (Bundle savedInstantceState) {
        super.onCreate(savedInstantceState);
        setContentView(R.layout.activity_main);

        edtwidth = findViewById(R.id.edit_width);
        edtheigth = findViewById(R.id.edit_heigth);
        edtlength = findViewById(R.id.edit_length);
        btncalculate = findViewById(R.id.btn_calculate);
        tvresult = findViewById(R.id.tv_result);
        btncalculate.setOnClickListener(this);

        if (savedInstantceState != null){
            String result = savedInstantceState.getString(STATE_RESULT);
            tvresult.setText(result);
        }
    }

    @Override
    public void onClick(View view) {
        if (view.getId () == R.id.btn_calculate) {
            String inputLength =
                    edtlength.getText() .toString() .trim();
            String inputWidth =
                    edtwidth.getText() .toString() .trim();
            String inputHeight =
                    edtheigth.getText() .toString() .trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputLength)){
                isEmptyFields = true;
                edtlength.setError("Field ini Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inputWidth)){
                isEmptyFields = true;
                edtwidth.setError("Field ini Tidak Boleh Kosong");
            }

            if (TextUtils.isEmpty(inputHeight)){
                isEmptyFields = true;
                edtheigth.setError("Field ini Tidak Boleh Kosong");
            }
            if (!isEmptyFields) {
                Double volume = Double.parseDouble(inputLength) *
                        Double.parseDouble(inputWidth) * Double.parseDouble(inputHeight);
                tvresult.setText(String.valueOf(volume));
            }
        }

    }
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState (outState);
        outState.putString(STATE_RESULT, tvresult.getText().toString());
    }
}

