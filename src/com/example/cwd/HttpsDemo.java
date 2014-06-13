package com.example.cwd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.conn.ssl.X509HostnameVerifier;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class HttpsDemo extends Activity{
	SSLContext sslContext;
	String str = "https://dev.97licai.com/api/v1/regions.json";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.d);
		
		
		findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				try {
					
					sslContext = SSLContext.getInstance("TLS");
					sslContext.init(null, new TrustManager[]{new MyTrustManager()}, null);

				
					
					
					
					
					
					
					HttpsURLConnection conn = (HttpsURLConnection) new URL(str).openConnection();
					conn.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
					conn.setDefaultHostnameVerifier(new HostnameVerifier() {
						
						@Override
						public boolean verify(String hostname, SSLSession session) {
							// TODO Auto-generated method stub
							return true;
						}
					});
					
					conn.setRequestMethod("GET");
					 conn.connect();
					 System.out.println("c  " + conn.getResponseCode());
					 BufferedReader br = new BufferedReader(new InputStreamReader(
								conn.getInputStream()));
						String s = "";
						StringBuffer sb = new StringBuffer("");
						while ((s = br.readLine()) != null) {
							sb.append(s).append("\n");
						}
						br.close();
						String response = sb.toString();
					
					
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				/*try {
					InputStream inputStream = HttpClient.sendPOSTRequestForInputStream("https://dev.97licai.com/api/v1/regions.json", null, "utf-8");
					BufferedReader br = new BufferedReader(new InputStreamReader(
							inputStream));
					String s = "";
					StringBuffer sb = new StringBuffer("");
					while ((s = br.readLine()) != null) {
						sb.append(s).append("\n");
					}
					br.close();
					String response = sb.toString();
	System.out.println("rr   " + response);			
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});
	}
	
	
	
	
}
