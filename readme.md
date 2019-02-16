##Steps to execute

In command line, run the following commands in order:

 `cd src/main/java; start rmiregistry; cd ../../../`

 `sbt "runMain cg_srever/ServerOp"`

This command line will now print output for the server

Open a new command line, and execute

 `sbt "runMain cg_client.ClientOp"`
 

##Author

* Chinmay Gangal