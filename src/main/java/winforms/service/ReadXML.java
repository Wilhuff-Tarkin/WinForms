package winforms.service;

import winforms.model.Entry;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class ReadXML {

//    private static final Pattern a = Pattern.compile("<value a=„" + "\\d+" + "” values=„ " + "\\d+" + "”/>");
   // private static final Pattern a = compile("<value a=");
    private static final Pattern values = compile(".*„(\\d+)”.*„(\\d+)”.*");




    public static List <Entry> readXML(String path) {

        List<Entry> list = new LinkedList<>();

          try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream(path);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                Matcher matchForValues = values.matcher(strLine);

                if (matchForValues.find()) {
                    System.out.println(strLine);
                    int a = Integer.parseInt(matchForValues.group(1));
                    int b = Integer.parseInt(matchForValues.group(2));

                    Entry entry = new Entry(a, b);
                    list.add(entry);
                }

            }


            for (Entry e : list){
                System.out.println("e = " + e);
            }


              //Close the input stream
              in.close();
          } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            String hint = "Error: " + e.getMessage();
          }

          return list;
    }




}

