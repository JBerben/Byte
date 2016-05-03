import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Converter {
	
	public static String newLine = System.getProperty("line.seperator");
	//private static String fileFolder = "C:/Users/Josh/Desktop/Test";
	//private static int lineNumber;
	//private static String fileName = "C:/Users/Josh/Desktop/Test/Byte.txt";
	
	//These are the different characters
	private static String enter = "Ù";
	private static String notEqual = "È";
	private static String assign = "ã";
	private static String lessEqual = "É";
	private static String moreEqual = "Ê";
	private static String radius = "ª";
	private static String theta = "ä";
	private static String shortIf = "×";
	private static String xMark = "·!·";
	
	public static void main(String args[]) {
		
	}
	
	public static void Replace() {
		try
        {
        File file = new File(GUI.fileDirectory);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "", oldtext = "";
        while((line = reader.readLine()) != null)
            {
            oldtext += line + "\r\n";
            

        }
        FileWriter writer = new FileWriter(GUI.fileDirectory);
        oldtext = oldtext.replaceAll(assign, "->");
        oldtext = oldtext.replaceAll(enter, "");
        oldtext = oldtext.replaceAll(notEqual, "!=");
        oldtext = oldtext.replaceAll(lessEqual, "<=");
        oldtext = oldtext.replaceAll(xMark, "!");
        oldtext = oldtext.replaceAll(shortIf, ">>>");
        oldtext = oldtext.replaceAll(radius, "r");
        oldtext = oldtext.replaceAll(theta, "THETA");
        oldtext = oldtext.replaceAll(moreEqual, ">=");
        
        writer.write(oldtext); 
        reader.close();
        writer.close();
    }
    catch (IOException ioe)
        {
        ioe.printStackTrace();
    }
	}
}

    