package com.khubla.hsclient;

import java.io.*;
import java.net.*;

import org.apache.http.*;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;

import com.khubla.hsclient.response.*;

public class HSClient {
	/**
	 * user
	 */
	private static final String USER = "user";
	/**
	 * pass
	 */
	private static final String PASS = "pass";
	/**
	 * request
	 */
	private static final String REQUEST = "request";

	public static HSClient connect(String url, String username, String password) {
		return new HSClient(url, username, password);
	}

	/**
	 * HS URL
	 */
	private final String url;
	/**
	 * HS Username
	 */
	private final String username;
	/**
	 * HS Password
	 */
	private final String password;
	/**
	 * HTTP Client
	 */
	private CloseableHttpClient httpClient = HttpClients.createDefault();

	private HSClient(String url, String username, String pasword) {
		super();
		this.url = url;
		this.username = username;
		password = pasword;
	}

	private String executeGETQuery(String command) throws ParseException, IOException, URISyntaxException {
		try {
			final URIBuilder builder = new URIBuilder(url);
			builder.setParameter(USER, username).setParameter(PASS, password).addParameter(REQUEST, command);
			final HttpGet request = new HttpGet(builder.build());
			System.out.println(request.getURI().toString());
			final CloseableHttpResponse response = httpClient.execute(request);
			try {
				System.out.println(response.getProtocolVersion());
				System.out.println(response.getStatusLine().getStatusCode());
				System.out.println(response.getStatusLine().getReasonPhrase());
				System.out.println(response.getStatusLine().toString());
				final HttpEntity entity = response.getEntity();
				if (entity != null) {
					return EntityUtils.toString(entity);
				}
			} finally {
				response.close();
			}
		} finally {
			httpClient.close();
		}
		return null;
	}

	public ControlResponse getControl() throws IOException, URISyntaxException {
		final String json = executeGETQuery("getcontrol");
		return ControlResponse.parse(json);
	}

	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public String getPassword() {
		return password;
	}

	public StatusResponse getStatus() throws IOException, URISyntaxException {
		final String json = executeGETQuery("getstatus");
		return StatusResponse.parse(json);
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}
}
