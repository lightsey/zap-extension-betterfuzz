/*
 * Zed Attack Proxy (ZAP) and its related class files.
 * 
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0 
 *   
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package org.zaproxy.zap.extension.betterfuzz;

import java.util.List;
import java.util.regex.Pattern;

import org.zaproxy.zap.extension.search.SearchResult;

public interface FuzzerHandler {

    void showFuzzDialog(FuzzableComponent fuzzableComponent);

    FuzzerContentPanel getFuzzerContentPanel();
    
    List<SearchResult> searchResults(Pattern pattern, boolean inverse);
}
