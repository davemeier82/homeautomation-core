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

import io.github.davemeier82.homeautomation.core.device.property.WindSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import io.github.davemeier82.homeautomation.core.event.WindRunChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindSpeedChangedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link WindRunChangedEvent}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultWindRunChangedPropertyEvent extends DevicePropertyEventBase<WindSensor> implements WindRunChangedEvent {

  private final DataWithTimestamp<Double> km;
  private final DataWithTimestamp<Double> previousValue;

  /**
   * Constructor
   *
   * @param sensor        the sensor
   * @param km            the new value
   * @param previousValue the old value
   */
  public DefaultWindRunChangedPropertyEvent(WindSensor sensor,
                                            DataWithTimestamp<Double> km,
                                            DataWithTimestamp<Double> previousValue
  ) {
    super(sensor);
    this.km = km;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Double> getKilometer() {
    return km;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "windRunChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Double[]{km.getValue()};
  }

}
