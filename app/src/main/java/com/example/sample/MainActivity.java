package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
        TextView result,expected;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            result=findViewById(R.id.result_tv);
            expected=findViewById(R.id.expected_tv);
            assignID(R.id.C);
            assignID(R.id.plus);
            assignID(R.id.pm);
            assignID(R.id.modulo);
            assignID(R.id.divide);
            assignID(R.id.multiply);
            assignID(R.id.dot);
            assignID(R.id.plus);
            assignID(R.id.minus);
            assignID(R.id.equal);
            assignID(R.id.one);
            assignID(R.id.two);
            assignID(R.id.three);
            assignID(R.id.four);
            assignID(R.id.five);
            assignID(R.id.six);
            assignID(R.id.seven);
            assignID(R.id.eight);
            assignID(R.id.nine);
            assignID(R.id.zero);
        }
        void assignID(int a)
        {
            MaterialButton bt = findViewById(a);
            bt.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
        MaterialButton but = (MaterialButton) view;
        String text = but.getText().toString();
        String calculateAns=expected.getText().toString();

        if (text.equals("C"))
        {
            result.setText("0");
            expected.setText("");
            return;
        }
        if (text.equals("="))
        {
            expected.setText(result.getText());
            return;
        }
        calculateAns=calculateAns+text;
        expected.setText(calculateAns);
        String finalA=calculateAnswer(calculateAns);
        if (!finalA.equals("Error"))
        {
            result.setText(finalA);
        }
    }

    String calculateAnswer(String value)
    {
        try {
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
            String finalAns=context.evaluateString(scriptable,value,"javascript",1,null).toString();
            if (finalAns.endsWith(".0"))
            {
                finalAns=finalAns.replace(".0","");
            }
            return finalAns;
        }
        catch (Exception e)
        {
            return "Error";
        }
    }




}

