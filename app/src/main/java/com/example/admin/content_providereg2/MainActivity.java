package com.example.admin.content_providereg2;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriPermission;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText ed1,ed2;
    Button b1,b2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1= (EditText) findViewById(R.id.edittext1);
        ed2= (EditText) findViewById(R.id.edittext2);
        b1= (Button) findViewById(R.id.button1);
        b2= (Button) findViewById(R.id.button2);
        tv= (TextView) findViewById(R.id.textview);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CLIENT WANT TO INSERT STUDENT DETAILS INTO FIRST URI - STUDENT_URI
                ContentResolver contentResolver=getContentResolver();
                String name=ed1.getText().toString();
                String sub=ed2.getText().toString();
                ContentValues contentValues=new ContentValues();
                contentValues.put(UriProvider.Name,name);
                contentValues.put(UriProvider.Sub,sub);
                //now insert
                contentResolver.insert(UriProvider.STUDENT_URI,contentValues);
                Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                ed1.setText("");
                ed2.setText("");


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver cr=getContentResolver();
                Cursor c=cr.query(UriProvider.STUDENT_URI,null,null,null,null);
                StringBuilder stringbuilder = new StringBuilder();
                if (c!=null){
                    while (c.moveToNext()){
                        int no=c.getInt(0);
                        String name=c.getString(1);
                        String sub=c.getString(2);
                        stringbuilder.append("no: "+no+"name :"+name+"sub: "+sub);

                    }
                    tv.setText(stringbuilder.toString());
                }

            }
        });
    }
}
