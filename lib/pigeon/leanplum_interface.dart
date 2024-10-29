import 'package:pigeon/pigeon.dart';

/// This is is only for generating pigeon code, never import this file.

/*
Data class
*/
class BridgeLeanplumUserAttributes {
  String? email;
  String? userId;
}

/*
Native methods
*/
@HostApi()
abstract class BridgeLeanplumNativeMethod {
  void init(String appId, String appKey);
  void setUserAttributes(BridgeLeanplumUserAttributes attributes);
  void track(String eventName, Map<String, Object>? params);
}

/*
Flutter api methods
*/
@FlutterApi()
abstract class BridgeLeanplumMsgCallbacks {}