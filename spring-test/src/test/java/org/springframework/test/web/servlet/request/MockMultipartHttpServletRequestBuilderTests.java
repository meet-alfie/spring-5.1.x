/*
 * Copyright 2002-2018 the original author or authors.
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

package org.springframework.test.web.servlet.request;

import org.junit.Test;

import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockServletContext;

import static org.junit.Assert.*;

/**
 * @author Rossen Stoyanchev
 */
public class MockMultipartHttpServletRequestBuilderTests {

	@Test
	public void test() {
		MockHttpServletRequestBuilder parent = new MockHttpServletRequestBuilder(HttpMethod.GET, "/");
		parent.characterEncoding("UTF-8");
		Object result = new MockMultipartHttpServletRequestBuilder("/fileUpload").merge(parent);

		assertNotNull(result);
		assertEquals(MockMultipartHttpServletRequestBuilder.class, result.getClass());

		MockMultipartHttpServletRequestBuilder builder = (MockMultipartHttpServletRequestBuilder) result;
		MockHttpServletRequest request = builder.buildRequest(new MockServletContext());
		assertEquals("UTF-8", request.getCharacterEncoding());
	}

}
