/**
 * Copyright © YOLANDA. All Rights Reserved
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
package com.sample.multiasynctask;

import com.yolanda.multiasynctask.MultiAsynctask;

/**
 * Created in Aug 3, 2015 2:17:26 PM
 * 
 * @author YOLANDA
 */
public class LongAsynctask extends MultiAsynctask<Paramer, Updater, Resulter> {

	@Override
	public Resulter onTask(Paramer... params) {
		Paramer paramer = params[0];
		Logger.i("onTask打印：" + "what:" + paramer.getWhat() + ";value:" + paramer.getValue());
		for (int i = 0; i < 10; i++) {
			paramer.setValue(paramer.getValue() + 1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Updater updater = new Updater(paramer.getWhat(), paramer.getValue());
			postUpdate(updater);
		}
		return new Resulter(paramer.getWhat(), paramer.getValue());
	}

	@Override
	public void onUpdate(Updater update) {
		Logger.i("onUpdate打印：" + "what:" + update.getWhat() + ";value:" + update.getValue());
	}

	@Override
	public void onResult(Resulter result) {
		Logger.i("onResult打印：" + "what:" + result.getWhat() + ";value:" + result.getValue());
	}
}
