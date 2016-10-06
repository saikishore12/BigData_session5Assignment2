package com.acadgild;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,TextPair,IntWritable>{

	//private static Text lastWord = null;
    private static TextPair textPair = new TextPair();
   // private static Text wordText = new Text();
	public void map(LongWritable key,Text value,Context context) throws IOException, InterruptedException{
	
		String line=value.toString();
		String[] st=line.split("\n");
	
		for(int i=0;i<st.length;i++){
			String[] st1=st[i].split("\\|");
					IntWritable inches=new IntWritable(Integer.parseInt(st1[2]));
	              textPair.set(new Text(st1[0]), new Text(st1[3]),inches);
	              context.write(textPair, new IntWritable(1));
	                
	            
			
			
			}
	}
}