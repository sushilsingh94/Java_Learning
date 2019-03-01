import java.io.File;
import java.io.FileInputStream;

public class FileReaderWithResource {

		public static void main(String[] args) {
			File file = new File("D:/data/file.txt");
			try (FileInputStream fis = new FileInputStream(file)){
				System.out.println("Available bytes in file: "+fis.available());
				int line;
				while ((line=fis.read()) != -1) {
					System.out.print((char)line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
