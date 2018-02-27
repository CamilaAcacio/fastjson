/*
 * Copyright 2018 Alibaba Group.
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
package com.alibaba.json.bvt.bug;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import junit.framework.TestCase;

public class Issue569_1 extends TestCase {

    public void test_for_issue() throws Exception {
        String json = "{\"result\":{}}";
        InterfaceResult<Value> result = JSON.parseObject(json, new TypeReference<InterfaceResult<Value>>() {
        });
        assertNotNull(result.getResult());
        assertEquals(Value.class, result.getResult().getClass());
    }

    public static class BaseInterfaceResult {

    }

    public static class InterfaceResult<T> extends BaseInterfaceResult {

        public T getResult() {
            return result;
        }

        public void setResult(T result) {
            this.result = result;
        }

        private T result;
    }

    public static class Value {

    }
}
