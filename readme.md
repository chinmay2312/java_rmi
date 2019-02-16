## CS441-Cloud: Homework 3
JavaRMI Framework implementation

Objective: Verfiying that Referential Integrity property holds

If 2 objects with the same reference on client are sent to server, then they will still hold the same reference

##Prerequisites
* Java
* SBT  

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