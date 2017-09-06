package br.com.facotudobrasil;

import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by alison on 28/08/17.
 */

public class SplashActivity extends AppCompatActivity {

    private static SplashTimer timer;
    private final static int TIMER_INTERVAL = 4000; // 2 sec
    private boolean activityStarted;
    private boolean exitAds = false;
    private boolean mWasGetContentIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        mWasGetContentIntent = intent.getAction().equals(
                Intent.ACTION_GET_CONTENT);

        setContentView(R.layout.activity_splash);
        StartAnimations();



        timer = new SplashTimer();
        timer.sendEmptyMessageDelayed(1, TIMER_INTERVAL);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    final class SplashTimer extends Handler {
        @Override
        public void handleMessage(Message msg) {
            post(new Runnable() {

                public void run() {
                    timer = null;

                    startHomePageActivity();
                }
            });
        }
    }

    private void startHomePageActivity() {
        if (activityStarted) {
            return;
        }
        activityStarted = true;

        SplashActivity.this.runOnUiThread(new Runnable() {

            @Override
            public void run() {

                startActivity(new Intent(SplashActivity.this, PaginaInicialActivity.class));
                finish();
            }
        });
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        anim.reset();
        TextView iv = (TextView) findViewById(R.id.logo);
        iv.clearAnimation();
        iv.startAnimation(anim);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}
