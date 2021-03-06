package com.miracle.mft.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.miracle.mft.constants.MftQueryConstants;
import com.miracle.mft.exception.MftUserException;
import com.miracle.mft.model.UserExitDetails;
import com.miracle.mft.operation.utils.UserExitDetailsRowMapper;

@Component
public class UserExitDetailsOperation {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserExitDetailsRowMapper userExitDetailsRowMapper;
	int updateCount = 0;
	private List<UserExitDetails> userExitDetails;

	String query;

	public ResponseEntity<?> getValues() {
		try {
			query = String.format(MftQueryConstants.GetUserExits);
			userExitDetails = jdbcTemplate.query(query, userExitDetailsRowMapper);
		} catch (Exception e) {
			return new ResponseEntity<>(new MftUserException("failed to get the records", e), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(userExitDetails, HttpStatus.OK);
	}
}
