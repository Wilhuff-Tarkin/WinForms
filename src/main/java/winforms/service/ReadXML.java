package winforms.service;

import winforms.controller.RootController;
import winforms.model.Entry;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadXML {

//    private static final Pattern a = Pattern.compile("<value a=„" + "\\d+" + "” b=„ " + "\\d+" + "”/>");
    private static final Pattern a = Pattern.compile("<value a=");
    private static final Pattern b = Pattern.compile(".*„(\\d+)”/„(\\d+)”.*");

//TODO dopracowac regex, pobrac dane, stworzyc obiekty i dodac je do listy albo stosu

    public static String readXML(String path) {

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
                Matcher matchForA = b.matcher(strLine);

                if (matchForA.find()) {
                    System.out.println(strLine);


                }

            }
              //Close the input stream
              in.close();
          } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            String hint = "Error: " + e.getMessage();
            return hint;
        }
        return "all good";
    }

}

