package com.JavaATM.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JavaATM.dao.JavaATMDAO;

@Repository("jdbcImpl")
public class JDBCImplementation {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional			
	public void registration(int acctId, String username, String password, String name, String address, String contactNum) {
		
		
		String credQuery = "INSERT INTO javabankingsystem.credentials (account_id,username,password) VALUES (?,?,?)";
		String customerQuery = "INSERT INTO javabankingsystem.customer (account_id,name,address,contact_number) VALUES (?,?,?,?)";
		String transactionQuery = "INSERT INTO javabankingsystem.transaction (account_id,transaction_type) VALUES (?,?)";
		
		jdbcTemplate.update(credQuery,acctId,username,password);
		jdbcTemplate.update(customerQuery,acctId,name,address,contactNum);
		jdbcTemplate.update(transactionQuery,acctId,"registration");
	}
	
	public int emailCheck(String username) {
		return (jdbcTemplate.queryForObject("SELECT count(*) FROM credentials WHERE username = ?", Integer.class, username));
	}
	
	public int accountCheck(String accountNum) {
		return (jdbcTemplate.queryForObject("SELECT count(*) FROM account WHERE account_number = ?", Integer.class, accountNum));
	}
	
	public int saveAndGenerateAcctId(String arg) {
		jdbcTemplate.update("INSERT INTO javabankingsystem.account (account_number) VALUES (?)",arg);
		
		return (jdbcTemplate.queryForObject("SELECT account_id FROM account WHERE account_number = ?", Integer.class, arg));
	}
	
	public void transactionalTest() {
		
	}
}
