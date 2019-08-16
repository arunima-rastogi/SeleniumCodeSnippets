package HttpClient;

import java.io.File;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class JIRA_Attachments {
	/**
	 * Attaches given file to Given JIRA Issue
	 * 
	 * Refer:
	 * https://developer.mozilla.org/en-US/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Complete_list_of_MIME_types
	 * for supported MIME Types if You face 415 response code
	 * 
	 * @param args
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httppost = new HttpPost("https://jira-compozed.allstate.com/rest/api/2/issue/FE-146/attachments");
		httppost.setHeader("X-Atlassian-Token", "nocheck");
		httppost.setHeader("Authorization", "Basic c3Jhc3o6amFja2FuZGppbGx3ZW50dXB0aGVoaWxs");

		File fileToUpload = new File("C:\\SRTemp\\sample.txt");
		FileBody fileBody = new FileBody(fileToUpload);

		HttpEntity entity = MultipartEntityBuilder.create().addPart("file", fileBody).build();

		httppost.setEntity(entity);
		String mess = "executing request " + httppost.getRequestLine();

		CloseableHttpResponse response;
		try {
			response = httpclient.execute(httppost);
		} finally {
			httpclient.close();
		}

		if (response.getStatusLine().getStatusCode() == 200)
			System.out.println("Hurray !!  done");
		else
			System.out.println("hmm.. to be done");
	}

}
