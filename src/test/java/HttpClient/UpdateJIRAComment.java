package HttpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class UpdateJIRAComment {
	public static void main(String[] args) {
		try {
			UpdateJIRAComment.call_me();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void call_me() throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build();

		HttpPost request = new HttpPost("https://jira-compozed.allstate.com/rest/api/2/issue/FE-143/comment");
		// payload
		StringEntity params = new StringEntity("{\"body\": \"Demo for team--.\"}");

		request.addHeader("content-type", "application/json");
		request.addHeader("User-Agent", "Mozilla/5.0");
		request.addHeader("Authorization", "Basic c3Jhc3o6amFja2FuZGppbGx3ZW50dXB0aGVoaWxs");
		request.addHeader("Accept", "application/json");
		request.addHeader("X-Atlassian-Token", "nocheck");
		request.setEntity(params);

		HttpResponse response = httpClient.execute(request);
		System.out.println(response.toString());

	}
}