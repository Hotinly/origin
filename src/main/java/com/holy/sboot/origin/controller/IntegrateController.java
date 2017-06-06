package com.holy.sboot.origin.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

			List<String> list = new ArrayList<>();
			while (rs.next()) {
				list.add("Read from DB: " + rs.getTimestamp("tick"));
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
