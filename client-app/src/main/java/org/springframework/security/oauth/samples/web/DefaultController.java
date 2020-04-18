/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.security.oauth.samples.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth.samples.aop.LogExecutionTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Joe Grandja
 */
@Controller
public class DefaultController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private void logBeforeExecution(String methodName, String pattern) {
    	String className = this.getClass().getCanonicalName();
    	logger.info(String.format("%s::%s with pattern %s called", className, methodName, pattern));
    }
    
    @LogExecutionTime
	@GetMapping("/")
	public String root() {
		logBeforeExecution("root", "/");
		return "redirect:/index";
	}

    @LogExecutionTime
	@GetMapping("/index")
	public String index() {
		logBeforeExecution("index", "/index");
		return "index";
	}

    @LogExecutionTime
	@GetMapping("/login")
	public String login() {
		logBeforeExecution("login", "/login");
		return "login";
	}

    @LogExecutionTime
	@GetMapping("/login-error")
	public String loginError(Model model) {
		logBeforeExecution("loginError", "/login-error");
		model.addAttribute("loginError", true);
		return login();
	}
}