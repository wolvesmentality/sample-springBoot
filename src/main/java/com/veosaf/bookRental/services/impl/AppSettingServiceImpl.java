package com.veosaf.bookRental.services.impl;

import javax.inject.Inject;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.veosaf.bookRental.services.AppSettingService;

@Service
public class AppSettingServiceImpl implements AppSettingService {

	@Inject
	private Environment env;

	@Override
	public String getAppSettingByName(String name) {
		if (name == null) {
			return null;
		}
		return env.getProperty(name.toLowerCase());
	}

}
