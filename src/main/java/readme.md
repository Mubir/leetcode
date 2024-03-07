Build and run::
Target jdk java 21
1. change directory to
woven/src/main/java
 cd path_to_woven/woven/src/main/java
2. compile the code:
    javac Calculate.java
3. build jar by running the following command:
     jar cvfm task.jar mymanifest.txt Calculate.class
4. once build run the following command to execute the program: 
during run put input.txt and jar file on same folder.
you pass the file as a 1st argument.
    java -jar task.jar input.txt 3

---------------------------------------------------------------
To make container out of the jar:
   
1. run this command to build the image::
   docker build -t task-image .
   # now this "task-image" image can be deployed in production.
2. run the container on detached mode:
    docker run --name test -it --rm task-image  /bin/bash
3. run this command to run program from inside container
    java -jar task.jar input.txt 3