name := "Chinmay_Gangal_hw3"

version := "0.1"

unmanagedSourceDirectories in Compile := (javaSource in Compile).value :: Nil

//libraryDependencies += "junit" % "junit" % "4.11" % Test
javacOptions += "-g:none"

libraryDependencies += "junit" % "junit" % "4.12" % Test 
libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test->default"