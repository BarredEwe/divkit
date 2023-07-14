import Foundation

final class DemoUrlOpener {
  private let loadJsonUrl: (URL) -> Void

  init(loadJsonUrl: @escaping (URL) -> Void) {
    self.loadJsonUrl = loadJsonUrl
  }

  func openUrl(_ url: URL) {
    guard url.scheme == divDemoActionScheme && url.host == setDataHost,
          let path = url.queryParamValue(forName: pathParam),
          let regressionFileUrl = RegressionFile.makeUrl(path) else {
      AppLogger.error("Unhandled URL: \(url)")
      return
    }
    loadJsonUrl(regressionFileUrl)
  }
}

private let divDemoActionScheme = "div-demo-action"
private let setDataHost = "set_data"
private let pathParam = "path"
