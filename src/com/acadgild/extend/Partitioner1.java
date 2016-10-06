package com.acadgild.extend;

//import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

import com.acadgild.TextPair;

public class Partitioner1 extends Partitioner<IntWritable, TextPair> {

	@Override
	public int getPartition(IntWritable key, TextPair values, int numPartitions) {
	if(values.getFirst().equals(new Text("Samsung"))){
		return 0;
		
	}
	else if(values.getFirst().equals(new Text("Onida"))){
		return 1;
	}
	else if(values.getFirst().equals(new Text("Akai"))){
		return 2;
		
	}else if (values.getFirst().equals(new Text("Lava"))){
		return 3;
	}else {
		return 4;
	}
			
	}

}