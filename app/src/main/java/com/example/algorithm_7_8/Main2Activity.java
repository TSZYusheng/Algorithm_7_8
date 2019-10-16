package com.example.algorithm_7_8;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity  {

    private Button mMainBTN;
    private EditText mTask1ET;
    private Button mTask1BTN;
    private EditText mTask2ET;
    private Button mTask2BTN;
    private EditText mTask3ET;
    private Button mTask3BTN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        mMainBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
            }
        });

        mTask2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n=Integer.valueOf(mTask2ET.getText().toString());
                if(n>=2&&n<=10){
                    int sum=1;
                    for (int i=1;i<n;i++){
                        sum=(sum+1)*2;
                    }
                    mTask2ET.setText(sum+"个桃子");
                }else {
                    mTask2ET.setText("请输入2-10的数");
                }

            }
        });

        mTask1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] split = mTask1ET.getText().toString().split("-");
                if(split.length==2){
                    int a=Integer.valueOf(split[0]);
                    int b=Integer.valueOf(split[1]);
                    if ((a>=10&&a<100) &&(b >= 10&&b<100)){
                        mTask1ET.setText(fun(a,b));
                    }else {
                        mTask1ET.setText("请输入两位数");
                    }
                }else {
                    mTask1ET.setText("请输入a和b用-分割");
                }

            }
        });

        mTask3BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hui=mTask3ET.getText().toString();
                if(Integer.valueOf(hui)>=10000&&Integer.valueOf(hui)<100000){
                    String hui2=hui.charAt(4)+""+hui.charAt(3)+""+hui.charAt(2)+""+hui.charAt(1)+""+hui.charAt(0)+"";
                            if(hui.equals(hui2)){
                                mTask3ET.setText("是回文数");
                            }else {
                                mTask3ET.setText("不是回文数");

                            }
                }else {
                    mTask3ET.setText("请输入5位的正整数");
                }
            }
        });


    }
    public String fun(int a,int b){
        int a1=a/10;
        int a2=a%10;
        int b1=b/10;
        int b2=b%10;
        String  c=b2+""+b1+""+a2+""+a1;
        return c;
    }
    private void initView() {
        mMainBTN = (Button) findViewById(R.id.MainBTN);
        mTask1ET = (EditText) findViewById(R.id.Task1ET);
        mTask1BTN = (Button) findViewById(R.id.Task1BTN);
        mTask2ET = (EditText) findViewById(R.id.Task2ET);
        mTask2BTN = (Button) findViewById(R.id.Task2BTN);
        mTask3ET = (EditText) findViewById(R.id.Task3ET);
        mTask3BTN = (Button) findViewById(R.id.Task3BTN);

    }


}
