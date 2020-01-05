package com.safexpress.MDM.RestAssured;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJSONtoMapDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	        ObjectMapper mapper = new ObjectMapper();
	        String json = "{\"categoryId\":145,\"defaultBranch\": {\"addOrRemoveOrUpdate\":\"add\","+
	        	           "\"branchCode\":\"ABO03\",\"effectiveDate\":\"2019-12-09\",\"expiryDate\":\"2020-12-09\","+
	        	           "\"isDefault\":1,\"status\":1},\"description\":\"Test\",\"email\":\"test@test.com\","+
	        		       "\"id\":123,\"isAdmin\":0,\"menuHierarchyId\":1,\"mobile\":\"1234567890\",\"name\":\"Dharmendra\","+
	        		       "\"previlegeBranches\": [{\"addOrRemoveOrUpdate\":\"add\",\"branchCode\":\"ABO02\","+
	        		       "\"effectiveDate\":\"2019-12-09\",\"expiryDate\":\"2019-12-19\",\"isDefault\":1,\"status\":null}],"+
	        		       "\"status\":1,\"userId\":\"USERD29\",\"userRoles\":[{\"addOrRemoveOrUpdate\":\"add\","+
	        		       "\"createdBy\":\"rahul\",\"description\":\"fdukhd\",\"effectiveDate\":\"2020-12-09\",\"expiryDate\":\"2019-12-09\","+
	        		       "\"roleId\":1,\"roleName\":\"role1\",\"status\":1,\"updatedBy\":\"ghchv\"}]}{\"categoryId\":145,\"defaultBranch\": {\"addOrRemoveOrUpdate\":\"add\","+
	    	        	           "\"branchCode\":\"ABO03\",\"effectiveDate\":\"2019-12-09\",\"expiryDate\":\"2020-12-09\","+
	    	        	           "\"isDefault\":1,\"status\":1},\"description\":\"Test\",\"email\":\"test@test.com\","+
	    	        		       "\"id\":123,\"isAdmin\":0,\"menuHierarchyId\":1,\"mobile\":\"1234567890\",\"name\":\"Dharmendra\","+
	    	        		       "\"previlegeBranches\": [{\"addOrRemoveOrUpdate\":\"add\",\"branchCode\":\"ABO02\","+
	    	        		       "\"effectiveDate\":\"2019-12-09\",\"expiryDate\":\"2019-12-19\",\"isDefault\":1,\"status\":null}],"+
	    	        		       "\"status\":1,\"userId\":\"USERD30\",\"userRoles\":[{\"addOrRemoveOrUpdate\":\"add\","+
	    	        		       "\"createdBy\":\"rahul\",\"description\":\"fdukhd\",\"effectiveDate\":\"2020-12-09\",\"expiryDate\":\"2019-12-09\","+
	    	        		       "\"roleId\":1,\"roleName\":\"role1\",\"status\":1,\"updatedBy\":\"ghchv\"}]}";

	        try {

	            // convert JSON string to Map
	            Map<String, String> map = mapper.readValue(json, Map.class);

				// it works
	            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

	            System.out.println(map);
	            System.out.println(map.get("userId"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	}


