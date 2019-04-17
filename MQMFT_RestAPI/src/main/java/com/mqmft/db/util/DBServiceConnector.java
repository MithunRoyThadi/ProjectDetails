package com.mqmft.db.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.mqmft.mq.service.MQQueueConstants;

/**
 * 
 *
 *
 */
@Configuration
public class DBServiceConnector {
	@Value("${spring.db.host}")
	private String dbHost;
	@Value("${spring.db.port}")
	private String dbPort;
	@Value("${spring.db.API}")
	private String dbAPI;
	public final String apiUri = DBConstants.http + dbHost + ":" + dbPort + "/"
			+ dbAPI + "/";

	/**
	 * 
	 * @return 
	 * @throws IOException
	 */
	public String getQueueManagers() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUri + DBConstants.service + DBConstants.getQMs, String.class);
		return result;
	}

	/**
	 * 
	 * @param connString
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 * @throws RestClientException 
	 */
	public String deleteQueueManagers(String qmgrId) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(qmgrId);
		System.out.println(apiUri + DBConstants.service + DBConstants.delQMs+"?QM_ID="+qmgrId);
		restTemplate.delete(apiUri + DBConstants.service + DBConstants.delQMs+"?QM_ID="+qmgrId);
		return "deleted QMgr with ID :" + qmgrId;
	}

	/**
	 * 
	 * @param connString
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 * @throws RestClientException 
	 */
	public JSONObject insertQueueManagers(InsertQMs object) throws IOException, RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String uri = apiUri + DBConstants.service + DBConstants.insertQMs;
		System.out.println(uri);
		URI u = new URI(uri);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(object);
		System.out.println(httpEntity);
		 JSONObject result = restTemplate.postForObject(u,httpEntity,JSONObject.class);
		return result;
	}

	/**
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public String updateQueueManagers(InsertQMs updateQM) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(updateQM);
		System.out.println(httpEntity);
		try {
		restTemplate.put(apiUri + DBConstants.service + DBConstants.updateQMs, httpEntity,String.class );
		}catch (Exception excep) {
			return "update Failed due to:"+ excep;
		}
		return "update successfull";
	}
	
	/**
	 * 
	 * @return 
	 * @throws IOException
	 */
	public String getHosts() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUri + DBConstants.service + DBConstants.getHosts, String.class);
		return result;
	}
	
	/**
	 * 
	 * @param connString
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 * @throws RestClientException 
	 */
	public JSONObject insertHost(InsertHost object) throws IOException, RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String uri = apiUri + DBConstants.service + DBConstants.insertHosts;
		System.out.println(uri);
		URI u = new URI(uri);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(object);
		System.out.println(httpEntity);
		 JSONObject result = restTemplate.postForObject(u,httpEntity,JSONObject.class);
		return result;
	}
	
	/**
	 * 
	 * 
	 * @return
	 * @throws IOException
	 */
	public String updateHosts(InsertHost updateHost) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<?> httpEntity = new HttpEntity<Object>(updateHost);
		System.out.println(httpEntity);
		try {
		restTemplate.put(apiUri + DBConstants.service + DBConstants.updateHosts, httpEntity,String.class );
		}catch (Exception excep) {
			return "update Failed due to:"+ excep;
		}
		return "update successfull";
	}
	/**
	 * 
	 * @param connString
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 * @throws RestClientException 
	 */
	public String deleteHosts(String hostId) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(hostId);
		System.out.println(apiUri + DBConstants.service + DBConstants.delHosts+"?Host_id="+hostId);
		restTemplate.delete(apiUri + DBConstants.service + DBConstants.delHosts+"?Host_id="+hostId);
		return "deleted Host with ID :" + hostId;
	}
	
	/**
	 * 
	 * @return 
	 * @throws IOException
	 */
	public  String getAllJobNames() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUri + DBConstants.service + DBConstants.getAllJOBNames, String.class);
		return result;
	}
	
	/**
	 * 
	 * @return 
	 * @throws IOException
	 */
	public String getTransferLogs(String startTime,String endTime,String jobName) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUri + DBConstants.service + DBConstants.getTransferLogs+"/"+startTime+"/"+endTime+"/"+jobName, String.class);
		return result;
	}
	
	/**
	 * 
	 * @return 
	 * @throws IOException
	 */
	public String getTransferValues(String id) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUri + DBConstants.service + DBConstants.getTransferValues+"/"+id, String.class);
		return result;
	}
	
	/**
	 * 
	 * @return 
	 * @throws IOException
	 */
	public String getDeletedMonitorStatus() throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(apiUri + DBConstants.service + DBConstants.getDeletedMonitorStatus, String.class);
		return result;
	}
	
	/**
	 * 
	 * @param connString
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException 
	 * @throws RestClientException 
	 */
	public JSONObject insertDeletedMonitorStatus(MonitorStatus object) throws IOException, RestClientException, URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		String uri = apiUri + DBConstants.service + DBConstants.insertDeletedMonitorStatus;
		System.out.println(uri);
		URI u = new URI(uri);
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(object);
		System.out.println(httpEntity);
		 JSONObject result = restTemplate.postForObject(u,httpEntity,JSONObject.class);
		return result;
	}
}
