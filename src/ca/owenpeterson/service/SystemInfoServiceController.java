package ca.owenpeterson.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import ca.owenpeterson.jaxb.Uptime;

@Controller
public class SystemInfoServiceController {
	static Logger logger = LogManager.getLogger(SystemInfoServiceController.class.getName());
	
	@Autowired
	private SystemInfoServiceManager systemInfoServiceManager;
	
	@RequestMapping(value="/system/uptime", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Uptime getUptime() {
		Uptime uptime = systemInfoServiceManager.getUptime();
		return uptime;
	}

}