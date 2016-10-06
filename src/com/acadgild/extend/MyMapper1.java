package com.acadgild.extend;

import java.io.IOException;

//import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
///import org.apache.hadoop.io.Text;
//import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import com.acadgild.TextPair;

public class MyMapper1 extends Mapper<TextPair,IntWritable,IntWritable,TextPair>{

	public void map(TextPair key,IntWritable value,Context context) throws IOException, InterruptedException{
		TextPair textpair=new TextPair();
		textpair.set(key.getFirst(), key.getSecond(), value);
		//		key.set(key.getFirst(),key.getSecond(),new Text(value));
		context.write(key.getThird(),textpair);
		
	}
}