/**
 * 
 */
package com.whitbread.beans;

/**
 * @author Administrator
 *
 */
public class Response {
	private String statusCode;
	private Headers headers = new Headers();
	private Body body = new Body();
	private String errorMessage;
	private String errorType;
	private String customerId;
	private String message;
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	private boolean deleted;
	
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @return the deleted
	 */
	public boolean isDeleted() {
		return deleted;
	}
	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}
	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	/**
	 * @return the headers
	 */
	public Headers getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(Headers headers) {
		this.headers = headers;
	}
	/**
	 * @return the body
	 */
	public Body getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(Body body) {
		this.body = body;
	}
	
}
