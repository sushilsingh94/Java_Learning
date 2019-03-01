import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class FileDownloaderClient {
	
	public static void main(String[] args) {
		dowloadFileFromLocation("http://www.acharyaviren.com/musicArchive/sarveshaam_a201702.mp3", "C:\\Day1\\sarveshaam_a201702.mp3");
		//download("http://www.acharyaviren.com/musicArchive/sarveshaam_a201702.mp3", "C:\\Day1\\");
	}
	
	static boolean dowloadFileFromLocation(String url, String path){

        try {

            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(path);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return false;
	}
	
	
	/*public String executeGet(){ //If you want to use get method to hit server

        httpClient httpClient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        String result = null;
        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            result = httpClient.execute(httpget, responseHandler);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }*/
	
	static void download(String url, String path){
		try{
			URLConnection conn = new URL(url).openConnection();
			InputStream is = conn.getInputStream();

			OutputStream outstream = new FileOutputStream(new File(path));
			byte[] buffer = new byte[4096];
			int len;
			while ((len = is.read(buffer)) > 0) {
				outstream.write(buffer, 0, len);
			}
			outstream.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
