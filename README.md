Directory Descriptions:

1) /ana_code:

Directory containing .java, .class, and .jar files related to the analytics of the project (ie. Finding average salaries)

2) /data_ingest:

Directory containing original obtained from https://dataportal.mt.gov/t/DOASITSDDataPortalPub/views/SABHRSStateEmployeeData/EmployeeDataDashboard?%3Aembed=y&%3AshowAppBanner=false&%3AshowShareOptions=true&%3Adisplay_count=no&%3AshowVizHome=no. Downloaded by simply clicking download with proper filters.

Original Dataset has schema:\n
Department: String
Last Name: String
First Name: String
Position: String
City: String
Base Salary: Double
Total Salary: Double
Payment Rate: String
Year: Int
County: String
Cre By: String
Cre Dt: String
Employee ID: String
First Name: String
Last Name: String
Middle Name: String
Mod By: String
Mod Date: String
Number of Records: Int


3) /etl_code

Directory containing .java, .class, and .jar files used to clean the Employee_Dataset.csv file, (ie Removing unwanted columns).

4) /profiling_code

Directory containing .java, .class, and .jar files used to basic data profiling (only used the CountRecs MR job which was assigned as a homework assignment)

5) /screenshots

Directory containing screenshots of all MR job summaries and outputs. Files are labeled X_Y_ptZ, where X is the MR job associated with the file, Y indicates whether the pictures are job summaries or outputs. Since summaries are long, they are divided into multiple parts and Z indicates which part of the job summary the pictures is associated with.

6) /test_code

Directory with one file, test.java, which was the file used to determine that my original input files contained hidden characters and needed to be removed in the cleaning process.

Step by step:

All .class and .jar files are already built so step by step instructions detail the flow in which we must process the data.

Our goal is to perform some basic analysis on teacher and board of education member salaries in Montana from 2011 to 2021.

Things to note: 

netId refers to your NYU netId


1) Cleaning the Data:

We first must remove unwanted columns, leaving the new schema:

Job title: String
Salary: Double 
Year: Int

To clean the data, navigate to the /etl_code directory then run the command:

hadoop jar clean.jar Clean Employee_Dataset.csv /user/<netID>/CleanDataset/output

If you wish to see the cleaned dataset, you can run the commands:

hdfs dfs -get CleanDataset/output 
cat output/part-r-00000

2) Profiling the Data:

We then can profile our data, checking how many lines remain after the initial cleaning.

To profile the data, navigate to the /profiling_code directory then run the command:

hadoop jar countRecs.jar CountRecs /user/<netID>/CleanDataset/output/part-r-00000 /user/<netID>/ProfileDataset/output

If you wish to see how many records there are, you can run the commands:

hdfs dfs -get ProfileDataset/output 
cat output/part-r-00000

3) Analyzing the Data

After cleaning and profiling, we can now analyze our data. These files analyze our data in two way, tracking how average teacher salaries change and how average board of education member salaries change.

To analyze the average teacher salary, navigate to the /ana_code directory then run the command:

hadoop jar averageTeacherSalary.jar AverageTeacherSalary /user/<netID>/CleanDataset/output/part-r-00000 /user/<netID>/AverageTeacherSalary/output

If you wish to see the average teacher salary throughout the years, you can run the commands:

hdfs dfs -get AverageTeacherSalary/output 
cat output/part-r-00000

To analyze the average board of education member salary, navigate to the /ana_code directory then run the command:

hadoop jar averageTeacherSalary.jar AverageTeacherSalary /user/<netID>/CleanDataset/output/part-r-00000 /user/<netID>/AverageTeacherSalary/output

If you wish to see the average teacher salary throughout the years, you can run the commands:

hdfs dfs -get AverageTeacherSalary/output 
cat output/part-r-00000

After completing this step, we have finished our step-by-step guide to analyzing education spending in Montana.
