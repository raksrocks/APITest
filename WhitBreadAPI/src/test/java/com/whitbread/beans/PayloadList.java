/**
 * 
 */
package com.whitbread.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class PayloadList {
	private List<Payload> payloads = new ArrayList<Payload>();
	
	public void addPayload(Payload payload) {
		payloads.add(payload);
	}

	/**
	 * @return the payloads
	 */
	public List<Payload> getPayloads() {
		return payloads;
	}
	
}
