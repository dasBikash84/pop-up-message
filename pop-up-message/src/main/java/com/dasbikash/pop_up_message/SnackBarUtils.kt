package com.dasbikash.pop_up_message

import android.app.Activity
import android.graphics.Color
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import com.dasbikash.pop_up_message.SnackBarUtils.Companion.DEFAULT_ACTION_TEXT_CASE_IS_UPPER
import com.dasbikash.pop_up_message.SnackBarUtils.Companion.DEFAULT_ACTION_TEXT_COLOR
import com.google.android.material.snackbar.Snackbar

/**
 * Helper class to display Snackbar.
 *
 * Snackbar can be launched using AppCompatActivity/Activity/Fragment/Any view.
 *
 * Extension function provided for calling from inside of AppCompatActivity/Activity/Fragment .
 *
 * When launched from/using AppCompatActivity/Activity/Fragment
 * Scackbar will be shown only if subject component is Resumed.
 *
 * Action text and corresponding action task can be added to Snackbar.
 * Action task will run on main thread.
 * Action text color and case can be customized.
 *
 * @author Bikash das(das.bikash.dev@gmail.com)
 *
 * */
class SnackBarUtils {

    companion object {

        internal val DEFAULT_ACTION_TEXT_COLOR = Color.MAGENTA
        internal val DEFAULT_ACTION_TEXT_CASE_IS_UPPER = false

        /**
         * Method to launch Short Snackbar using any view
         *
         * @param view | Subject View
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            view: View, message: String,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
            lifecycleOwner: LifecycleOwner?=null
        ) = showSnack(
            view, message, Snackbar.LENGTH_SHORT,
            actionText, action, actionTextColor, actionTextUpperCase,
            lifecycleOwner
        )

        /**
         * Method to launch Short Snackbar using any view
         *
         * @param view | Subject View
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            view: View, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
            lifecycleOwner: LifecycleOwner?=null
        ) {
            view.context.applicationContext.apply {
                showShortSnack(
                    view, getString(messageId),actionText, action,
                    actionTextColor, actionTextUpperCase,lifecycleOwner
                )
            }
        }

        /**
         * Method to launch Long Snackbar using any view
         *
         * @param view | Subject View
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            view: View, message: String,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
            lifecycleOwner: LifecycleOwner?=null
        ) = showSnack(
            view, message, Snackbar.LENGTH_LONG,
            actionText, action, actionTextColor, actionTextUpperCase,lifecycleOwner
        )

        /**
         * Method to launch Long Snackbar using any view
         *
         * @param view | Subject View
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            view: View, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
            lifecycleOwner: LifecycleOwner?=null
        ) {
            view.context.applicationContext.apply {
                showLongSnack(
                    view, getString(messageId), actionText, action,
                    actionTextColor, actionTextUpperCase,lifecycleOwner
                )
            }
        }

        /**
         * Method to launch Indefinite Snackbar using any view
         *
         * @param view | Subject View
         * @param message | Message that is to be displayed on Snackbar
         * */
        @JvmStatic
        fun showIndefiniteSnack(
            view: View, message: String,
            lifecycleOwner: LifecycleOwner?=null,actionText: CharSequence = "Ok"
        ) = showSnack(
            view, message, Snackbar.LENGTH_INDEFINITE,
            actionText, { it.dismiss() }, DEFAULT_ACTION_TEXT_COLOR, DEFAULT_ACTION_TEXT_CASE_IS_UPPER,lifecycleOwner
        )

        /**
         * Method to launch Long Snackbar using any view
         *
         * @param view | Subject View
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showIndefiniteSnack(
            view: View, @StringRes messageId: Int,
            lifecycleOwner: LifecycleOwner?=null,actionText: CharSequence = "Ok"
        ) {
            view.context.applicationContext.apply {
                showIndefiniteSnack(
                    view, getString(messageId), lifecycleOwner,actionText
                )
            }
        }

        /**
         * Method to launch Short Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            activity: AppCompatActivity, message: String,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            activity: AppCompatActivity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            activity: AppCompatActivity, message: String,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            activity: AppCompatActivity, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = activity.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Indefinite Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param message | Message that is to be displayed on Snackbar
         * */
        @JvmStatic
        fun showIndefiniteSnack(
            activity: AppCompatActivity, message: String,
            actionText: CharSequence = "Ok"
        ) = activity.showIndefiniteSnack(
            message,actionText
        )

        /**
         * Method to launch Indefinite Snackbar using Activity
         *
         * @param activity | Subject Activity
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * */
        @JvmStatic
        fun showIndefiniteSnack(
            activity: AppCompatActivity, @StringRes messageId: Int,
            actionText: CharSequence = "Ok"
        ) = activity.showIndefiniteSnack(
            messageId,actionText
        )

        /**
         * Method to launch Short Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            fragment: Fragment, message: String,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showShortSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Short Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showShortSnack(
            fragment: Fragment, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showShortSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Indefinite Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param message | Message that is to be displayed on Snackbar
         * */
        @JvmStatic
        fun showIndefiniteSnack(
            fragment: Fragment, message: String,
            actionText: CharSequence = "Ok"
        ) = fragment.showIndefiniteSnack(
            message,actionText
        )

        /**
         * Method to launch Indefinite Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * */
        @JvmStatic
        fun showIndefiniteSnack(
            fragment: Fragment, @StringRes messageId: Int,
            actionText: CharSequence = "Ok"
        ) = fragment.showIndefiniteSnack(
            messageId,actionText
        )

        /**
         * Method to launch Long Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param message | Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            fragment: Fragment, message: String,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showLongSnack(
            message,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        /**
         * Method to launch Long Snackbar using Fragment
         *
         * @param fragment | Subject Fragment
         * @param messageId | String resource Id of Message that is to be displayed on Snackbar
         * @param actionText | Display action text
         * @param action | Action task
         * @param actionTextColor | Action text color
         * @param actionTextUpperCase | If action Text will be UpperCase
         * */
        @JvmStatic
        fun showLongSnack(
            fragment: Fragment, @StringRes messageId: Int,
            actionText: CharSequence? = null, action: ((Snackbar) -> Any?)? = { },
            @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
            actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
        ) = fragment.showLongSnack(
            messageId,
            actionText,
            action,
            actionTextColor,
            actionTextUpperCase
        )

        private fun showSnack(
            view: View, message: String,
            duration: Int, actionText: CharSequence?, action: ((Snackbar) -> Any?)?,
            @ColorInt actionTextColor: Int, isUpperCase: Boolean,
            lifecycleOwner: LifecycleOwner?
        ) {
            try {
                val snackbar = Snackbar.make(view, message, duration)
                actionText?.let {
                    setSnackbarAction(snackbar, it, action, actionTextColor, isUpperCase)
                }
                runOnMainThread(task = {
                    snackbar.show()
                },lifecycleOwner = lifecycleOwner)
            } catch (ex: IllegalArgumentException) {
                runOnMainThread(task = {
                    Toast.makeText(
                        view.context, message, when {
                            duration == Snackbar.LENGTH_LONG -> Toast.LENGTH_LONG
                            else -> Toast.LENGTH_SHORT
                        }
                    ).show()
                },lifecycleOwner = lifecycleOwner)
            }
        }

        private fun setSnackbarAction(
            snackbar: Snackbar,
            actionText: CharSequence,
            action: ((Snackbar) -> Any?)?,
            @ColorInt actionTextColor: Int,
            isUpperCase: Boolean
        ) {
            snackbar
                .setAction(actionText) { action?.invoke(snackbar)}
                .setActionTextColor(actionTextColor)
                .getView()
                .findViewById<TextView>(R.id.snackbar_action)
                .setAllCaps(isUpperCase)
        }
    }
}

