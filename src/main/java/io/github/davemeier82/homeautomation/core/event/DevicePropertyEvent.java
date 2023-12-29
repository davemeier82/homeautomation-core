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

package io.github.davemeier82.homeautomation.core.event;

import io.github.davemeier82.homeautomation.core.device.property.DeviceProperty;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;

import java.util.Optional;

/**
 * An event that gets emitted when a value of a {@link DeviceProperty} changes.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface DevicePropertyEvent {

  /**
   * @return the device property id to which this event belongs to
   */
  DevicePropertyId getDevicePropertyId();

  /**
   * Message key used for a translatable human-readable message (i.e. push notifications).
   * Can contain dynamic values when adding index in curly brackets: {0}. See {@link DevicePropertyEvent#getMessageArgs()}
   *
   * @return key for message translation
   */
  String getMessageKey();

  /**
   * @return optional arguments for the @{link {@link DevicePropertyEvent#getMessageKey()}
   */
  Object[] getMessageArgs();

  /**
   * @return the value of the sensor before this event, if available
   */
  Optional<DataWithTimestamp<?>> getPreviousValue();

  /**
   * @return true if the previous value is set
   */
  default boolean hasPreviousValue() {
    return getPreviousValue().isPresent();
  }
}
