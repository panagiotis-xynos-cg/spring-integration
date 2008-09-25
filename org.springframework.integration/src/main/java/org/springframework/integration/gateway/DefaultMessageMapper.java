/*
 * Copyright 2002-2008 the original author or authors.
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

package org.springframework.integration.gateway;

import org.springframework.integration.message.Message;
import org.springframework.integration.message.MessageBuilder;

/**
 * A default implementation of the {@link MessageMapper} strategy interface.
 * 
 * @author Mark Fisher
 */
public class DefaultMessageMapper implements MessageMapper {

	/**
	 * Returns the Message payload (or null if the Message is null).
	 */
	public Object fromMessage(Message<?> message) {
		if (message == null || message.getPayload() == null) {
			return null;
		}
		return message.getPayload();
	}

	/**
	 * Returns a Message with the given object as its payload, unless the
	 * object is already a Message in which case it will be returned as-is.
	 * If the object is null, the returned Message will also be null.
	 */
	public Message<?> toMessage(Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof Message) {
			return (Message<?>) object;
		}
		return MessageBuilder.withPayload(object).build();
	}

}
