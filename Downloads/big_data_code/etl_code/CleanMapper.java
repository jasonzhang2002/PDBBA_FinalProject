import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, Text, Text> {

    static int ID = 0;
  
    @Override
    public void map(LongWritable key, Text value, Context context)
        throws IOException, InterruptedException {

        String line = value.toString();

        // select required columns
        String [] words = line.split(",");

        String jobTitle = words[3];
        String wage = words[6];
        String year = words[8];
        
        StringBuilder str = new StringBuilder();
        str.append(jobTitle);
        str.append(",");
        str.append(wage);
        str.append(",");
        str.append(year);

        // remove hidden characters
        String val = str.toString().replaceAll("[^A-Za-z0-9,.]", "");


        context.write(new Text(""), new Text(val));
    }
}

