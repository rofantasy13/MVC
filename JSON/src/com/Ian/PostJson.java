package com.Ian;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

@WebServlet("/PostJson")
public class PostJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	String jsonStr =readJSON(request);
	String responseText =null;
	try {
		JSONObject jsonObj= new JSONObject(jsonStr);
		responseText= "You have a "+ jsonObj.getInt("year")+" "
		+jsonObj.getString("make")+" "	
		+jsonObj.getString("model")+" "	+" that is "
		+jsonObj.getString("color")+" "	+" in color.";
	}catch(JSONException e) {
		System.out.println("JSONException:"+ e.toString());
	}
	response.getWriter().print(responseText);
	}
	
	private String readJSON(HttpServletRequest request)
		throws IOException{
		StringBuilder json = new StringBuilder();
		String line =null;
		BufferedReader reader=request.getReader();
		while((line =reader.readLine()) != null)
		json.append(line);
		return json.toString();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
