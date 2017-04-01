package com.mytoast;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Toast toast =null;
    private static TextView tv_text =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        ShowToastMessage("Hello Eason",MainActivity.this);
    }
    public static void ShowToastMessage(String message, Context context) {
        if (toast == null || tv_text == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View layout = inflater.inflate(R.layout.layout_main, null);
            RelativeLayout root = (RelativeLayout) layout.findViewById(R.id.rootId);
            root.getBackground().setAlpha(200);
            tv_text=(TextView)layout.findViewById(R.id.text);
            toast = new Toast(context);
            toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
        }
        tv_text.setText(message);
        toast.show();
    }
}
