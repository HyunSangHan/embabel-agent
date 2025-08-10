/*
 * Copyright 2024-2025 Embabel Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.embabel.agent.spi.support.springai

import com.embabel.common.ai.model.LlmOptions
import com.embabel.common.ai.model.timeout
import com.embabel.common.ai.model.withTimeout
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.time.Duration

class ChatClientLlmOperationsTimeoutTest {

    @Test
    fun `should apply timeout when configured using property`() {
        val options = LlmOptions()
        val timeout = Duration.ofSeconds(30)

        options.timeout = timeout
        assertEquals(timeout, options.timeout)
    }

    @Test
    fun `should work without timeout`() {
        val options = LlmOptions()
        assertNull(options.timeout)
    }

    @Test
    fun `withTimeout should create new instance with timeout`() {
        val options = LlmOptions()
        val timeout = Duration.ofSeconds(30)

        val timeoutOptions = options.withTimeout(timeout)

        assertEquals(timeout, timeoutOptions.timeout)
        assertNull(options.timeout) // Original unchanged
        assertNotSame(options, timeoutOptions) // Different instances
    }

    @Test
    fun `timeout property should be independent per instance`() {
        val options1 = LlmOptions()
        val options2 = LlmOptions()

        options1.timeout = Duration.ofSeconds(10)
        options2.timeout = Duration.ofSeconds(20)

        assertEquals(Duration.ofSeconds(10), options1.timeout)
        assertEquals(Duration.ofSeconds(20), options2.timeout)
    }
}
