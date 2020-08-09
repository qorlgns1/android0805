package naver.rlgns1129.android0805;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "알람아~ 울려라!!!!" , Toast.LENGTH_LONG).show();
    }
}
