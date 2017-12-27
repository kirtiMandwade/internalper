package com.pervacio.adminportal.model;

import java.io.Serializable;

public class ResponseMessage implements Serializable{
	
	
		
		private String message;
		private String code;
		
		public ResponseMessage(String message, String code) {
			super();
			this.message = message;
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}

		
//		private DepartmentEntity department;
		
		}

