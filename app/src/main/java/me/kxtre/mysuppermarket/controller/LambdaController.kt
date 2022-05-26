package me.kxtre.mysuppermarket.controller

import android.app.Activity
import android.os.Bundle

object LambdaController {
    var newsLambda: (()->Unit)? = null
}

/*
 * This represents a dummy activity where lambdas can be used
 */
class LambdaActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCallbacks()
    }

    //registers the lambda to handle future news external events
    private fun setCallbacks() {
        LambdaController.newsLambda = { TODO("Display some notification") }
    }

    /*
     * represents the outside code usually accessible from the event provider to be called
     *  upon event arrival
     */
    fun onSomeEvent() {
        LambdaController.newsLambda?.invoke()
    }

    // to be called on the activity destroy to avoid Exceptions
    private fun clearCallbacks() {
        LambdaController.newsLambda = null
    }

    override fun onDestroy() {
        clearCallbacks()
        super.onDestroy()
    }
}