// ChannelIO.dart

import 'dart:async';

import 'package:flutter/services.dart';

class ChannelIO {
  static const platform = const MethodChannel("com.example.channel/channelIO");
  static const badgeChannel =
      const EventChannel("com.example.channel/channelIO/badge");

  static Future<Future> boot() async {
    return platform.invokeMethod("boot", {
      "bootConfig": {
        "pluginKey": "PLUGIN_KEY",
        "memberId": "flutter-test",
      } as Future<String>,
    });
  }

  static void sleep() {
    platform.invokeMethod("sleep");
  }

  static void shutdown() {
    platform.invokeMethod("shutdown");
  }

  static void showChannelButton() {
    platform.invokeMethod("showChannelButton");
  }

  static void showMessenger() {
    platform.invokeMethod("showMessenger");
  }

  static void track(String eventName) {
    platform.invokeMethod("track", eventName);
  }

  static void setBadgeListener(Function listener) {
    badgeChannel.receiveBroadcastStream().listen((badgeCount) {
      listener.call(badgeCount);
    });
  }
}
