package com.example.applicationnotification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat

lateinit var notificationChannel: NotificationChannel
lateinit var notificationManager: NotificationManager
lateinit var builder: NotificationCompat.Builder

// Dispara a notificação
fun Context.showNotification(channelID: String, title: String, body: String) {
    // Responsável por gerenciar todas as notificações do aplicativo
    notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    val intent = Intent(this, MainActivity::class.java)
    val pendingIntent = PendingIntent.getActivity(this, 0,intent,PendingIntent.FLAG_UPDATE_CURRENT)

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        // Manipular o objeto da notificação
        notificationChannel = NotificationChannel(channelID,body,NotificationManager.IMPORTANCE_HIGH).apply {
            lightColor = Color.BLUE
            enableVibration(true)
        }

        notificationManager.createNotificationChannel(notificationChannel)

        // Dispara a notificação
        builder = NotificationCompat.Builder(this, channelID).apply {
            setSmallIcon(R.drawable.ic_refresh)
            setContentTitle(title)
            setContentText(body)
            setAutoCancel(true)
            setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
            setContentIntent(pendingIntent)
        }
    }

    notificationManager.notify(channelID.toInt(),builder.build())

}