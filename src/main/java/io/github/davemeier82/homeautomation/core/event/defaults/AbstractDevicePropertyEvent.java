/*
 * Copyright 2021-2024 the original author or authors.
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
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyValueType;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;

import java.time.OffsetDateTime;
import java.util.Optional;

public abstract class AbstractDevicePropertyEvent<T> implements DevicePropertyEvent<T> {

  protected final DevicePropertyId devicePropertyId;
  protected final DevicePropertyValueType devicePropertyValueType;
  protected final String displayName;
  protected final DataWithTimestamp<T> state;
  protected final DataWithTimestamp<T> previousState;

  protected AbstractDevicePropertyEvent(DevicePropertyId devicePropertyId,
                                        DevicePropertyValueType devicePropertyValueType,
                                        String displayName,
                                        DataWithTimestamp<T> state,
                                        DataWithTimestamp<T> previousState
  ) {
    this.devicePropertyId = devicePropertyId;
    this.devicePropertyValueType = devicePropertyValueType;
    this.displayName = displayName;
    this.state = state;
    this.previousState = previousState;
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
  }

  @Override
  public DevicePropertyValueType getValueType() {
    return devicePropertyValueType;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }


  @Override
  public T getNewValue() {
    return state.getValue();
  }

  @Override
  public OffsetDateTime getNewTimestamp() {
    return state.getDateTime();
  }

  @Override
  public Optional<T> getPreviousValue() {
    return Optional.ofNullable(previousState).map(DataWithTimestamp::getValue);
  }

  @Override
  public Optional<OffsetDateTime> getPreviousTimestamp() {
    return Optional.ofNullable(previousState).map(DataWithTimestamp::getDateTime);
  }
}
