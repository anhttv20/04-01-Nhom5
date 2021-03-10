package com.example.a04_01_nhom5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
     implements View.OnClickListener{
    private EditText et1,et2;
    private Button btAdd;
    private Spinner spOperator;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btAdd.setOnClickListener(this);
//        btAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    double n1=Double.parseDouble(et1.getText().toString());
//                    double n2=Double.parseDouble(et2.getText().toString());
//                    result.setText("Result:"+(n1+n2));
//                }catch(NumberFormatException e){
//                    System.out.println(e);
//                }
//            }
//        });
          spOperator.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  try{
                      double n1 = Double.parseDouble(et1.getText().toString());
                      double n2 = Double.parseDouble(et2.getText().toString());
                      String op=spOperator.getSelectedItem().toString();
                      String rs=cal(n1,n2,op);
                      result.setText(rs);
                  }catch(NumberFormatException e){
                      System.out.println(e);
                  }
              }

              @Override
              public void onNothingSelected(AdapterView<?> parent) {

              }
          });
    }
    private String cal(double n1,double n2,String op){
        String st="";
        switch(op){
            case "+": st="Sum:"+(n1+n2);
                break;
            case "-": st="Substract:"+(n1-n2);
                break;
            case "x": st="Multiply:"+(n1*n2);
                break;
            case ":": if(n2==0)
                        st="not divide by zero";
                      else
                        st="Divide:"+(n1/n2);
                break;
        }
        return st;
    }

    private void initView() {
        et1=findViewById(R.id.n1);
        et2=findViewById(R.id.n2);
        btAdd=findViewById(R.id.btAdd);
        spOperator=findViewById(R.id.spOp);
        result=findViewById(R.id.result);
        String[] st={"+","-","x",":"};
//        ArrayAdapter<String > adapter=new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item,st);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter=new ArrayAdapter(this,
                R.layout.spinner_item,st);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spOperator.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        //if(v==btAdd) {
            try {
                double n1 = Double.parseDouble(et1.getText().toString());
                double n2 = Double.parseDouble(et2.getText().toString());
                result.setText("Result:" + (n1 + n2));
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        //}
    }
}
