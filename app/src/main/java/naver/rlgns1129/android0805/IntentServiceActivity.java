package naver.rlgns1129.android0805;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        //서비스를 시작
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
}