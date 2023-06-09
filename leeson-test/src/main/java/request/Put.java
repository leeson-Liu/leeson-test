package request;

import com.google.common.net.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author liubin
 * @create 2020-09-09 17:23
 * @desc
 **/
@Slf4j
public class Put {
    public static void main(String[] args) throws IOException {
        String jsonString = "{\n" +
                "    \"user\": \"liubin\",\n" +
                "    \"phone\": \"17615832136\"\n" +
                "}";
        String result = put(1L, jsonString);
        System.out.println(result);
    }

    public static String put(Long id, String JSONBody) throws IOException {
        HttpPut httpPut = new HttpPut("http://localhost:9200/test/test/" + id);
        httpPut.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpPut.setEntity(new StringEntity(JSONBody));


        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = httpClient.execute(httpPut);
        HttpEntity entity = httpResponse.getEntity();
        String responseContent = EntityUtils.toString(entity, "UTF-8");
//		System.out.println(responseContent);
        httpResponse.close();
        httpClient.close();
        return responseContent;

    }

}
