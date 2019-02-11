package com.example.gpa_castilloa15_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mytextview;
    EditText mygpa1,mygpa2,mygpa3,mygpa4,mygpa5;
    int total;
    Button confirm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytextview=(TextView)findViewById(R.id.answer);
        mygpa1=(EditText)findViewById(R.id.eGpa1);
        mygpa2=(EditText)findViewById(R.id.eGpa2);
        mygpa3=(EditText)findViewById(R.id.eGpa3);
        mygpa4=(EditText)findViewById(R.id.eGpa4);
        mygpa5=(EditText)findViewById(R.id.eGpa5);
        confirm =findViewById(R.id.btn_calc);

        mygpa1.addTextChangedListener(loginTextWatcher);
        mygpa2.addTextChangedListener(loginTextWatcher);
        mygpa3.addTextChangedListener(loginTextWatcher);
        mygpa4.addTextChangedListener(loginTextWatcher);
        mygpa5.addTextChangedListener(loginTextWatcher);
    }

    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String test1 = mygpa1.getText().toString();
            String test2 = mygpa2.getText().toString();
            String test3 = mygpa3.getText().toString();
            String test4 = mygpa4.getText().toString();
            String test5 = mygpa5.getText().toString();

            confirm.setEnabled(!test1.isEmpty() && !test2.isEmpty()&& !test3.isEmpty()&& !test4.isEmpty()&& !test5.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    public void doGpaCalc(View view) {

        String thegpa1=mygpa1.getText().toString();
        String thegpa2=mygpa2.getText().toString();
        String thegpa3=mygpa3.getText().toString();
        String thegpa4=mygpa4.getText().toString();
        String thegpa5=mygpa5.getText().toString();

        total=(Integer.parseInt(thegpa1)+Integer.parseInt(thegpa2)+Integer.parseInt(thegpa3)+Integer.parseInt(thegpa4)+Integer.parseInt(thegpa5))/5;

        mytextview.setText(Integer.toString(total));

        if (total<=60) {
            ScrollView gpamain = (ScrollView) findViewById(R.id.gpamain);
            gpamain.setBackgroundColor(getResources().getColor(R.color.red));
        }
        else if (total > 80){
            ScrollView gpamain = (ScrollView) findViewById(R.id.gpamain);
            gpamain.setBackgroundColor(getResources().getColor(R.color.green));
        }
        else {
            ScrollView gpamain = (ScrollView) findViewById(R.id.gpamain);
            gpamain.setBackgroundColor(getResources().getColor(R.color.yellow));
        }

        //rest editText

        mygpa1.getText().clear();
        mygpa2.getText().clear();
        mygpa3.getText().clear();
        mygpa4.getText().clear();
        mygpa5.getText().clear();

    }
}
