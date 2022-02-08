/*
 * Copyright 2021-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.davemeier82.homeautomation.core.event.defaults;

import com.github.davemeier82.homeautomation.core.device.property.MotionSensor;
import com.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import com.github.davemeier82.homeautomation.core.event.MotionDetectedEvent;

import java.time.ZonedDateTime;

public class DefaultMotionDetectedPropertyEvent extends DevicePropertyEventBase<MotionSensor> implements MotionDetectedEvent {

  private final ZonedDateTime eventTime;

  public DefaultMotionDetectedPropertyEvent(MotionSensor sensor, ZonedDateTime eventTime) {
    super(sensor);
    this.eventTime = eventTime;
  }

  @Override
  public ZonedDateTime getEventTime() {
    return eventTime;
  }

  @Override
  public String getMessageKey() {
    return "motionDetectedAt";
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{getDevice().getDisplayName()};
  }

  @Override
  public boolean wasPreviousValueNull() {
    return false;
  }
}
