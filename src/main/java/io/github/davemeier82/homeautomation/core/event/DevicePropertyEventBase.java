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

import io.github.davemeier82.homeautomation.core.device.Device;
import io.github.davemeier82.homeautomation.core.device.property.DeviceProperty;

/**
 * Abstract base class of a device property event.
 *
 * @param <T> the {@link DeviceProperty} type
 * @author David Meier
 * @since 0.1.0
 */
public abstract class DevicePropertyEventBase<T extends DeviceProperty> {
  private final T deviceProperty;

  /**
   * @param deviceProperty the {@link DeviceProperty} to which the event belongs to
   */
  public DevicePropertyEventBase(T deviceProperty) {
    this.deviceProperty = deviceProperty;
  }

  /**
   * @return the {@link Device} to which the event belongs to
   */
  public Device getDevice() {
    return getDeviceProperty().getDevice();
  }

  /**
   * @return the device property
   */
  public T getDeviceProperty() {
    return deviceProperty;
  }
}
