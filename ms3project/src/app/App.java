package app;

import java.io.*;
import java.io.File;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;

public class App {

    public static void main(String [] args) {
        App app = new App();
        app.csvToSql();
    }

    // Main calling funtion
    public void csvToSql() {
        getCsvFlie();
    }

    // Get CSV file and test for correct file type
    public void getCsvFlie() {
        final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fc.setFileFilter(new FileNameExtensionFilter("CSV file", "csv"));
        int returnVal = fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        String filePath = file.toString();
        String fileName = fc.getName(file);
        int pos = fileName.lastIndexOf(".");
        if (pos > 0){
            fileName = fileName.substring(0, pos);
        }
        csvToList(filePath, fileName);

    }

    // Consume and store data from CSV file in arrays and get metadata
    public void csvToList(String filePath, String fileName) {
        List<String[]> goodData = new ArrayList<>();
        List<String> badData = new ArrayList<>();
        Path path = Paths.get(filePath);
        boolean isFirstLine = true;

        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

            // read the first line from the text file
            String line = br.readLine();
            
            // loop until all lines are read
            while (line != null) {
                
                // skip first line lables row
                if (isFirstLine) {
                    isFirstLine = false;
                    line = br.readLine();
                    continue;
                }

                // use string.split to load a string array with the values from
                // each line of
                // the file, using a comma as the delimiter
                String[] attributes = line.split(",");

                // testing for empty strings to separate good data from bad
                boolean isGoodRow = true;
                for (String s : attributes) {
                    if (s.length() == 0) {
                        isGoodRow = false;
                    }
                }
                if (isGoodRow) {
                    goodData.add(attributes);
                }else {
                    badData.add(line);
                    isGoodRow = true;
                }


                // read next line before looping
                // if end of file reached, line would be null
                // and tally number of rows
                line = br.readLine();
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        GoodDataToDatabase(goodData, fileName);
        
        BadDataToCSVFile(badData, fileName);
        
        CreateLogFile(goodData.size(), badData.size(), fileName);

    }

    // Here I going to set up a connection to the server then send good data
    // I am leaving this section as is since I am unsure of how to complete it and 
    // I think it will take to long for me to learn it on my own.
    public void GoodDataToDatabase(List goodData, String fileName){
        // open connection
        
        //enter data
        
        // close connection
        
    }
    

    // Create bad data csv file
    public void BadDataToCSVFile(List badData, String fileName){
        try(FileWriter fw = new FileWriter(fileName + "-bad.csv")){
            for(var row : badData){
                fw.write(row.toString());
                fw.append("\n");
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // Create log file
    public void CreateLogFile(int good, int bad, String fileName){
        try(FileWriter fw = new FileWriter(fileName + ".log")){
        
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("# of records received: " + (good + bad));
            bw.newLine();
            bw.write("# of records successful: " + good);
            bw.newLine();
            bw.write("# of records failed: " + bad);
            bw.close();
        
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
