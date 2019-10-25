package app;

import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World");
        App app = new App();
        app.csvToSql();
    }

    // Main calling funtion
    public void csvToSql() {
        getCvsFlie();
        System.out.println("start up test");
    }

    // Get CSV file and test for correct file type
    public void getCvsFlie() {
        final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        fc.setFileFilter(new FileNameExtensionFilter("CSV file", "csv"));
        int returnVal = fc.showOpenDialog(null);
        System.out.println("get csv file test " + returnVal);
        // Due to lack of time as a result of a family issue this is as far as I got but
        // I will discribe the path I was going to take from here.
    }

    // Consume and store data from CSV file

    // Here I was going to create an array of objects from the CSV file and send it
    // to the next section for testing

    // Test data for correct file type

    // Here I was going to loop through the array of objects sent here and create 2
    // new arrays of objects for transfer(good data and bad data)

    // Connect and disconnect to/from the server

    // Here I going to set up a connection to the server then send the data to 2
    // tables on the server and the when a responce is sent back
    // close the connection

    // Add data to server

    // This is is where the 2 arrays of data would be sent after a connection is
    // made and transfers to the sql tables and then sending a complete message
    // back to the last method.

}
