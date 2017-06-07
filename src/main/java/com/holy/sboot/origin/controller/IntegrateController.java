package com.holy.sboot.origin.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.holy.sboot.origin.basic.BaseCtrl;

@Controller
@RequestMapping("/sys")
public class IntegrateController extends BaseCtrl {

	@RequestMapping("/index")
	public String index() {
		// 日志级别从低到高分为 TRACE < DEBUG < INFO < WARN < ERROR < FATAL
		logger.info("111");
		logger.debug("222");
		logger.trace("333");
		System.out.println(123);
		return "index";
	}

	@Autowired
	private DataSource dataSource;

	@RequestMapping("/hikari")
	public String hikariDataSource(Map<String, Object> map) {
		try {
			Connection conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			// stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
			// stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
			// ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
			String sql = "SELECT * FROM sys_user WHERE ID = 2";
			ResultSet rs = stmt.executeQuery(sql);

			List<Map<String, Object>> list = new ArrayList<>();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			while (rs.next()) {
				// list.add("Read from DB: " + rs.getTimestamp("tick"));
				// ResultSet 记录的是条数， .getString(index)获取的才是行中某列值。
				// list.add(rs.getString(1));
				// list.add(rs.getString(2));
				Map<String, Object> rowMap = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					rowMap.put(metaData.getColumnName(i), rs.getObject(i));
				}
				list.add(rowMap);
			}
			conn.close();
			logger.info(list);
			map.put("items", list);
			map.put("msg", this.getClass().getName());
			// String aaa = "qqqq"; //put到map里面的才可以在前台用 thymeleaf 获取
			return "/integration/hikari";

		} catch (SQLException e) {
			e.printStackTrace();
			map.put("msg", e.getMessage());
			return "integration/error";
		}
	}

}
