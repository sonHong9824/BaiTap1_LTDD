package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button buttonbt4;
    private EditText editText;
    private Button buttonbt5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title not the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//int flag, int mask
        setContentView(R.layout.activity_main);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonbt4 = findViewById(R.id.buttonbt4);
        editText = findViewById(R.id.editTextInput);
        buttonbt5 = findViewById(R.id.buttonbt5);

        buttonbt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int[] numbers = new int[100];

                for (int i = 0; i < 100; i++) {
                    numbers[i] = random.nextInt(1000);
                }
                ArrayList<Integer> soLe = new ArrayList<>();
                ArrayList<Integer> soChan = new ArrayList<>();

                for (Integer number : numbers) {
                    if (number % 2 == 0) {
                        soChan.add(number);
                    } else {
                        soLe.add(number);
                    }
                }

                // Log the results in Logcat
                Log.d("MainActivity", "Số chẵn: " + soChan);
                Log.d("MainActivity", "Số lẻ: " + soLe);
                Toast.makeText(MainActivity.this,"Vui lòng mở console để xem kết quả", Toast.LENGTH_SHORT).show();

            }
        });
        buttonbt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString() .trim();
                if(!text.isEmpty())
                {
                    String[] t = text.split(" ");
                    StringBuilder reversed = new StringBuilder();

                    // Đảo ngược thứ tự các từ
                    for (int i = t.length - 1; i >= 0; i--) {
                        reversed.append(t[i]).append(" ");
                    }
                    text = reversed.toString().trim().toUpperCase();
                    Toast toast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.END, 0, 0);
                    
                    toast.show();
                }
                else {
                    Toast.makeText(MainActivity.this,"Vui lòng nhập chuỗi", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}