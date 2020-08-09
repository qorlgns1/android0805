package naver.rlgns1129.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        //리시버 등록
        registerReceiver(new MyReceiver(), new IntentFilter("naver.rlgns1129.sendbroadcast"));
    }
}
