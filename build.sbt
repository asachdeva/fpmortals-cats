inThisBuild(
  Seq(
    scalaVersion := "2.12.1",
    scalaOrganization := "org.typelevel",
    sonatypeGithub := ("fommil", "drone-dynamic-agents"),
    licenses := Seq(Apache2)
  )
)

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % "0.7.0") ++ Seq(
  "org.typelevel" %% "cats" % "0.9.0",
  "com.spinoco" %% "fs2-http" % "0.1.6"
)

scalacOptions ++= Seq(
  "-Ywarn-value-discard",
  "-Ywarn-numeric-widen",
  "-language:higherKinds",
  // https://github.com/typelevel/scala/blob/typelevel-readme/notes/2.12.1.md
  "-Ykind-polymorphism",
  "-Ypartial-unification",
  "-Yinduction-heuristics",
  "-Yliteral-types",
  "-Xstrict-patmat-analysis",
  "-Ysysdef", Seq(
    "java.lang.String",
    "scala.{Any,AnyRef,AnyVal,Boolean,Byte,Double,Float,Short,Int,Long,Char,Unit,Null,Nothing,Option,Some,None,Either,Left,Right}",
    "scala.annotation.{tailrec,inductive}",
    "scala.collection.immutable.{Map,Seq,List,::,Nil,Set,Vector}",
    "scala.util.{Try,Success,Failure}",
    "scala.Predef.{???,ArrowAssoc,identity,<:<,=:=}", // prefer `the` to `implicitly`
    "cats._,cats.data.{Coproduct=>CoproductK,Product=>ProductK,_},cats.implicits._",
    "freestyle._,freestyle.implicits._",
    "shapeless.{::=>#:,_}",
    "fs2._"
  ).mkString(","),
  "-Ypredef", "_"
)

// http://frees.io/docs/
resolvers += Resolver.sonatypeRepo("snapshots")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
libraryDependencies += "com.47deg" %% "freestyle" % "0.1.0-SNAPSHOT"
