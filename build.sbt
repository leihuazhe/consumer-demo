name := "consumer-demo"

version := "0.2-SNAPSHOT"

scalaVersion := "2.12.2"

organization := "com.github.dapeng"

resolvers += Resolver.mavenLocal

lazy val commonSettings = Seq(
  organization := "com.github.dapeng",
  version := "0.2-SNAPSHOT",
  scalaVersion := "2.12.2"
)

lazy val api = (project in file("consumer-demo-api"))
  .settings(
    commonSettings,
    name := "consumer-demo-api",
    libraryDependencies ++= Seq(
      "com.github.dapeng" % "dapeng-client-netty" % "2.0.5"
    )
  ).enablePlugins(ThriftGeneratorPlugin)


lazy val service = (project in file("consumer-demo-service"))
  .dependsOn(api)
  .settings(
    commonSettings,
    name := "consumer-demo_service",
    libraryDependencies ++= Seq(
      "com.github.dapeng" % "dapeng-spring" % "2.0.5",
      "com.github.wangzaixiang" %% "scala-sql" % "2.0.6",
      "org.slf4j" % "slf4j-api" % "1.7.13",
      // change commons-logging log to slf4j log
      "org.slf4j" % "jcl-over-slf4j" % "1.7.25",
      "ch.qos.logback" % "logback-classic" % "1.1.3",
      "ch.qos.logback" % "logback-core" % "1.1.3",
      "org.codehaus.janino" % "janino" % "2.7.8",
      //event bus
      "com.today" % "event-bus_2.12" % "3.0.0",
      // event api
      "com.today" % "demo-api_2.12" % "2.1.1",
      "mysql" % "mysql-connector-java" % "5.1.36",
      "com.alibaba" % "druid" % "1.0.17",
      "org.springframework" % "spring-context" % "4.3.5.RELEASE",
      "org.springframework" % "spring-tx" % "4.3.5.RELEASE",
      "org.springframework" % "spring-jdbc" % "4.3.5.RELEASE",
    )).enablePlugins(ImageGeneratorPlugin)
  .enablePlugins(DbGeneratePlugin)
  .enablePlugins(RunContainerPlugin)
