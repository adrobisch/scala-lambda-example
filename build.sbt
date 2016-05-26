enablePlugins(AwsLambdaPlugin)

name := "lambda-test"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.8"

retrieveManaged := true

val lambdaProperties = settingKey[java.util.Properties]("lambda properties")

lambdaProperties := {
  val prop = new java.util.Properties()
  IO.load(prop, new File("lambda.properties"))
  prop
}

lambdaHandlers := Seq(
  "helloFn" -> "com.drobisch.lambda.LambdaTest::hello"
)

s3Bucket := Some(lambdaProperties.value.getProperty("s3.bucket"))

awsLambdaMemory := Some(192)

awsLambdaTimeout := Some(30)

roleArn := Some(lambdaProperties.value.getProperty("role.arn"))

region := Some(lambdaProperties.value.getProperty("region"))
