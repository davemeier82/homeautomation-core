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
import io.github.davemeier82.homeautomation.core.event.PressureUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link PressureUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultPressureUpdatedPropertyEvent implements DevicePropertyEvent, PressureUpdatedEvent {

  private final DevicePropertyId devicePropertyId;
  private final DataWithTimestamp<Float> mbar;
  private final DataWithTimestamp<Float> previousValue;

  /**
   * Constructor
   *
   * @param devicePropertyId the id
   * @param mbar             the new value
   * @param previousValue    the old value
   */
  public DefaultPressureUpdatedPropertyEvent(DevicePropertyId devicePropertyId,
                                             DataWithTimestamp<Float> mbar,
                                             DataWithTimestamp<Float> previousValue
  ) {
    this.devicePropertyId = devicePropertyId;
    this.mbar = mbar;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Float> getPressureInMbar() {
    return mbar;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "pressureUpdatedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{mbar.getValue()};
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
  }

}
