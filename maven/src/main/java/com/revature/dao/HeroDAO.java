package com.revature.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.Hero;
import com.revature.util.ConnectionUtil;

public class HeroDAO {

	private static String filename = "connection.properties";

	public List<Hero> getHeros() {

		List<Hero> cl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM CHARACTER";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");

				cl.add(new Hero(id, name));
			}

			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return cl;
	}

}
