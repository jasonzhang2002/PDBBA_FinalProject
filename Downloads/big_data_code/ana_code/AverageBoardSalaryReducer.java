import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.DoubleWritable;
public class AverageBoardSalaryReducer
    extends Reducer<IntWritable, DoubleWritable, IntWritable, DoubleWritable> {
  
    @Override
    public void reduce(IntWritable key, Iterable<DoubleWritable> values, Context context)
        throws IOException, InterruptedException {
    
        double sum = 0;
        int records = 0;
        for (DoubleWritable value : values)
        {
            sum += value.get();
            records++;
        }
        double averageSalary = sum/records;
        context.write(key, new DoubleWritable(averageSalary));
    }
}
