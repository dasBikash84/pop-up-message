package com.dasbikash.pop_up_message

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner

class ToastUtils {
    companion object {
        /**
         * Method to display short toast message
         *
         * @param context | Android Context
         * @param message | message for toast
         * */
        @JvmStatic
        fun showShortToast(context: Context, message: String,lifecycleOwner:LifecycleOwner? = null) {
            runOnMainThread(task = {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            },lifecycleOwner = lifecycleOwner)
        }

        /**
         * Method to display short toast message
         *
         * @param context | Android Context
         * @param messageId | string resource Id for toast
         * */
        @JvmStatic
        fun showShortToast(context: Context, @StringRes messageId: Int,lifecycleOwner:LifecycleOwner? = null) =
            showShortToast(context, context.getString(messageId),lifecycleOwner)

        /**
         * Method to display long toast message
         *
         * @param context | Android Context
         * @param message | message for toast
         * */
        @JvmStatic
        fun showLongToast(context: Context, message: String,lifecycleOwner:LifecycleOwner? = null) {
            runOnMainThread(task = {
                Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            },lifecycleOwner = lifecycleOwner)
        }

        /**
         * Method to display long toast message
         *
         * @param context | Android Context
         * @param messageId | string resource Id for toast
         * */
        @JvmStatic
        fun showLongToast(context: Context, @StringRes messageId: Int,lifecycleOwner:LifecycleOwner? = null) =
            showLongToast(context, context.getString(messageId),lifecycleOwner)
    }
}

/**
 * Extension function on show Long Toast from Activity
 * Will run only if activity is not destroyed
 *
 * @param message Toast message
 * */
fun AppCompatActivity.showLongToast(message: String){
    ToastUtils.showLongToast(this, message,this)
}

/**
 * Extension function on show Long Toast from Activity
 * Will run only if activity is not destroyed
 *
 * @param messageId string id resource for Toast message
 * */
fun AppCompatActivity.showLongToast(@StringRes messageId: Int)
        = showLongToast(getString(messageId))

/**
 * Extension function on show short Toast from Activity
 * Will run only if activity is not destroyed
 *
 * @param message Toast message
 * */
fun AppCompatActivity.showShortToast(message: String){
    ToastUtils.showShortToast(this, message,this)
}

/**
 * Extension function on show short Toast from Activity
 * Will run only if activity is not destroyed
 *
 * @param messageId string id resource for Toast message
 * */
fun AppCompatActivity.showShortToast(@StringRes messageId: Int)
        = showShortToast(getString(messageId))

/**
 * Extension function on show Long Toast from fragment
 *
 * @param message Toast message
 * */
fun Fragment.showLongToast(message: String){
    context?.let {
        ToastUtils.showLongToast(it, message,this)
    }
}

/**
 * Extension function on show Long Toast from fragment
 *
 * @param messageId string id resource for Toast message
 * */
fun Fragment.showLongToast(@StringRes messageId: Int)
        = showLongToast(getString(messageId))

/**
 * Extension function on show short Toast from fragment
 *
 * @param message Toast message
 * */
fun Fragment.showShortToast(message: String){
    context?.let {
        ToastUtils.showShortToast(it,message,this)
    }
}

/**
 * Extension function on show short Toast from fragment
 *
 * @param messageId string id resource for Toast message
 * */
fun Fragment.showShortToast(@StringRes messageId: Int)
        = showShortToast(getString(messageId))
