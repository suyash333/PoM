package com.myapplication.utils;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.*;
import java.util.List;
import org.json.*;
import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.apache.commons.io.FileUtils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class apiOperations {



	public int getOperationResponseCode(String API_URI) throws UnirestException {

		HttpResponse<JsonNode> jsonResponse = Unirest.get(API_URI)
				.header("accept", "application/json")
				.asJson();
		return jsonResponse.getStatus();
	}


	public String getOperationResponseBody(String API_URI) throws UnirestException {


		HttpResponse<JsonNode> jsonResponse = Unirest.get(API_URI)
				.header("accept", "application/json")
				.asJson();
		System.out.println(jsonResponse.getBody());
		return jsonResponse.getBody().toString();



	}

	public boolean jsonCompare(String Method, String API_URI, String ExpectedJson) throws UnirestException, IOException {


		HttpResponse<JsonNode> jsonResponse ;
		String FinalResult = null;
		boolean res = true ;
		File ExpectedJson_file = new File(ExpectedJson);

		if(Method.equalsIgnoreCase("GET")) {
			jsonResponse = Unirest.get(API_URI)
					.header("accept", "application/json")
					.asJson();
			//			System.out.println(jsonResponse.getBody());
			//			String actualJson = jsonResponse.getBody().toString();
			//			String expectedJson = FileUtils.readFileToString(ExpectedJson);
			//			JSONCompareResult result =  JSONCompare.compareJSON(expectedJson, actualJson, JSONCompareMode.STRICT);
			//			System.out.println(result.toString());
			//			FinalResult = result.toString();

			FinalResult = apiJsonCompareResults(jsonResponse,ExpectedJson_file);
			if (FinalResult==null) {
				res= true;
				} else if(FinalResult.length()>0)
				{
					System.out.println("Lenght = "+FinalResult.length());
					res= false;
				}

		}
		else if (Method.equalsIgnoreCase("POST")) {

			jsonResponse = Unirest.post(API_URI)
					.header("accept", "application/json")
					.asJson();
			System.out.println(jsonResponse.getBody());
			String actualJson = jsonResponse.getBody().toString();
			String expectedJson = FileUtils.readFileToString(ExpectedJson_file);
			JSONCompareResult result =  JSONCompare.compareJSON(expectedJson, actualJson, JSONCompareMode.STRICT);
			System.out.println(result.toString());
			FinalResult = result.toString();
		}
		else if (Method.equalsIgnoreCase("PUT")) {

			jsonResponse = Unirest.put(API_URI)
					.header("accept", "application/json")
					.asJson();
			System.out.println(jsonResponse.getBody());
			String actualJson = jsonResponse.getBody().toString();
			String expectedJson = FileUtils.readFileToString(ExpectedJson_file);
			JSONCompareResult result =  JSONCompare.compareJSON(expectedJson, actualJson, JSONCompareMode.STRICT);
			System.out.println(result.toString());
			FinalResult = result.toString();
		}
		else if (Method.equalsIgnoreCase("PATCH")) {

			jsonResponse = Unirest.patch(API_URI)
					.header("accept", "application/json")
					.asJson();
			System.out.println(jsonResponse.getBody());
			String actualJson = jsonResponse.getBody().toString();
			String expectedJson = FileUtils.readFileToString(ExpectedJson_file);
			JSONCompareResult result =  JSONCompare.compareJSON(expectedJson, actualJson, JSONCompareMode.STRICT);
			System.out.println(result.toString());
			FinalResult = result.toString();
		}
		else if (Method.equalsIgnoreCase("DELETE")) {

			jsonResponse = Unirest.delete(API_URI)
					.header("accept", "application/json")
					.asJson();
			System.out.println(jsonResponse.getBody());
			String actualJson = jsonResponse.getBody().toString();
			String expectedJson = FileUtils.readFileToString(ExpectedJson_file);
			JSONCompareResult result =  JSONCompare.compareJSON(expectedJson, actualJson, JSONCompareMode.STRICT);
			System.out.println(result.toString());
			FinalResult = result.toString();
		}
		if (FinalResult.length()==0) {
			 res = true;
		} else if(FinalResult.length()>0)
		{
			System.out.println("Lenght = "+FinalResult.length());
			 res = false;
		}

		return res;
	}

	public String apiJsonCompareResults(HttpResponse<JsonNode> JS , File ExpectedJson_file) throws IOException {
	//	System.out.println(JS.getBody());
		String actualJson = JS.getBody().toString();
		String expectedJson = FileUtils.readFileToString(ExpectedJson_file);
		JSONCompareResult result =  JSONCompare.compareJSON(expectedJson, actualJson, JSONCompareMode.STRICT);
		String FinalResult = result.toString();
		System.out.println("Comparison Result = "+FinalResult);
		return FinalResult;

	}


}


