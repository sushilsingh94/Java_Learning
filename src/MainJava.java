import java.io.FileNotFoundException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class MainJava {
	
	{
		System.out.println("first");
	}

	static{
		System.out.println("second");
	}
	public static void main1(String[] args) {
		MainJava m = new MainJava();
		m.print();
		System.out.println("ada");
		
		
		System.out.println(String.valueOf(null));
	}
	
	public void print(){
		try{
			throw new FileNotFoundException();
		}catch (Exception e) {
			System.out.println("try");
		}finally {
			System.out.println("fin");
		}
	}
	
	
	
	public static void main(String args[]) throws NoSuchAlgorithmException{ 
	     String message = "<abc>ABCDEFG</abc>"; 
	     String keyByte = "key"; 
	     Key key = KeyGenerator.getInstance("Blowfish/ECB/NoPadding").generateKey();
	     byte[] b = encrypt(message.getBytes(), keyByte.getBytes(), key);
	}

	public static byte[] encrypt(byte encrypt[], byte[] en_key, Key keyk) { 
	     try { 
	           SecretKeySpec key = new SecretKeySpec(en_key, "Blowfish"); 
	           Cipher cipher = Cipher.getInstance("Blowfish/ECB/NoPadding"); 
	           cipher.init(Cipher.ENCRYPT_MODE, keyk); 
	           return cipher.doFinal(encrypt); 
	     } catch (Exception e) { 
	           e.printStackTrace();
	           return null; 
	     }
	} 
}
