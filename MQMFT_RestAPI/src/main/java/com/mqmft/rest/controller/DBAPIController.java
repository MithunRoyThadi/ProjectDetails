package com.mqmft.rest.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.bouncycastle.util.Arrays.Iterator;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import com.mqmft.db.util.DBServiceConnector;
import com.mqmft.db.util.InsertHost;
import com.mqmft.db.util.InsertQMs;
import com.mqmft.db.util.MonitorStatus;
import com.mqmft.db.util.QueueManagersInsert;
import com.mqmft.rest.api.utility.MQMFTCommonUtility;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")

public class DBAPIController {
	
	public static final Logger logger = LoggerFactory.getLogger(MqApiController.class);
	
	@RequestMapping(value = "/queueManagers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getQueueManagers() {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().getQueueManagers();
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queueManagers", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateQueueManagers(@RequestBody InsertQMs updateString) {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().updateQueueManagers(updateString);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queueManagers/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteQueueManagers(@PathVariable("id") String qmgrId) {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().deleteQueueManagers(qmgrId);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/queueManagers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertQueueManagers(@RequestBody InsertQMs insertQM) throws RestClientException, URISyntaxException {
		JSONObject response = null;
		String jsonResponse;
		try {
			System.out.println(insertQM);
			response = new DBServiceConnector().insertQueueManagers(insertQM);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/hosts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getHosts() {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().getHosts();
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/hosts", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertHosts(@RequestBody InsertHost insertHost) throws RestClientException, URISyntaxException {
		JSONObject response = null;
		String jsonResponse;
		try {
			System.out.println(insertHost);
			response = new DBServiceConnector().insertHost(insertHost);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/hosts", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateHosts(@RequestBody InsertHost updateString) {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().updateHosts(updateString);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/hosts/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteHosts(@PathVariable("id") String hostId) {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().deleteHosts(hostId);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/transfers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getAllJobNames() {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().getAllJobNames();
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/transfers/{startTime}/{endTime}/{jobName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getTransferLogs(@PathVariable("startTime") String startTime,@PathVariable("endTime") String endTime,
			@PathVariable("startTime") String jobName) {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().getTransferLogs(startTime,endTime,jobName);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/transfers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getTransferValues(@PathVariable("id") String id) {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().getTransferValues(id);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}


	@RequestMapping(value = "/monitorStatus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getDeletedMonitorStatus() {
		String response = null;
		String jsonResponse;
		try {
			response = new DBServiceConnector().getDeletedMonitorStatus();
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/monitorStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> insertDeletedMonitorStatus(@RequestBody MonitorStatus monitorStatus) throws RestClientException, URISyntaxException {
		JSONObject response = null;
		String jsonResponse;
		try {
			System.out.println(monitorStatus);
			response = new DBServiceConnector().insertDeletedMonitorStatus(monitorStatus);
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(response, "OK");
		} catch (IOException ioExcep) {
			jsonResponse = new MQMFTCommonUtility().getJsonResponse(null, ioExcep.getMessage().toString().trim());
			logger.error("IOException:" + ioExcep.getMessage().toString().trim());
		}

		return new ResponseEntity<String>(jsonResponse, MQMFTCommonUtility.getHttpResponseHeader(), HttpStatus.OK);
	}
}
