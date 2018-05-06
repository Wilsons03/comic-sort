package studentsort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
 
//Student Class
 //http://javaconceptoftheday.com/how-to-sort-a-text-file-in-java/
class comicType
{
    int volume;
    String title;
    String genre;
     
    int price;
     
    public comicType(int volume,String title,String genre,int price) 
    {
        this.volume = volume;
        this.title = title;
        this.genre= genre;
        this.price = price;
    }
}
 
//nameCompare Class to compare the names
class volumeCompare implements Comparator<comicType>
{
    @Override
    public int compare(comicType s1, comicType s2)
    {
        return s2.volume - s1.volume;
    }
}
 
class titleCompare implements Comparator<comicType>
{
    @Override
    public int compare(comicType s1, comicType s2)
    {
        return s1.title.compareTo(s2.title);
    }
}
class genreCompare implements Comparator<comicType>
{
    @Override
    public int compare(comicType s1, comicType s2)
    {
        return s1.genre.compareTo(s2.genre);
    }
}
 
//marksCompare Class to compare the marks
 
class priceCompare implements Comparator<comicType>
{
    @Override
    public int compare(comicType s1, comicType s2)
    {
        return s2.price - s1.price;
    }
}
 
public class SortTextFile
{
    public static void main(String[] args)throws IOException
    {
        //Creating BufferedReader object to read the input text file
         
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
         
        //Creating ArrayList to hold Student objects
         
        ArrayList<comicType> comicRecords = new ArrayList<comicType>();
         
        //Reading Student records one by one
         
        String currentLine = reader.readLine();
         
        while (currentLine != null)
        {
            String[] comicDetail = currentLine.split(" ");
            
            int volume = Integer.valueOf(comicDetail[1]);
            String title = comicDetail[0];
            String genre = comicDetail[0];
             
            int price = Integer.valueOf(comicDetail[1]);
         
            //Creating Student object for every student record and adding it to ArrayList
             
            comicRecords.add(new comicType(volume, title, genre, price));
             
            currentLine = reader.readLine();
        }
         
        //Sorting ArrayList studentRecords based on marks
         
        Collections.sort(comicRecords, new priceCompare());
         
        //Creating BufferedWriter object to write into output text file
         
        BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"));
         
        //Writing every studentRecords into output text file
         
        for (comicType comic : comicRecords) 
        {
           // writer.write(comic.volume);
             
            writer.write(comic.volume+" "+comic.title+" "+comic.genre+" "+comic.price);
             
            writer.newLine();
        }
         
        //Closing the resources
         
        reader.close();
         
        writer.close();
    }
}