package jp.co.kobaken.kotification.service

import android.app.Notification.*
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import android.support.v4.app.NotificationManagerCompat
import android.app.PendingIntent
import android.content.Intent
import android.support.v7.app.NotificationCompat
import jp.co.kobaken.kotification.MainActivity
import jp.co.kobaken.kotification.MainActivity.Companion.ARG_ID
import jp.co.kobaken.kotification.MainActivity.Companion.ARG_TYPE
import jp.co.kobaken.kotification.R
import jp.co.kobaken.kotification.parseInt

class MyFirebaseMessagingService : FirebaseMessagingService() {
    companion object {
        val FCM_DATA_KEY_ID = "id"
        val FCM_DATA_KEY_TYPE = "type"
    }

    override fun onMessageReceived(message: RemoteMessage?) {
        message?.run {
            val context = applicationContext
            val pendingIntent = PendingIntent.getActivity(context, 0,
                    Intent(context, MainActivity::class.java).apply {
                        putExtra(ARG_ID, this@run.data[FCM_DATA_KEY_ID])
                        putExtra(ARG_TYPE, this@run.data[FCM_DATA_KEY_TYPE])
                    }, PendingIntent.FLAG_UPDATE_CURRENT)

            val notificationBuilder = NotificationCompat.Builder(context).apply {
                setSmallIcon(R.mipmap.ic_launcher)
                setContentTitle(this@run.notification.title)
                setContentText(this@run.notification.body)
                setDefaults(DEFAULT_SOUND or DEFAULT_VIBRATE or DEFAULT_LIGHTS)
                setAutoCancel(true)
                setContentIntent(pendingIntent)
            }

            data[FCM_DATA_KEY_ID]?.parseInt()?.let {
                NotificationManagerCompat.from(context)
                        .notify(it, notificationBuilder.build())
            }
        }
    }
}
