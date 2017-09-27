package com.flashCard.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.flashCard.dao.LoginDao;
import com.flashCard.model.User;

public class LoginDaoImpl implements LoginDao {

//	@Autowired
//	DataSource datasource;
//
//	@Autowired
//	JdbcTemplate jdbcTemplate;

	public void saveLogin(User user) {
		String sql = "insert into users values(?,?,?,?,?,?,?)";
//		jdbcTemplate.update(sql, new Object[] { user.getUsername(), user.getPassword(), user.getFirstname() });
	}

	public User validateLogin(User login) {
		String sql = "select * from users where username='" + login.getUsername() + "' and password='"
				+ login.getPassword() + "'";
//		List<User> users = jdbcTemplate.query(sql, new UserMapper());
//		return users.size() > 0 ? users.get(0) : null;
		return null;
	}
}

class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setFirstname(rs.getString("firstname"));
		return user;
	}
}