lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .enablePlugins(ScalaJSBundlerPlugin)
  .settings(
    inThisBuild(List(
      organization := "com.dallaway",
      version      := "1.0.0",
      scalaVersion := "2.12.8"
    )),
    name := "js-pg",
    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= { _.withModuleKind(ModuleKind.CommonJSModule) },
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalacOptions += "-Ypartial-unification",
    npmDependencies in Compile += "pg" -> "7.8.0",
  )

