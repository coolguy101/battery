package com.example1.bestbattery;

import android.app.ApplicationErrorReport.BatteryInfo;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class statusReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		
			
			int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
			int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
			float batteryPct = level / (float)scale;
			Toast.makeText(context, "Battery lvl is:"+batteryPct,Toast.LENGTH_SHORT).show();
			NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
					context).setSmallIcon(R.drawable.ic_launcher)
					.setContentTitle("Battery is at:"+batteryPct)
					.setContentText("Battery level:"+batteryPct).setAutoCancel(false).setOngoing(true); // make it stay in action bar

					NotificationManager mNotificationManager = (NotificationManager) context
					.getSystemService(Context.NOTIFICATION_SERVICE);
					// mId allows you to update the notification later on.
					mNotificationManager.notify(2, mBuilder.build());
		
	}

}
