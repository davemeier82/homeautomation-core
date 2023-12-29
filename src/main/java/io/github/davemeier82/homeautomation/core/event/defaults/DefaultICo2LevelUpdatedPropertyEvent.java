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

import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.event.Co2LevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link Co2LevelUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.3.0
 */
public class DefaultICo2LevelUpdatedPropertyEvent implements DevicePropertyEvent, Co2LevelUpdatedEvent {

  private final DevicePropertyId devicePropertyId;
  private final DataWithTimestamp<Integer> ppm;
  private final DataWithTimestamp<Integer> previousValue;

  /**
   * Constructor
   *
   * @param devicePropertyId the id
   * @param ppm              the new value
   * @param previousValue    the old value
   */
  public DefaultICo2LevelUpdatedPropertyEvent(DevicePropertyId devicePropertyId,
                                              DataWithTimestamp<Integer> ppm,
                                              DataWithTimestamp<Integer> previousValue
  ) {
    this.devicePropertyId = devicePropertyId;
    this.ppm = ppm;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Integer> getPpm() {
    return ppm;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "co2LevelIs";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Integer[]{ppm.getValue()};
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
  }
}
