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
 import junit.framework.TestCase;
 
 import java.util.HashMap;
 import java.util.Map;
 
 public class Issue1725 extends TestCase {
     public void test_for_issue() throws Exception {
         Map<String, Object> map= new HashMap<String, Object>();
         map.put("enumField", 0);
 
         AbstractBean bean = JSON.parseObject(JSON.toJSONString(map), ConcreteBean.class);
         assertEquals(FieldEnum.A, bean.enumField);
     }
 
     public static class AbstractBean {
         public FieldEnum enumField;
     }
 
     public static class ConcreteBean extends AbstractBean {
 
     }
 
     public static enum FieldEnum { A, B }
 }