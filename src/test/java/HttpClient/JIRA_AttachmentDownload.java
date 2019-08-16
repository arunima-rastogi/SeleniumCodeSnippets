package HttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class JIRA_AttachmentDownload {

	public static void main(String[] args) throws IOException {

		String contentURI = "https://jira-compozed.allstate.com/secure/attachment/326682/sample.txt"; // This is the URL
																										// to download
																										// Attachment
		String fullfilename = "C:\\SRTemp\\sample.txt"; // Where to download the attachment
		CloseableHttpClient httpclient = HttpClients.createDefault();

		try {
			HttpGet httpget = new HttpGet(contentURI);
			httpget.setHeader("Authorization", "Basic c3Jhc3o6amFja2FuZGppbGx3ZW50dXB0aGVoaWxs");

			System.out.println("executing request " + httpget.getURI());

			CloseableHttpResponse response = httpclient.execute(httpget);

			int status = response.getStatusLine().getStatusCode();
			if (status >= 200 && status <= 300) {
				HttpEntity entity = response.getEntity();
				if (entity.isStreaming()) {
					byte data[] = EntityUtils.toByteArray(entity);
					FileOutputStream fout = new FileOutputStream(new File(fullfilename));
					fout.write(data);
					fout.close();
				}
			}
		} finally {
			httpclient.close();
		}

	}
}
