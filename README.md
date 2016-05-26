# Scala Lambda Example
AWS Lambda **Hello World!** in Scala with properties loaded from file. 
Demonstrates the usage of https://github.com/gilt/sbt-aws-lambda.

# Setup

Move the `lambda.properties.example` to `lambda.properties` and fill in your values.
The S3 Bucket must already exist in the AWS region or you will get `403` errors during deploy.

# Deploy

    sbt createLambda
    
# Test
    > aws lambda invoke --function-name "helloFn" output
    {
        "StatusCode": 200
    }
    > cat output
    "Hello Lambda"

Or use the test interface in the AWS web console: https://eu-central-1.console.aws.amazon.com/lambda (adjust to your deploy region).

# Notes
You should be aware that only `Java`-Types will work in the signature of your lambda if you want to use the built-in serialization.
Details: https://aws.amazon.com/blogs/compute/writing-aws-lambda-functions-in-scala/
