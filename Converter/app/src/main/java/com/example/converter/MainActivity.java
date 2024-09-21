package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private Spinner spinner1, spinner2;
    private int num2, num3;
    private long num1;
    private TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result=(TextView) findViewById(R.id.textView);
        spinner1=(Spinner) findViewById(R.id.spinner);
        number=(TextView) findViewById(R.id.textView2);

        ArrayAdapter<?> adapter1 =
                ArrayAdapter.createFromResource(this, R.array.Bases,
                        android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setSelection(8);
        spinner2=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<?> adapter2 =
                ArrayAdapter.createFromResource(this, R.array.Bases,
                        android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(0);
    }

    public void onNumberClick(View view){
        Button button = (Button)view;
        String str = number.getText().toString();
        str +=(button.getText().toString());
        number.setText(str);
    }

    public void onButtonEraseAllClick(View view){
        number.setText(null);
    }

    public void onButtonEraseOneClick(View view){
        String str1 = number.getText().toString();
        if (str1 == null || str1.length() == 0) str1=null;
        else str1=str1.substring(0, str1.length() - 1);
        number.setText(str1);
    }

    public void onButtonRavnoClick(View view){
        if (number.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Ошибка! Введите число!", Toast.LENGTH_SHORT).show();
        }
        else {
            num2 = Integer.parseInt(spinner1.getSelectedItem().toString());
            try {
                num1 = Long.parseLong(number.getText().toString(), num2);
            }
            catch (Exception e){
                Toast.makeText(MainActivity.this, "Ошибка! Введены неверные данные или число слишком большое!", Toast.LENGTH_SHORT).show();
            }
            num3 = Integer.parseInt(spinner2.getSelectedItem().toString());
            result.setText(Long.toString(num1, num3));
        }
    }
}