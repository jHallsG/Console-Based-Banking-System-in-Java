package com.JavaATM.api;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.JavaATM.dao.JavaATMDAO;

@Repository("jdbcImpl")
public class JDBCImplementation {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public void registration(int acctId, String username, String password) {
		
		String credQuery = "INSERT INTO credentials (account_id,username,password) VALUES (?,?,?)";
		String transactionQuery = "INSERT INTO transaction (account_id,transaction_type) VALUES (?,?)";
		String customerQuery = "INSERT INTO customer (account_id) VALUES (?)";
		
		jdbcTemplate.update(credQuery,acctId,username,passwordHash(password));
		jdbcTemplate.update(customerQuery,acctId);
		jdbcTemplate.update(transactionQuery,acctId,"registration");
	}
	
	public int emailCheck(String username) {
		return (jdbcTemplate.queryForObject("SELECT count(*) FROM credentials WHERE username = ?", Integer.class, username));
	}
	
	public int accountCheck(String accountNum) {
		return (jdbcTemplate.queryForObject("SELECT count(*) FROM account WHERE account_number = ?", Integer.class, accountNum));
	}
	
	public int saveAndGenerateAcctId(String arg) {
		jdbcTemplate.update("INSERT INTO account (account_number) VALUES (?)",arg);
		
		return (jdbcTemplate.queryForObject("SELECT account_id FROM account WHERE account_number = ?", Integer.class, arg));
	}
	
	public String passwordHash(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public String getHashedPassword(String username) {
		return jdbcTemplate.queryForObject("SELECT password FROM credentials WHERE username = ?", String.class, username);
	}
	
	public String getHashedPasswordByAcctId(int acct) {
		return jdbcTemplate.queryForObject("SELECT password FROM credentials WHERE account_id = ?", String.class, acct);
	}
	
	public int getAcctId(String username) {
		return jdbcTemplate.queryForObject("SELECT account_id FROM credentials WHERE username = ?", Integer.class, username);
	}
	
	public String getName(int account_id) {
		return (jdbcTemplate.queryForObject("SELECT name FROM customer WHERE account_id = ?", String.class, account_id));
	}
	
	public List<JavaATMDAO> getUserDetails(int account_id) {
		List<JavaATMDAO> userDetails = jdbcTemplate.query("SELECT * FROM customer WHERE account_id = ?", new BeanPropertyRowMapper<JavaATMDAO>(JavaATMDAO.class), account_id);
		return userDetails;
	}
	
	public int updateUserDetails(String name, String address, String contact, int acct) {
		Object[] args = {name,address,contact,acct};
		return jdbcTemplate.update("UPDATE customer SET name = ?, address = ?, contact_number = ? WHERE account_id = ?",args);
	}
	
	public int updatePassword(String password, int acct) {
		return jdbcTemplate.update("UPDATE credentials SET password = ? WHERE account_id = ?",passwordHash(password),acct);
	}
	
	public int getBalance(int acct) {
		return jdbcTemplate.queryForObject("SELECT balance FROM account WHERE account_id = ?", Integer.class, acct);
	}
}
