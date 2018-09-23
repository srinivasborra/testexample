package com.qa.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient {
	
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		return httpResponse;
	}
	
	public CloseableHttpResponse post(String url, String entityPayload, HashMap<String,String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new StringEntity(entityPayload));
		for(Map.Entry<String, String> entrySet: headerMap.entrySet()){
			httpPost.addHeader(entrySet.getKey(),entrySet.getValue());
		}
		CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
		return httpResponse;
	}
	
//	public void get(String url) throws ClientProtocolException, IOException{
//		CloseableHttpClient httpClient = HttpClients.createDefault();
//		HttpGet httpGet = new HttpGet(url);
//		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
//		int statusCode = httpResponse.getStatusLine().getStatusCode();
//		System.out.println("Status Code="+statusCode);
//		
//		String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
//		JSONObject responseJson = new JSONObject(responseString);
//		System.out.println("JSON Response:"+responseJson.toString());
//		
//		Header[] headers =httpResponse.getAllHeaders();
//		
//		HashMap<String,String> allHeaders = new HashMap<String,String>();
//		
//		for(Header header : headers){
//			allHeaders.put(header.getName(), header.getValue());
//		}
//		System.out.println("Headers:"+allHeaders);
//	}
}
