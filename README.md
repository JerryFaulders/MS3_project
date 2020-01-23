# MS3_project
Code Challenge for MS3

Create a java app that can consume a CSV file, test to see if and rows of data are missing anything, then transfer the good data to an sql file, transfer the bad data to andother csv file, and create a metadata file.

When this  file is run from the IDE it completes 2 out of the 3 goals mentioned above. It creates a metadata log file and a bad data csv file. When it is completed it will also enter the good data to a sql table. When run it will name these files after the initial csv file.

When starting this task I seperated it up into smaller goals. First I set up a file finder with a filter on it to only be able to find csv files. Then I worked on extractin data from the chosen file. I then set up a testing loop to seperate good data from bad as well as skipping over the first line of data (data labels). Then I created tracking variables to keep track of the good data vs the bad data to be used later for making the metadata file. I then set up the metadata file creating method as well as the bad data csv file making method. I went back afterwards to set smaller details up such as properly naming the created files. All throughout the process I set up test strings to make sure the correct data was going to the correct places and later went back and deleted them. I go by the school of thought that one should code a little and test a lot.

Lastly I would like to appologize for the amount of time it has taken me to complete this task. I have been dealing with some family issues and have only fould time to work in between dealing with these events. I hope you understand and I look forward to working with MS3 in the future.

Jerry Faulders
