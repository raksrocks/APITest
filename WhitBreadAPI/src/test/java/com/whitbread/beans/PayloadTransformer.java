package com.whitbread.beans;

import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.TableTransformer;

public class PayloadTransformer implements TableTransformer<PayloadList> {

	@Override
	public PayloadList transform(DataTable table) throws Throwable {
		PayloadList list = new PayloadList();
		table.cells()
		.stream()
		.skip(1)
		.map(fields -> new Payload(fields.get(0),fields.get(1),fields.get(2),fields.get(3),fields.get(4)))
		.forEach(list::addPayload);
		return list;
	}

}
