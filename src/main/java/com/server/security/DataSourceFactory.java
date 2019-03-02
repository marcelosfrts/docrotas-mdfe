package com.server.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DataSourceFactory {

	public DataSource getSQLDataSource() {
		Properties props = new Properties();
		InputStream is = null;
		MysqlDataSource mysqlDS = null;
		try {
			is = this.getClass().getResourceAsStream("db.properties");
			props.load(is);
			mysqlDS = new MysqlDataSource();
			mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
			mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
			mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mysqlDS;		
	}
	
}
