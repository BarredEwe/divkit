import Foundation

import CommonCorePublic
import DivKit
import DivKitExtensions
import LayoutKit
import NetworkingPublic

enum AppComponents {
  static let fontProvider = YSFontProvider()

  static func makeDivKitComponents(
    updateCardAction: DivKitComponents.UpdateCardAction? = nil,
    urlOpener: @escaping UrlOpener = { _ in }
  ) -> DivKitComponents {
    let performer = URLRequestPerformer(urlTransform: nil)
    let requester = NetworkURLResourceRequester(performer: performer)
    let lottieExtensionHanlder = LottieExtensionHandler(
      factory: LottieAnimationFactory(),
      requester: requester
    )
    let variablesStorage = DivVariablesStorage()
    let sizeProviderExtensionHandler = SizeProviderExtensionHandler(
      variablesStorage: variablesStorage
    )
    return DivKitComponents(
      divCustomBlockFactory: PlaygroundDivCustomBlockFactory(requester: requester),
      extensionHandlers: [
        lottieExtensionHanlder,
        sizeProviderExtensionHandler,
        ShimmerImagePreviewExtension(),
      ],
      flagsInfo: DivFlagsInfo(),
      fontProvider: fontProvider,
      patchProvider: DemoPatchProvider(),
      trackVisibility: { logId, cardId in
        AppLogger.info("Visibility: cardId = \(cardId), logId = \(logId)")
      },
      trackDisappear: { logId, cardId in
        AppLogger.info("Disappear: cardId = \(cardId), logId = \(logId)")
      },
      updateCardAction: updateCardAction,
      playerFactory: DefaultPlayerFactory(),
      urlOpener: urlOpener,
      variablesStorage: variablesStorage
    )
  }

  static var debugParams: DebugParams {
    DebugParams(isDebugInfoEnabled: true)
  }
}
