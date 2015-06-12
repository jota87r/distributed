export HADOOP_HOME=/opt/hadoop-2.7.0
$HADOOP_HOME/bin/hdfs namenode -format
{
    $HADOOP_HOME/bin/hdfs dfs -rmr /user
} || {}
$HADOOP_HOME/bin/hdfs dfs -mkdir /user
$HADOOP_HOME/bin/hdfs dfs -mkdir /user/root
$HADOOP_HOME/bin/hdfs dfs -put input dist_input
time $HADOOP_HOME/bin/hadoop jar base-1.0-SNAPSHOT.jar com.j.distributed.Main dist_input dist_intermediate dist_output "$1"
printf "\nLas lineas anteriores son el tiempo de ejecucion del programa distribuido."
printf "\n\nEste es el resultado (Lista de cantidad de ocurrencias y archivo):\n\n"
$HADOOP_HOME/bin/hdfs dfs -cat dist_output/*
printf "\n"
