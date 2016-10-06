package com.acadgild;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
 
@SuppressWarnings("rawtypes")
public class TextPair implements WritableComparable {
 
    private Text first;
    private Text second;
    private IntWritable third;
 
    public TextPair(Text first, Text second,IntWritable third) {
        set(first, second,third);
    }
   

	public TextPair() {
        set(new Text(), new Text(),new IntWritable());
    }
   

	public TextPair(String first, String second,IntWritable third) {
        set(new Text(first), new Text(second),new IntWritable());
    }
 
    public Text getFirst() {
        return first;
    }
 
    public Text getSecond() {
        return second;
    }
    public IntWritable getThird() {
        return third;
    }
 
    public void set(Text first, Text second,IntWritable third) {
        this.first = first;
        this.second = second;
        this.third=third;
    }
 
    @Override
    public void readFields(DataInput in) throws IOException {
        first.readFields(in);
        second.readFields(in);
        third.readFields(in);
    }
 
    @Override
    public void write(DataOutput out) throws IOException {
        first.write(out);
        second.write(out);
        third.write(out);
    }
 
    @Override
    public String toString() {
        return first + " " + second+ " " + third;
    }
 
    @Override
    public int compareTo(Object o) {
		
    	TextPair tp = (TextPair) o;
        int cmp = first.compareTo(tp.first);
        int cmp1=second.compareTo(tp.second);
        
        if (cmp != 0) {
            return cmp;
        }
        if(cmp1!=0){
        	return cmp1;
        }
 
        return third.compareTo(tp.third);
    }
 
   
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof TextPair)
        {
            TextPair tp = (TextPair) o;
            return first.equals(tp.first) && second.equals(tp.second) && third.equals(tp.third);
        }
        return false;
    }

}