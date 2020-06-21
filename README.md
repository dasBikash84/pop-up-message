# pop-up-message

Library for android pop up message (`Snackbar`, `Toast`, `Alert dialog`) display.


[![](https://jitpack.io/v/dasBikash84/pop-up-message.svg)](https://jitpack.io/#dasBikash84/pop-up-message)

## Dependency

Add this in your root `build.gradle` file (**not** your module `build.gradle` file):

```gradle
allprojects {
	repositories {
        maven { url "https://jitpack.io" }
    }
}
```

Then, add the library to your module `build.gradle`
```gradle
dependencies {
    implementation 'com.github.dasBikash84:pop-up-message:latest.release.here'
}
```

## Features
- [`Snackbar`](https://github.com/dasBikash84/pop-up-message/blob/master/pop-up-message/src/main/java/com/dasbikash/pop_up_message/SnackBarUtils.kt) can be launched using `AppCompatActivity/Fragment/Any view`.
- [`Toast`](https://github.com/dasBikash84/pop-up-message/blob/master/pop-up-message/src/main/java/com/dasbikash/pop_up_message/ToastUtils.kt) will always run on main thread no matter from which thread it is called.
- Utility class provided for [`Alert Dialog`](https://github.com/dasBikash84/pop-up-message/blob/master/pop-up-message/src/main/java/com/dasbikash/pop_up_message/DialogUtils.kt) display with custom view option.
- Extension function provided for displaying Snackbar/Toast from `inside` of AppCompatActivity/Fragment.
- When launched using AppCompatActivity/Fragment (lifecycle hook) Scackbar/Toast will be shown only if subject component is in `Resumed` state.
- Action text and corresponding `action task` can be added to Snackbar. Also action text color and case can be customized.
- If Snackbar is called with a view that has to active root view, then `Toast` will be displayed with supplied message as fall-back.

## Usage example

##### Show snack from inside of `AppCompatActivity` / `Activity` / `Fragment` class body with/without attaching `action`
```
    showShortSnack("Snack message")
    		//or
    showLongSnack(snackMessageId) // snackMessageId is a String resource Id
    		//or
    showShortSnack(message = "Snack message",actionText = "Action",
                    action = { println("Short snack with default action format")})
    		//or
    SnackBarUtils.showShortSnack(this,snackMessageId) // snackMessageId is a String resource Id 
```

##### Show snack from any class with a `view` instance (with/without attaching `action`)
```
    SnackBarUtils.showShortSnack(view,"Snack message") // 'view' is an instance of any 'View'
    		//or
    SnackBarUtils.showLongSnack(view,snackMessageId) // snackMessageId is a String resource Id
    		//or
    SnackBarUtils.showShortSnack(view = view,message = "Snack message",actionText = "Action",
                    action = { println("Short snack with default action format")}) // 'view' is an instance of 'View'
                    
    		//or
		
    SnackBarUtils.showLongSnack(view = view,messageId = snackMessageId,actionText = "Action",
                    action = { println("Long snack with blue lower case action text")},
                    actionTextColor = Color.BLUE,
                    actionTextUpperCase = false) // snackMessageId is a String resource Id
```


##### To display toast message from `Activity` / `AppCompatActivity` / `Fragment` class body
```
    //To show short toast of given message
    showShortToast(message)
	//or
    //To show short toast of given message string resource
    showShortToast(messageId)
	//or
    //To show long toast of given message
    showLongToast(message)
	//or
    //To show long toast of given message string resource
    showLongToast(messageId)
```


##### To display toast message from Any class
```
    //To show short toast of given message
    ToastUtils.showShortToast(context,message)
	//or    
    //To show short toast of given message string resource
    ToastUtils.showShortToast(context,messageId)
	//or    
    //To show long toast of given message
    ToastUtils.showLongToast(context,message)
	//or    
    //To show long toast of given message string resource
    ToastUtils.showLongToast(context,messageId)
```

#### Displaying alert dialog

```
     // context is an instance of Android 'Context'
     // view is an instance of Android 'View' that will be shown on dialog
     
    DialogUtils.showAlertDialog(context, DialogUtils.AlertDialogDetails(
        titile = "Dialog Tiile",
        message = "Dialog Message",
        view = view,
        positiveButtonText = "Yes",
        negetiveButtonText = "No",
        doOnPositivePress = {
            // Positive button press task
        },
        doOnNegetivePress = {
            // Negetive button press task
        }
    ))
```

License
--------

    Copyright 2020 Bikash Das(das.bikash.dev@gmail.com)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
