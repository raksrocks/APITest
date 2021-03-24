package com.whitbread.beans;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;

@SuppressWarnings("deprecation")
public class PayloadRegistryConfigurater implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry typeRegistry) {
		typeRegistry.defineDataTableType(
		          new DataTableType(PayloadList.class, new PayloadTransformer())
		        );
	}

}
