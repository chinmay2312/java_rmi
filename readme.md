##Steps to execute

In command line, run the following commands:

    sbt clean
    sbt compile
    sbt "runMain cg_server.ServerOp"

This command line will now print output for the server

Open a new command line, and execute

 `sbt "runMain cg_client.ClientOp"`
 
 To run tests:
 
 `sbt test`
 
##Author

* Chinmay Gangal