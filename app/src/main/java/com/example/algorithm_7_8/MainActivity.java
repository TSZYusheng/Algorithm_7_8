package com.example.algorithm_7_8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private EditText mTask1ET;
    private Button mTask1BTN;
    private EditText mTask2ET;
    private Button mTask2BTN;
    private EditText mTask3ET;
    private Button mTask3BTN;
    double num;
    private Button mMain2BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mMain2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
            }
        });
        mTask1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] split = mTask1ET.getText().toString().split("-");
                ArrayList<String> s = new ArrayList<>();
                HashMap<String, Integer> hm = new HashMap<>();
                for (int i = 0; i < split.length; i++) {
                    if (hm.get(split[i]) == null) {
                        hm.put(split[i], 1);
                    } else {
                        int c = hm.get(split[i]) + 1;
                        hm.put(split[i], c);
                    }
                }
                int max1;
                int max2 = 0;
                String max = "";
                Iterator<Map.Entry<String, Integer>> iterator = hm.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry next = iterator.next();
                    max1 = (int) next.getValue();
                    if (max1 > max2) {
                        max = (String) next.getKey();
                    }
                    max2 = max1;
                }
                Iterator<Map.Entry<String, Integer>> iterator1 = hm.entrySet().iterator();
                while (iterator1.hasNext()) {
                    Map.Entry next = iterator1.next();
                    if (next.getValue() == hm.get(max)) {
                        s.add((String) next.getKey());
                    }
                }
                ArrayList<Integer> d = new ArrayList<>();
                for (int i = 0; i < s.size(); i++) {
                    for (int j = 0; j < split.length; j++) {
                        if (s.get(i) == split[j]) {
                            d.add(j);
                        }
                    }
                }

                Collections.sort(d);
                mTask1ET.setText(split[d.get(0)] + "的最大值是：" + hm.get(max));
            }
        });
        mTask2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n = Integer.valueOf(mTask2ET.getText().toString());
                double sum = 0;
                if (n >= 100 && n <= 10000) {
                    for (int i = 1; i <= n; i++) {
                        if (i % 3 == 0 && i % 7 == 0) {
                            sum += i;
                        }
                    }
                    num = sum;
                    double s = PinFGen(sum);
                    mTask2ET.setText(s + "");

                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream("/storage/emulated/0/out.txt");
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                        outputStreamWriter.write(s + "");
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                        fileOutputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    mTask2ET.setText("请输入100到10000范围的数");
                }

            }
        });

        mTask3BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.valueOf(mTask3ET.getText().toString());
                int b = a;
                if (a >= 2 && a <= 9) {
                    int s = 0;
                    for (int i = 1; i <= a; i++) {
                        b = a;
                        for (int j = 1; j < i; j++) {
                            b = b * 10 + a;
                        }
                        s += b;
                    }
                    mTask3ET.setText(s + "");
                } else {
                    mTask3ET.setText("请输入大于等于2小于等于9的数");
                }

            }
        });

    }

    public double PinFGen(double s) {
        double res = (s + num / s) / 2;
        if (res == s) {
            return s;
        } else {
            return PinFGen(res);
        }
    }

    private void initView() {
        mTask1ET = (EditText) findViewById(R.id.Task1ET);
        mTask1BTN = (Button) findViewById(R.id.Task1BTN);
        mTask2ET = (EditText) findViewById(R.id.Task2ET);
        mTask2BTN = (Button) findViewById(R.id.Task2BTN);
        mTask3ET = (EditText) findViewById(R.id.Task3ET);
        mTask3BTN = (Button) findViewById(R.id.Task3BTN);
        mMain2BTN = (Button) findViewById(R.id.Main2BTN);
    }
}
