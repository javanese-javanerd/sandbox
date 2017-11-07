package Quizzes;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Http404Test {

	/**
	 * Exhibit how to handle 404 error code properly.
	 * 
	 * @param args
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws MalformedURLException, IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL("http://www.google.com/nohelp").openConnection();
		if (connection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
		    System.out.println("Page not found");
		}
	}
}
