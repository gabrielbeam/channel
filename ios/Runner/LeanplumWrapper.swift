import Foundation
import Leanplum


class MyLeanplum: NSObject, BridgeLeanplumNativeMethod {
    func initAppId(_ appId: String, appKey: String, error: AutoreleasingUnsafeMutablePointer<FlutterError?>) {
        
#if DEBUG
        Leanplum.setAppId(appId, developmentKey: appKey)
#else
        Leanplum.setAppId(appId, productionKey: appKey)
#endif
        
        // Sets the app version, which otherwise defaults to
        // the build number (CFBundleVersion).
        Leanplum.setAppVersion("2.1.2")
        
        // Starts a new session and updates the app content from Leanplum.
        Leanplum.start()
        Leanplum.track("LEANPLUM_START_IOS")
    }
    
    func setUserAttributesAttributes(_ attributes: BridgeLeanplumUserAttributes, error: AutoreleasingUnsafeMutablePointer<FlutterError?>) {
        Leanplum.setUserId(attributes.userId ?? "")
        Leanplum.track("LEANPLUM_SET_USER_ID", params:["userId": attributes.userId])

        Leanplum.setUserAttributes(["email": attributes.email])
        Leanplum.track("LEANPLUM_SET_EMAIL", params: ["email": attributes.email])
    }

    func trackEventName(_ eventName: String, params: [String : Any]?, error: AutoreleasingUnsafeMutablePointer<FlutterError?>) {
        Leanplum.track(eventName, params: params)
    }
}
