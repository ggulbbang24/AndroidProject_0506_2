package kr.ac.yeonsung3b.androidproject_0506_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    int[] btnNumId = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                        R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};
    Button[] btnNum = new Button[btnNumId.length];
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);
        textResult = findViewById(R.id.text_result);

        for (int i = 0; i < btnNum.length; i++) {
            final int index = i;
            btnNum[index] = findViewById(btnNumId[index]);
            btnNum[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edit1.isFocused()) {
                        edit1.setText(edit1.getText().toString() + btnNum[index].getText());
                    }

                    if (edit2.isFocused()) {
                        edit2.setText(edit2.getText().toString() + btnNum[index].getText());
                    }
                }
            });
        }
        Button btnPlus = findViewById(R.id.btn_plus);
        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnMulti = findViewById(R.id.btn_multi);
        Button btnDivide = findViewById(R.id.btn_divide);

        btnPlus.setOnClickListener(btnListener);
        btnMinus.setOnClickListener(btnListener);
        btnMulti.setOnClickListener(btnListener);
        btnDivide.setOnClickListener(btnListener);
    }

        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numtext1 = edit1.getText().toString();
                String numtext2 = edit2.getText().toString();

                if(numtext1.equals("") || numtext2.equals("")) {
                    Toast.makeText(MainActivity.this, "Warning! 정수를 입력해야 합니다!", Toast.LENGTH_SHORT).show();
                    return;
                }

                int num1 = Integer.parseInt(numtext1);
                int num2 = Integer.parseInt(numtext2);
                int result = 0;

                switch (view.getId()) {
                    case R.id.btn_plus:
                        result = num1 + num2;
                        break;
                    case R.id.btn_minus:
                        result = num1 - num2;
                        break;
                    case R.id.btn_multi:
                        result = num1 * num2;
                        break;
                    case R.id.btn_divide:
                        if (num2 == 0) {
                            Toast.makeText(MainActivity.this, "Warning! 0으로 나눌 수 없습니다!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        result = num1 / num2;
                        break;
                }
                textResult.setText("계산 결과 : " + result);
            }
        };
}