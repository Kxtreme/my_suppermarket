package me.kxtre.mysuppermarket.controller

import android.app.Activity
import android.os.Bundle


//Interface defining the callback structure
interface NewsCallback {
    fun onEvent()
}

//global object used to store nullable callbacks
object CallbackController {
    var newsCallback: NewsCallback? = null
}

/*
 * This represents a dummy activity where callbacks can be used
 */
class CallbackActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCallbacks()
    }

    //registers the callback to handle future news external events
    private fun setCallbacks() {
        CallbackController.newsCallback = object : NewsCallback {
            override fun onEvent() {
                TODO("Display some notification")
            }
        }
    }

    /*
     * represents the outside code usually accessible from the event provider to be called
     *  upon event arrival
     */
    fun onSomeEvent() {
        CallbackController.newsCallback?.onEvent()
    }

    // to be called on the activity destroy to avoid Exceptions
    private fun clearCallbacks() {
        CallbackController.newsCallback = null
    }

    override fun onDestroy() {
        clearCallbacks()
        super.onDestroy()
    }
}