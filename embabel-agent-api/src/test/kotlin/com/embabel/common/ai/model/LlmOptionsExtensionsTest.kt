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
package com.embabel.common.ai.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.time.Duration

class LlmOptionsExtensionsTest {

    @Test
    fun `timeout property should store and retrieve values`() {
        val options = LlmOptions()
        options.timeout = null // Clear any existing state
        val timeout = Duration.ofSeconds(30)

        options.timeout = timeout
        assertEquals(timeout, options.timeout)
    }

    @Test
    fun `timeout property should handle null assignment`() {
        val options = LlmOptions()
        val timeout = Duration.ofSeconds(30)

        options.timeout = timeout
        assertEquals(timeout, options.timeout)

        options.timeout = null
        assertNull(options.timeout)
    }

    @Test
    fun `withTimeout should create new instance with timeout`() {
        val timeout = Duration.ofMinutes(5)
        val originalOptions = LlmOptions()

        val newOptions = originalOptions.withTimeout(timeout)

        // Should be different instances
        assertNotSame(originalOptions, newOptions)

        // New instance should have timeout
        assertEquals(timeout, newOptions.timeout)
    }
}
