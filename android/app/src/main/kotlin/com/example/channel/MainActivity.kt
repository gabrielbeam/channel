package com.example.channel


import com.example.LeanplumMessage
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.BinaryMessenger
import android.app.Application
import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.multidex.BuildConfig

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        val manager = ChannelIOManager()
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            ChannelIOManager.CHANNEL_CHANNELIO
        ).setMethodCallHandler { call, result ->
            when (call.method) {
                "boot" -> manager.boot(
                    call.argument<HashMap<String, Any?>>("bootConfig"),
                    result
                )

                "sleep" -> manager.sleep()
                "shutdown" -> manager.shutdown()
                "showChannelButton" -> manager.showChannelButton()
                "showMessenger" -> manager.showMessenger(this)
                "track" -> manager.track(call.arguments<String>())
            }
        }
/*        val binaryMessenger: BinaryMessenger = flutterEngine.dartExecutor.binaryMessenger

        LeanplumMessage.BridgeLeanplumNativeMethod.setup(
            binaryMessenger,
            BridgeLeanplumNativeMethodImpl(this, this.application)
        )
        mLeanplumApi = LeanplumMessage.BridgeLeanplumMsgCallbacks(binaryMessenger)*/
    }

//    private class BridgeLeanplumNativeMethodImpl
//    constructor(
//        private val context: Context,
//        private val application: Application,
//    ) : LeanplumMessage.BridgeLeanplumNativeMethod {
//        override fun init(appId: String, appKey: String) {
//            Log.d(TAG, "BridgeLeanplumNativeMethodImpl init, appId $appId, appKey $appKey")
//
//            Leanplum.setApplicationContext(context)
//            Parser.parseVariables(this)
//
//            //  For session lifecycle tracking. Must be called if you do not extend
//            // LeanplumApplication Class
//            LeanplumActivityHelper.enableLifecycleCallbacks(application)
//
//            if (BuildConfig.DEBUG) {
//                Leanplum.setAppIdForDevelopmentMode(appId, appKey)
//            } else {
//                Leanplum.setAppIdForProductionMode(appId, appKey)
//            }
//
//            // This will only run once per session, even if the activity is restarted.
//            Leanplum.start(context)
//            Leanplum.track("LEANPLUM_START_ANDROID")
//        }
//
//        override fun setUserAttributes(attributes: LeanplumMessage.BridgeLeanplumUserAttributes) {
//            Log.d(
//                TAG,
//                "BridgeLeanplumNativeMethodImpl setUserAttributes, userId ${attributes.userId}, email ${attributes.email}"
//            )
//            Leanplum.setUserId(attributes.userId)
//            Leanplum.track("LEANPLUM_SET_USER_ID", mutableMapOf("userId" to attributes.userId))
//
//            val attributeMap: MutableMap<String, Any> = mutableMapOf<String, Any>()
//            attributeMap.put("email", attributes.email ?: "")
//            Leanplum.setUserAttributes(attributeMap)
//            Leanplum.track("LEANPLUM_SET_EMAIL", attributeMap)
//        }
//
//        override fun track(eventName: String, params: MutableMap<String?, Any?>?) {
//            Log.d(TAG, "BridgeLeanplumNativeMethodImpl track, event $eventName ")
//            Leanplum.track(eventName, params)
//        }
//    }
}
