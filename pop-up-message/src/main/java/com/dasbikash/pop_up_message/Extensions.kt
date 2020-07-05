package com.dasbikash.pop_up_message

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner

internal fun runOnMainThread(task: () -> Unit,delayMs:Long=0L,lifecycleOwner: LifecycleOwner?=null){
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