internal fun Activity.runWithView(task:(View)->Any?){
    findViewById<View>(android.R.id.content).let {
        {task(it)}
    }
}

internal fun Fragment.runWithView(task:(View)->Any?){
    view?.let {
        task(it)
    }
}

/**
 * Method to launch Short Snackbar using any view
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showShortSnack(
    message: String,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
    lifecycleOwner: LifecycleOwner?=null
) = SnackBarUtils.showShortSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase,lifecycleOwner)


/**
 * Method to launch Short Snackbar using any view
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
    lifecycleOwner: LifecycleOwner?=null
) = SnackBarUtils.showShortSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase,lifecycleOwner)


/**
 * Method to launch Long Snackbar using any view
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showLongSnack(
    message: String,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
    lifecycleOwner: LifecycleOwner?=null
) = SnackBarUtils.showLongSnack(this, message, actionText, action,actionTextColor,actionTextUpperCase,lifecycleOwner)


/**
 * Method to launch Long Snackbar using any view
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun View.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER,
    lifecycleOwner: LifecycleOwner?=null
) = SnackBarUtils.showLongSnack(this, messageId, actionText, action,actionTextColor,actionTextUpperCase,lifecycleOwner)


/**
 * Method to launch Indefinite Snackbar using any view
 *
 * @param message | Message that is to be displayed on Snackbar
 * */
