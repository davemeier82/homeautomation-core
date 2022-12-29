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

import io.github.davemeier82.homeautomation.core.device.property.IlluminanceSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import io.github.davemeier82.homeautomation.core.event.IlluminanceUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link IlluminanceUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultIlluminanceUpdatedPropertyEvent extends DevicePropertyEventBase<IlluminanceSensor> implements IlluminanceUpdatedEvent {
  private final DataWithTimestamp<Integer> lux;
  private final DataWithTimestamp<Integer> previousValue;

  /**
   * Constructor
   *
   * @param sensor        the sensor
   * @param lux           the new value
   * @param previousValue the old value
   */
  public DefaultIlluminanceUpdatedPropertyEvent(IlluminanceSensor sensor,
                                                DataWithTimestamp<Integer> lux,
                                                DataWithTimestamp<Integer> previousValue
  ) {
    super(sensor);
    this.lux = lux;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Integer> getLux() {
    return lux;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "illuminanceChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Integer[]{lux.getValue()};
  }

}
