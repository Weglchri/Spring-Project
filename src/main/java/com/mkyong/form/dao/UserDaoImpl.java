package com.mkyong.form.dao;

import com.mkyong.form.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

	DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}


	@Override
	public void create(User user) {

		String sql = "INSERT INTO User " + "(id, firstname, lastname) VALUES (?, ?, ?)";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setString(2, user.getFirstname());
			ps.setString(3, user.getLastname());
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}


	@Override
	public void update(User user) {

		String sql = "UPDATE User SET firstname = ?, lastname = ? WHERE id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(3, user.getUserId());
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());

			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}


	@Override
	public void remove(Integer id) {

		String sql = "DELETE FROM User WHERE Id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}


	@Override
	public User find(Integer id) {

		String sql = "SELECT * FROM User WHERE id = ?";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			User user = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("firstname"),
						rs.getString("lastname")
				);
			}
			rs.close();
			ps.close();
			return user;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}



	@Override
	public List<User> findAll() {

		String sql = "SELECT * FROM User";
		Connection conn = null;

		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			List<User> users = new ArrayList<User>();
			User user = null;
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User(
						rs.getInt("id"),
						rs.getString("firstname"),
						rs.getString("lastname")
				);
				users.add(user);
			}
			rs.close();
			ps.close();
			return users;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}



}