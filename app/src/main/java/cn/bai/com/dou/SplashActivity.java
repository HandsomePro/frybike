package cn.bai.com.dou;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener{

    private Button byId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        byId = (Button) findViewById(R.id.button);
        byId.setOnClickListener(this);



        new Thread(){
            @Override
            public void run() {
                super.run();
                Looper.prepare();
                Toast.makeText(SplashActivity.this,"first",Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(SplashActivity.this,"second",Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }).start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                Toast.makeText(this,"hello world",Toast.LENGTH_LONG).show();
        }
    }
}
