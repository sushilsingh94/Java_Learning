
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ExecuteShellComand {

	public static void main(String[] args) {
		System.out.println("Application Started...");
		boolean exit = false;
		while(!exit){
			Scanner sc = new Scanner(System.in);
			String comm = sc.nextLine();
			
			if("exit".equals(comm)){
				exit = true;
				System.exit(0);
			}
	
			String output = executeCommand(comm);
	
			System.out.println(output);
		}
	}

	private static String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		try {
			p = Runtime.getRuntime().exec(new String[] { "bash", "-c", command });
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			System.out.println("ERR: CANNOT RECOGNIZE INPUT");
		}

		return output.toString();
	}

}
