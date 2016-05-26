<h2>219351 Web application Homework<h2>
<h3>tool version (Run on Mac OSX El Capitan)<h3>

    java version "1.8.0_40"
    Java(TM) SE Runtime Environment (build 1.8.0_40-b27)
    Java HotSpot(TM) 64-Bit Server VM (build 25.40-b25, mixed mode)

    Hadoop 2.7.0
    Subversion https://git-wip-us.apache.org/repos/asf/hadoop.git -r d4c8d4d4d203c934e8074b31289a28724c0842cf
    Compiled by jenkins on 2015-04-10T18:40Z
    Compiled with protoc 2.5.0
    From source with checksum a9e90912c37a35c3195d23951fd18f
    This command was run using /usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/common/hadoop-common-2.7.0.jar

    Apache Pig version 0.15.0 (r1682971) 
    compiled Jun 01 2015, 11:44:35

HW3
    
    Compile&run bubble_sort_mpi.c
        1.$ mpicc bubble_sort_mpi.c -o bubbleSortMpi
        2.1 $ mpiexec -np 2 ./bubbleSortMpi
        2.2 $ mpiexec -np 4 ./bubbleSortMpi
        
HW5
    
    Ex5_LinkCount_SQ 
        
        Run on Elipse
        
    Ex6_LinkCount_MR
        
        Compile JAVA
            $javac LinkCount.java -cp /usr/local/Cellar/hadoop/2.7.0/libexec/etc/hadoop:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/common/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/common/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/hdfs:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/hdfs/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/hdfs/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/yarn/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/yarn/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/mapreduce/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/mapreduce/*:/contrib/capacity-scheduler/*.jar
        Create Jar
            $jar cf LinkCount.jar LinkCount*.class
        Run Hadoop
            $hadoop jar LinkCount.jar LinkCount web-Google.txt LCoutput
    
    Ex7_Neighbor_SQ
        
        Run on Elipse

    Ex8_Neighbor_MR
        
        Compile JAVA
            $javac Neighbor.java -cp /usr/local/Cellar/hadoop/2.7.0/libexec/etc/hadoop:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/common/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/common/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/hdfs:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/hdfs/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/hdfs/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/yarn/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/yarn/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/mapreduce/lib/*:/usr/local/Cellar/hadoop/2.7.0/libexec/share/hadoop/mapreduce/*:/contrib/capacity-scheduler/*.jar
        Create Jar
            $jar cf Neighbor.jar Neighbor*.class
        Run Hadoop
            $hadoop jar Neighbor.jar Neighbor web-Google.txt Ex8-output1 Ex8-output2

HW6

    Ex4_LinkCountPig
        Compile&run linkCount.pig
        
            1.$pig -x local linkcount.pig 

    Ex5_NeighborCountPig
        Compile&run neighbor.pig
            
            2.$pig -x local neighbor.pig 


Result run times
   
    LinkCount
        Sequence program: 4.70s
        MapReduce program: 47.02s
        Pig: 29.25s
    Neighbor
        Sequence program: 24.53s
        MapReduce program: 4m 32s
        Pig: 7m 24s


