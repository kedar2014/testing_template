package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

public class HTTPSHelper {
	
	
	public static org.apache.http.conn.ssl.SSLSocketFactory getSSLSocketFactory() {
		org.apache.http.conn.ssl.SSLSocketFactory sslsf = null;
		try
		{
		KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
		File ksFile = new File(System.getProperty("javax.net.ssl.keyStore"));
		FileInputStream in = new FileInputStream(ksFile);
		ks.load(in, System.getProperty("javax.net.ssl.keyStorePassword").toCharArray());
		
		
		KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(ks, System.getProperty("javax.net.ssl.keyStorePassword").toCharArray());
        KeyManager[] kms = kmf.getKeyManagers();
        
        
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(new FileInputStream(System.getProperty("javax.net.ssl.trustStore")), "changeit".toCharArray());
		
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);
        TrustManager[] tms = tmf.getTrustManagers();
        
        
        SSLContext sslContext = null;
        sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kms, tms, new SecureRandom());
        sslsf = new org.apache.http.conn.ssl.SSLSocketFactory(sslContext, new String[]{"TLSv1", "SSLv3"}, null, org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        
		}
		catch (KeyStoreException | CertificateException |NoSuchAlgorithmException | KeyManagementException |UnrecoverableKeyException | IOException e) {
			System.out.println(e.getMessage());
		}
		return sslsf;

	
	}
	
	public static void main(String[] args) {

		
		org.apache.http.conn.ssl.SSLSocketFactory sslsf = getSSLSocketFactory();
		
//        Response response = RestAssured.given().config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().sslSocketFactory(sslsf))).when().get("https://ec2-108-128-174-166.eu-west-1.compute.amazonaws.com:7443/live/uk/bbc_one_northern_ireland_hd/bbc_one_northern_ireland_hd.isml/.MPD");
//		System.out.println(response.body().asString());
	

   }
}
