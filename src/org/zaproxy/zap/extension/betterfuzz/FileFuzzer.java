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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.zaproxy.zap.extension.betterfuzz.Fuzzer;

import org.apache.log4j.Logger;

public class FileFuzzer {

	private File file = null;
	private int length = -1;
	private List<Fuzzer> fuzzers = new ArrayList<>();
	private Iterator<Fuzzer> iter = null;
    private static Logger log = Logger.getLogger(FileFuzzer.class);

	protected FileFuzzer(File file) {
		this.file = file;
	}
	
	private void init() {
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            // TODO: Switch to JSON parsing logic
			String line;

			while ((line = in.readLine()) != null) {
				if (line.trim().length() > 0 && ! line.startsWith("#")) {
					fuzzers.add(new Fuzzer(line));
				}
			}
			
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(), e);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		
		length = fuzzers.size();
		iter = fuzzers.iterator();
	}
	
	public Iterator<Fuzzer> getIterator() {
		if (length == -1) {
			init();
		} else {
			iter = fuzzers.iterator();
		}
		return iter;
	}
	
	public int getLength() {
		if (length == -1) {
			init();
		}
		return length;
	}
	
	public boolean hasNext() {
		if (length == -1) {
			init();
		}
		return iter.hasNext();
	}
	
	public String getFileName() {
		return this.file.getName();
	}

}
