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
import io.github.davemeier82.homeautomation.core.event.WindowStateUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link WindowStateUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultWindowStateUpdatedPropertyEvent implements DevicePropertyEvent, WindowStateUpdatedEvent {

  private final DevicePropertyId devicePropertyId;
  private final String displayName;
  private final DataWithTimestamp<Boolean> isOpen;
  private final DataWithTimestamp<Boolean> previousValue;

  /**
   * Constructor
   *
   * @param devicePropertyId the id
   * @param displayName      the display name for the event message
   * @param isOpen           the new value
   * @param previousValue    the old value
   */
  public DefaultWindowStateUpdatedPropertyEvent(DevicePropertyId devicePropertyId, String displayName,
                                                DataWithTimestamp<Boolean> isOpen,
                                                DataWithTimestamp<Boolean> previousValue
  ) {
    this.devicePropertyId = devicePropertyId;
    this.displayName = displayName;
    this.isOpen = isOpen;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Boolean> isOpen() {
    return isOpen;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return isOpen.getValue() ? "windowIsOpen" : "windowIsClosed";
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{displayName};
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
  }

}
