package com.dasbikash.display_utils

import android.app.Activity
import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

internal fun <T> T.runOnMainThread(task: () -> Unit,delayMs:Long=0L,lifecycleOwner: LifecycleOwner?){
    Handler(Looper.getMainLooper()).postDelayed( {
        if (lifecycleOwner!=null){
            if (lifecycleOwner.lifecycle.currentState == Lifecycle.State.RESUMED){
                task()
            }
        }else{
            task()
        }
    },delayMs)
}