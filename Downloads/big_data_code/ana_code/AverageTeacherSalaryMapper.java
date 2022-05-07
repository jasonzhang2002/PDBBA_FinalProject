import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.DoubleWritable;

public class AverageTeacherSalaryMapper extends Mapper<LongWritable, Text, IntWritable, DoubleWritable> {
   
  @Override
  public void map(LongWritable key, Text value, Context context)
      throws IOException, InterruptedException {

        String line = value.toString();
	String [] words = line.split(",");
        
        // schema is :role, salary (per hour), year
        
        // select line if role is teacher        
	String role = words[0].toLowerCase();
        
	if (role.contains("teacher")){
	    Double salary = Double.parseDouble(words[1]);
            int year = Integer.parseInt(words[2]); 
	    context.write(new IntWritable(year), new DoubleWritable(salary));
	}
    }
}
