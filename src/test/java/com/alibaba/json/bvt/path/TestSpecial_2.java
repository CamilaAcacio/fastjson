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
package com.alibaba.json.bvt.path;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONPath;
import junit.framework.TestCase;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class TestSpecial_2 extends TestCase {

    public void test_special() throws Exception {
        Model model = new Model();
        Value value = new Value();
        model.values.put("com.ibatis.sqlmap.client.SqlMapExecutor@queryForObject(String,Object)", value);
        model.subInvokes.put("com.ibatis.sqlmap.client.SqlMapExecutor@queryForObject(String,Object)", value);

        String json = JSON.toJSONString(model);
        System.out.println(json);

        Model m2 = JSON.parseObject(json, Model.class);
        assertEquals(1, m2.values.size());
        assertEquals(1, m2.subInvokes.size());

        assertSame(m2.values.values().iterator().next(), m2.subInvokes.values().iterator().next());
    }

    public static class Model {
        public Map<String, Value> values = new HashMap<String, Value>();
        public Map<String, Value> subInvokes = new HashMap<String, Value>();
    }

    public static class Value {

    }
}