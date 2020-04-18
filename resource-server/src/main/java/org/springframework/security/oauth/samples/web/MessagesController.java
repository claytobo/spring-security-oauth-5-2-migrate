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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Joe Grandja
 */
@RestController
public class MessagesController {
	@Value("${custom.messages.message-1}")
	private String msg1;
	@Value("${custom.messages.message-2}")
	private String msg2;
	@Value("${custom.messages.message-3}")
	private String msg3;
	
	@GetMapping("/messages")
	public String[] getMessages() {
		String[] messages = new String[] {msg1, msg2, msg3};
		return messages;
	}
}