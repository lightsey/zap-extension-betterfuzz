 /*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2011 The Zed Attack Proxy dev team
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.json.JSONObject;

public class Fuzzer {
    private Pattern regex = null;
    private Matcher match = null;
    private boolean matched = false;
    private String fuzzString;
    private int fuzzStartingOffset = 0;

    protected Fuzzer(String fuzzString) {
        this.fuzzString = fuzzString;
    }

    protected Fuzzer(JSONObject fuzz) {
        //TODO: Load fuzz string and compile regex
    }

    public String getFuzzString() {
        return fuzzString;
    }

    public String fuzzRequest(String request) {
        //TODO: Process original message for fuzzing
        //TODO: Save offset of injection point for the match logic
        return request;
    }

    public boolean isFuzzInjected(String responseBody) {
        matched = false;
        if (regex != null) {
            match = regex.matcher(responseBody);
            if (match.find()) {
                matched = true;
            }
        } else {
            if (responseBody.indexOf(fuzzString, fuzzStartingOffset) != -1) {
                matched = true;
            }
        }
        return matched;
    }

    public String getMatchedString() {
        if (!matched) {
            return null;
        }
        if (regex != null) {
            return match.group();
        }
        return fuzzString;
    }
}

