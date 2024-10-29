package com.example.channel

import com.zoyi.channel.plugin.android.ChannelIO
import io.flutter.app.FlutterApplication

class ChannelTalkApp: FlutterApplication() {
    override fun onCreate() {
        super.onCreate()
        ChannelIO.initialize(this)
    }
}