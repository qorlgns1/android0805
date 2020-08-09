package naver.rlgns1129.android0805;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {
                //알람 시간 만들기
                Calendar calendar = Calendar.getInstance();
                //현재 시간에서 10 초 후
                calendar.add(Calendar.SECOND, 10);

                //알람등록
                Intent intent = new Intent(AlarmActivity.this, AlarmReceiver.class);
                PendingIntent pIntent = PendingIntent.getBroadcast(AlarmActivity.this, 0 , intent, 0);

                AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pIntent);




            }
        });
    }
}