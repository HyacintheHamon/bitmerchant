package com.bitmerchant.wallet;

import static spark.Spark.get;
import static spark.SparkBase.setPort;
import static spark.SparkBase.staticFileLocation;

import com.bitmerchant.tools.DataSources;
import com.bitmerchant.tools.Tools;


public class WebService {
	public static void start(LocalWallet lw) {
		setPort(DataSources.SPARK_WEB_PORT);
		
		staticFileLocation("/web"); // Static files

		

		
		get("/hello", (req, res) -> {
			Tools.allowResponseHeaders(req, res);
			return "hi from the bitmerchant wallet web service";
		});
		get("/", (req, res) -> {
			Tools.allowResponseHeaders(req, res);
			res.redirect("/html/main2.html");
			return null;
		});
		
		get("/status_progress", (req, res) -> {
			Tools.allowResponseHeaders(req, res);
//			return lw.controller.getStatusProgress();
			return lw.controller.getStatusProgress();
		
		});
		
		get("/status_text", (req, res) -> {
			Tools.allowResponseHeaders(req, res);
			return lw.controller.getStatusText();
		});
		
	}
}
