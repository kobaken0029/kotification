package jp.co.kobaken.kotification.service

import android.util.Log

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

class MyFirebaseInstanceIdService : FirebaseInstanceIdService() {
    override fun onTokenRefresh() {
        val token = FirebaseInstanceId.getInstance().token
        token?.let {
            Log.i(MyFirebaseInstanceIdService::class.java.simpleName, "Registration token\n$it")
        }
    }
}
