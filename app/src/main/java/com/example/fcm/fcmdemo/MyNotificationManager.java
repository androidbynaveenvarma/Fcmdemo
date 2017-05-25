package com.example.fcm.fcmdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Administrator on 5/24/2017.
 */

public class MyNotificationManager {

    private Context mcontext;
        public static final int noid =255;
    public MyNotificationManager(Context context){

        mcontext = context;
    }

    public void showNotification(String from, String notification, Intent intent){

        PendingIntent pendingIntent = PendingIntent.getActivity(
                mcontext,
                noid,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );

        NotificationCompat.Builder builder = new NotificationCompat.Builder(mcontext);
        Notification mnotification = builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle(from)
                .setContentText("Notification")
                .setLargeIcon(BitmapFactory.decodeResource(mcontext.getResources(),R.mipmap.ic_launcher))
                .build();

        mnotification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) mcontext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(noid, mnotification);

    }
}
