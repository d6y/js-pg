lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    inThisBuild(
      List(
        organization := "com.dallaway",
        version := "1.0.0",
        scalaVersion := "2.12.8"
      )),
    name := "js-pg",
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalacOptions += "-Ypartial-unification",
    // Demo main entry point:
    scalaJSUseMainModuleInitializer := true,
    // We do need the node pg module:
    npmDependencies in Compile += "pg" -> "7.8.0",
    // We need this for fastOptJS::webpack to compile the code, but not sure we use it:
    npmDependencies in Compile += "pg-native" -> "3.0.0",
    // Tell webpack we're targeting nodejs, otherwise it can't find "net" and other native modules:
    webpackConfigFile := Some(baseDirectory.value / "custom.webpack.config.js"),
  )
