package com.example.calculatoralr239;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initialize();
    }

    private void initialize() {
        Button[] keys = initializeKeys(); /* 0<i<10 = numKeys, 10<i<14 = opKeys,
                                            14 = enter, 15 = clear, 16 = plusminus*/




    }


    @NonNull
    private Button[] initializeKeys(){
        Button[] numberKeys = new Button[17]; //10 number keys, 4 op keys, and 3 special
        numberKeys[0] = findViewById(R.id.zero);
        numberKeys[1] = findViewById(R.id.one);
        numberKeys[2] = findViewById(R.id.two);
        numberKeys[3] = findViewById(R.id.three);
        numberKeys[4] = findViewById(R.id.four);
        numberKeys[5] = findViewById(R.id.five);
        numberKeys[6] = findViewById(R.id.six);
        numberKeys[7] = findViewById(R.id.seven);
        numberKeys[8] = findViewById(R.id.eight);
        numberKeys[9] = findViewById((R.id.nine));

        numberKeys[10] = findViewById(R.id.add);
        numberKeys[11] = findViewById(R.id.sub);
        numberKeys[12] = findViewById(R.id.div);
        numberKeys[13] = findViewById(R.id.mul);

        numberKeys[14] = findViewById(R.id.enter);
        numberKeys[15] = findViewById(R.id.clear);
        numberKeys[16] = findViewById(R.id.plusminus);

        return numberKeys;
    }
}