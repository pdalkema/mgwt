/*
 * Copyright 2012 Daniel Kurka
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.dom.client.recognizer.longtap;

import com.google.gwt.event.shared.GwtEvent;
import com.googlecode.mgwt.collection.shared.LightArray;
import com.googlecode.mgwt.dom.client.event.touch.Touch;

/**
 * A long tap event is produced if the user touches an area of the display for a
 * given time without moving his finger(s)
 * 
 * @author Daniel Kurka
 * 
 */
public class LongTapEvent extends GwtEvent<LongTapHandler> {

	private static final Type<LongTapHandler> TYPE = new Type<LongTapHandler>();

	public static Type<LongTapHandler> getType() {
		return TYPE;
	}

	private final LightArray<Touch> startPositions;
	private final int numberOfFingers;
	private final int time;

	public LongTapEvent(Object source, int numberOfFingers, int time, LightArray<Touch> startPositions) {
		this.numberOfFingers = numberOfFingers;
		this.time = time;
		this.startPositions = startPositions;
		setSource(source);

	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<LongTapHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(LongTapHandler handler) {
		handler.onLongTap(this);

	}

	/**
	 * the number of fingers that created this event
	 * 
	 * @return
	 */
	public int getNumberOfFingers() {
		return numberOfFingers;
	}

	/**
	 * the start position of all fingers
	 * 
	 * @return the array of start positions
	 */
	public LightArray<Touch> getStartPositions() {
		return startPositions;
	}

	/**
	 * the time the user held the fingers
	 * 
	 * @return the time in milliseconds
	 */
	public int getTime() {
		return time;
	}

}
