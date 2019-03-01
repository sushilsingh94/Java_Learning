import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRead {
	
	private static final String FILENAME = "C:\\Day1\\records_file.txt";
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public static void main(String[] args) {
		readFile(FILENAME);
	}
	public static void readFile(String file){
		 Pattern regexp = Pattern.compile(" -");
		    Matcher matcher = regexp.matcher("");
		    LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

		    Path path = Paths.get(FILENAME);
		    try (
		      BufferedReader reader = Files.newBufferedReader(path, ENCODING);
		      LineNumberReader lineReader = new LineNumberReader(reader);
		    ){
		      String line = null;
		      while ((line = lineReader.readLine()) != null) {
		        String[] strArray = line.split(" -");
		        int count = map.get(strArray[0])+1;
		        map.put(strArray[0], count);
		      }      
		    }    
		    catch (IOException ex){
		      ex.printStackTrace();
		    }
		}

}
