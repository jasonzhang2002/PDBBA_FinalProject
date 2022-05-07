// AverageBoardSalary runs MR job which computes the average salary
// of board of education members for each year in the dataset

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.DoubleWritable;
public class AverageBoardSalary {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Usage: AverageSalary <input path> <output path>");
            System.exit(-1);
        }
        
        Job job = new Job();
        job.setJarByClass(AverageBoardSalary.class);
        job.setJobName("Average Salary");

        job.setNumReduceTasks(1);
    
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        
        job.setMapperClass(AverageBoardSalaryMapper.class);
    
        job.setReducerClass(AverageBoardSalaryReducer.class);

        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(DoubleWritable.class);
        
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
