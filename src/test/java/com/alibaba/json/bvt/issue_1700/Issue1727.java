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
package com.alibaba.json.bvt.issue_1700;
 
 import com.alibaba.fastjson.JSON;
 import com.alibaba.fastjson.JSONObject;
 import com.alibaba.fastjson.annotation.JSONField;
 import junit.framework.TestCase;
 
 import java.util.Date;
 
 public class Issue1727 extends TestCase {
     public void test_for_issue() throws Exception {
         String jsonString = "{\"gmtCreate\":\"20180131214157805-0800\"}";
         JSONObject.parseObject(jsonString, Model.class); //正常解析
         JSONObject.toJavaObject(JSON.parseObject(jsonString), Model.class);
     }
 
     public static class Model {
         @JSONField(format="yyyyMMddHHmmssSSSZ")
         public Date gmtCreate;
     }
 }
