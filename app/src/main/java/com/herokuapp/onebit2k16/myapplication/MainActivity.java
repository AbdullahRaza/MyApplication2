package com.herokuapp.onebit2k16.myapplication;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TableLayout table;
    boolean rowColorSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table= (TableLayout) findViewById(R.id.mytable);
        rowColorSwitch=true;

        ArrayList<String> header=new ArrayList<String>();
        header.add("name");
        header.add("roll");
        header.add("height");

        addHeader(header);

        for (int i=0;i<150;i++)
        {
            ArrayList<String> row=new ArrayList<String>();
            row.add("a");
            row.add("a");
            row.add("a");
            table.addView(createRow(row));
//            addHeader(header);


        }


    }



    private void addHeader(ArrayList<String> columns)
    {
        TableRow row=new TableRow(this);
        row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));


        for (int i=0;i<columns.size();i++)
        {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(15);
            tv.setPadding(10,0,10,0);
            tv.setTypeface(null, Typeface.BOLD);
            tv.setText(columns.get(i));
            tv.setTextColor(Color.rgb(0,0,0));


            row.addView(tv);

        }


        table.addView(row);

    }

    private void populateRow(TableRow row, ArrayList<String> columns) {



        for (int i = 0; i<columns.size(); i++)
        {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(10);
            tv.setPadding(5,0,5,5);
            tv.setText(columns.get(i));
            tv.setTextColor(Color.rgb(255,255,255));
            if(rowColorSwitch)
            {
//                tv.setBackgroundColor(Color.rgb(104,166,194));
                tv.setBackgroundResource(R.color.colorPrimary);
            }
            else
            {
                tv.setBackgroundColor(Color.rgb(104,166,213));
//                tv.setBackgroundResource(R.color.colorPrimaryDark);
            }



            row.addView(tv);

        }
        if(rowColorSwitch)
            rowColorSwitch=false;
        else
            rowColorSwitch=true;

    }

    TableRow createRow(ArrayList<String> columns)
    {
        TableRow row=new TableRow(this);
        row.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

        populateRow(row,columns);
        return row;

    }

}
