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
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;
import io.github.davemeier82.homeautomation.core.event.UvIndexChangedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link UvIndexChangedEvent}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultUvIndexChangedPropertyEvent implements DevicePropertyEvent, UvIndexChangedEvent {

  private final DevicePropertyId devicePropertyId;
  private final DataWithTimestamp<Float> index;
  private final DataWithTimestamp<Float> previousValue;

  /**
   * Constructor
   *
   * @param devicePropertyId the id
   * @param index            the new value
   * @param previousValue    the old value
   */
  public DefaultUvIndexChangedPropertyEvent(DevicePropertyId devicePropertyId,
                                            DataWithTimestamp<Float> index,
                                            DataWithTimestamp<Float> previousValue
  ) {
    this.devicePropertyId = devicePropertyId;
    this.index = index;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Float> getUvIndex() {
    return null;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "uvIndexChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{index.getValue()};
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
  }

}
