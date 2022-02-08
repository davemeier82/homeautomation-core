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

import com.github.davemeier82.homeautomation.core.device.property.BatteryStateSensor;
import com.github.davemeier82.homeautomation.core.event.BatteryLevelChangedEvent;
import com.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import com.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;

public class DefaultBatteryLevelChangedPropertyEvent extends DevicePropertyEventBase<BatteryStateSensor> implements BatteryLevelChangedEvent {
  private final DataWithTimestamp<Integer> batteryLevelInPercent;
  private final DataWithTimestamp<Integer> previousValue;

  public DefaultBatteryLevelChangedPropertyEvent(BatteryStateSensor source,
                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                 DataWithTimestamp<Integer> previousValue
  ) {
    super(source);
    this.batteryLevelInPercent = batteryLevelInPercent;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Integer> getBatteryLevelInPercent() {
    return batteryLevelInPercent;
  }

  @Override
  public DataWithTimestamp<Integer> getPreviousValue() {
    return previousValue;
  }

  @Override
  public String getMessageKey() {
    return "batteryLevelChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Integer[]{batteryLevelInPercent.getValue()};
  }

  @Override
  public boolean wasPreviousValueNull() {
    return getPreviousValue() == null;
  }
}
