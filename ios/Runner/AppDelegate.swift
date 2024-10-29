import Flutter
import UIKit
import ChannelIOFront

@main
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
      let controller = window.rootViewController as! FlutterViewController
      
      let leanplumHostApi = MyLeanplum()
      BridgeLeanplumNativeMethodSetup(controller.binaryMessenger, leanplumHostApi)

      ChannelIO.initialize(application)
      
      GeneratedPluginRegistrant.register(with: self)

    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
}
