package com.tibco.bw;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPClient4 {
	public static void main(String[] args) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        int i=0;
        try {
            HttpGet httpGet = new HttpGet("http://localhost:4444");
            while(i<100000) {
            CloseableHttpResponse response1 = httpclient.execute(httpGet);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity1 = response1.getEntity();
                // do something useful with the response body
                // and ensure it is fully consumed
                System.out.println(i);
                EntityUtils.consume(entity1);
            i++;
           } finally {
                response1.close();
            }
        } 
        }
        finally {
            httpclient.close();
        }
    }
}