fun View.showIndefiniteSnack(
    message: String,
    lifecycleOwner: LifecycleOwner?=null,
    actionText: CharSequence = "Ok"
) = SnackBarUtils.showIndefiniteSnack(this, message,lifecycleOwner,actionText)


/**
 * Method to launch Indefinite Snackbar using any view
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * */
fun View.showIndefiniteSnack(
    @StringRes messageId: Int,
    lifecycleOwner: LifecycleOwner?=null,
    actionText: CharSequence = "Ok"
) = SnackBarUtils.showIndefiniteSnack(this, messageId,lifecycleOwner,actionText)


/**
 * Method to launch Short Snackbar from inside of Activity
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)


/**
 * Method to launch Short Snackbar from inside of Activity
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showShortSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase,
                this
            )
        }
}

/**
 * Method to launch Indefinite Snackbar from inside of Activity
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * */
fun AppCompatActivity.showIndefiniteSnack(
    @StringRes messageId: Int,
    actionText: CharSequence = "Ok"
) = showIndefiniteSnack(getString(messageId),actionText)


/**
 * Method to launch Indefinite Snackbar from inside of Activity
 *
 * @param message | Message that is to be displayed on Snackbar
 * */
fun AppCompatActivity.showIndefiniteSnack(
    message:String,
    actionText: CharSequence = "Ok"
) {
    runWithView {it.showIndefiniteSnack(message,this,actionText)}
}

/**
 * Method to launch Long Snackbar from inside of Activity
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)


/**
 * Method to launch Long Snackbar from inside of Activity
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun AppCompatActivity.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase,
                this
            )
        }
}

/**
 * Method to launch Short Snackbar from inside of Fragment
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showShortSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showShortSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

/**
 * Method to launch Short Snackbar from inside of Fragment
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showShortSnack(
    message:String,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showShortSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase,
                this
            )
        }
}

/**
 * Method to launch Long Snackbar from inside of Fragment
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showLongSnack(
    @StringRes messageId: Int,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) = showLongSnack(getString(messageId),actionText, action, actionTextColor, actionTextUpperCase)

/**
 * Method to launch Long Snackbar from inside of Fragment
 *
 * @param message | Message that is to be displayed on Snackbar
 * @param actionText | Display action text
 * @param action | Action task
 * @param actionTextColor | Action text color
 * @param actionTextUpperCase | If action Text will be UpperCase
 * */
fun Fragment.showLongSnack(
    message:String,
    actionText: CharSequence? = null,
    action: ((Snackbar) -> Any?)? = { },
    @ColorInt actionTextColor: Int = DEFAULT_ACTION_TEXT_COLOR,
    actionTextUpperCase: Boolean = DEFAULT_ACTION_TEXT_CASE_IS_UPPER
) {
    runWithView {
            it.showLongSnack(
                message,
                actionText,
                action,
                actionTextColor,
                actionTextUpperCase,
                this
            )
        }
}
/**
 * Method to launch Indefinite Snackbar from inside of Fragment
 *
 * @param messageId | String resource Id of Message that is to be displayed on Snackbar
 * */
fun Fragment.showIndefiniteSnack(
    @StringRes messageId: Int,actionText: CharSequence = "Ok"
) = showIndefiniteSnack(getString(messageId),actionText)

/**
 * Method to launch Indefinite Snackbar from inside of Fragment
 *
 * @param message | Message that is to be displayed on Snackbar
 * */
fun Fragment.showIndefiniteSnack(
    message:String,actionText: CharSequence = "Ok"
) {
    runWithView {it.showIndefiniteSnack(message,this,actionText)}
}