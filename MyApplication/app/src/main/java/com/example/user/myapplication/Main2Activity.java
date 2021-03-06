package com.example.user.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main2Activity extends Activity {
    Button sent_btn;
    String suger = "無糖";
    EditText set_drink;
    String ice_opt = "微冰";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group,int checkedId){
                switch (checkedId){
                    case R.id.radio0:
                        suger = "無糖";
                        break;
                    case R.id.radio1:
                        suger = "少糖";
                        break;
                    case R.id.radio2:
                        suger = "半糖";
                        break;
                    case R.id.radio3:
                        suger = "黃金比例";
                        break;
                }
            }
        });
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId){
                switch (checkedId){
                    case R.id.radioButton1:
                        ice_opt = "微冰";
                        break;
                    case R.id.radioButton2:
                        ice_opt = "少冰";
                        break;
                    case R.id.radioButton3:
                        ice_opt = "正常冰";
                        break;
                }
            }
        });
        sent_btn = (Button) findViewById(R.id.sent);
        sent_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                set_drink = (EditText) findViewById(R.id.editText1);
                String temp = set_drink.getText().toString();
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putString("suger_level",suger);
                b.putString("drink_level",temp);
                b.putString("ice_level",ice_opt);
                i.putExtras(b);
                setResult(101,i);
                finish();
            }
        });
    }
}
