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

import io.github.davemeier82.homeautomation.core.device.property.MotionSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import io.github.davemeier82.homeautomation.core.event.MotionUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link MotionUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultMotionUpdatedPropertyEvent extends DevicePropertyEventBase<MotionSensor> implements MotionUpdatedEvent {


  private final DataWithTimestamp<Boolean> motionDetected;
  private final DataWithTimestamp<Boolean> previousValue;

  /**
   * Constructor
   *
   * @param sensor         the sensor
   * @param motionDetected the new value
   * @param previousValue  the old value
   */
  public DefaultMotionUpdatedPropertyEvent(MotionSensor sensor,
                                           DataWithTimestamp<Boolean> motionDetected,
                                           DataWithTimestamp<Boolean> previousValue
  ) {
    super(sensor);
    this.motionDetected = motionDetected;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Boolean> motionDetected() {
    return motionDetected;
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
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

}