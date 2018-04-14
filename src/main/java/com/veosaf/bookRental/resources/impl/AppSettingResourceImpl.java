package com.veosaf.bookRental.resources.impl;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.veosaf.bookRental.resources.AppSettingResource;
import com.veosaf.bookRental.services.AppSettingService;

@Component
public class AppSettingResourceImpl implements AppSettingResource {

	@Inject
	private AppSettingService appSettingService;

	@Override
	public Response getAppSettingByName(String name) {
		String appSettingValue = appSettingService.getAppSettingByName(name);
		return Response.ok(appSettingValue).build();
	}

}
