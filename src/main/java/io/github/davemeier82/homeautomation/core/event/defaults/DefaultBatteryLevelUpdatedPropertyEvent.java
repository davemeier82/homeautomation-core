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

package io.github.davemeier82.homeautomation.core.event.defaults;

import io.github.davemeier82.homeautomation.core.device.property.BatteryStateSensor;
import io.github.davemeier82.homeautomation.core.event.BatteryLevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;

import java.util.Optional;

/**
 * Default implementation of a {@link BatteryLevelUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultBatteryLevelUpdatedPropertyEvent extends DevicePropertyEventBase<BatteryStateSensor> implements BatteryLevelUpdatedEvent {
  private final DataWithTimestamp<Integer> batteryLevelInPercent;
  private final DataWithTimestamp<Integer> previousValue;

  /**
   * Constructor
   *
   * @param sensor                the sensor to with the event belongs to
   * @param batteryLevelInPercent the new value
   * @param previousValue         the previous value
   */
  public DefaultBatteryLevelUpdatedPropertyEvent(BatteryStateSensor sensor,
                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                 DataWithTimestamp<Integer> previousValue
  ) {
    super(sensor);
    this.batteryLevelInPercent = batteryLevelInPercent;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Integer> getBatteryLevelInPercent() {
    return batteryLevelInPercent;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "batteryLevelChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Integer[]{batteryLevelInPercent.getValue()};
  }

}
