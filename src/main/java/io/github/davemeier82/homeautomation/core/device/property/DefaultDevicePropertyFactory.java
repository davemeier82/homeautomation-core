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

package io.github.davemeier82.homeautomation.core.device.property;

import io.github.davemeier82.homeautomation.core.device.DeviceId;
import io.github.davemeier82.homeautomation.core.device.DeviceType;

public class DefaultDevicePropertyFactory implements DevicePropertyFactory {
  @Override
  public DeviceProperty createDeviceProperty(String id, DevicePropertyType type, String deviceId, DeviceType deviceType, String displayName) {
    return createDeviceProperty(new DevicePropertyId(new DeviceId(deviceId, deviceType), id), type, displayName);
  }

  @Override
  public DeviceProperty createDeviceProperty(DevicePropertyId id, DevicePropertyType type) {
    return new DefaultDeviceProperty(id, type);
  }

  @Override
  public DeviceProperty createDeviceProperty(DevicePropertyId id, DevicePropertyType type, String displayName) {
    return new DefaultDeviceProperty(id, type, displayName);
  }
}
