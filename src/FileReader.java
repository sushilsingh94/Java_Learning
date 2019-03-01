import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileReader {
	public static void main(String[] args) {
		File file = null;
		FileInputStream fis = null;
		try {
			file = new File("D:/data/file.txt");
			fis = new FileInputStream(file);
			System.out.println("Available bytes in file: "+fis.available());
			int line;
			while ((line=fis.read()) != -1) {
				System.out.print((char)line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			
		}

	}
}
