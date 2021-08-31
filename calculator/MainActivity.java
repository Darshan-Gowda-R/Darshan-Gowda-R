package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    TextView question,answer;

    int flag=0,first,second;
    String b="",c="",s="",t="",full="";


    public void calculate(View view){
    Button button=(Button)view;
    String a;
    a=button.getTag().toString();
    if(a.equals("clear") || a.equals("equals") || a.equals("Back")){
        clear(a);
    }
else{
    display(a);
    }

    }



    private void clear(String v) {

    if(v.equals("clear")){
        b="";
        c="";t="";
        s="";flag=0;full="";
        question.setText("");
        answer.setText("");return;
    }
    else if(v.equals("Back")){

       full=full.substring(0,full.length()-1);

                Log.i("the text is",full);
                question.setText(full);




    }
        else{

            float d=0;
            second=Integer.parseInt(c);
            d=cal();
        answer.setText(Float.toString(d));

   Log.i("the answer is =  ",Float.toString(d));
    }
    }




    private float cal() {

  if (s.equals("+")){
      return first+second;
  }
  else if (s.equals("-")){
      return first-second;
  }
  else if(s.equals("x")){
      return (first*second);

      //Log.i("came Here",first*second);
  }
  else
      return first/second;
    }











    public void display(String a ){


        if(a.equals("+")|| a.equals("-") || a.equals("x") || a.equals("/")){

            flag=1;s=a;t+=a;
            question.setText(b+ ""+s );

            first=Integer.parseInt(full);
            full+=""+a+"";

            Log.i("the value of first =", String.valueOf(first));
            Log.i("the sign is =  ", s);
            Log.i("the full is= ",full);

        }



        else{
            if(flag==1){
                c+=a;
                t+=a;
                full+=a;
                question.setText(full);
                first=Integer.parseInt(b);
                second=Integer.parseInt(c);
                float cal = cal();
                answer.setText(Float.toString(cal));
            }
            else {
                b += a;

                t += a;
                full += a;
                question.setText(full);
            }
        }

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question= (TextView)findViewById(R.id.text);
         answer= (TextView)findViewById(R.id.text0);

//calculate(answer);
    }
}