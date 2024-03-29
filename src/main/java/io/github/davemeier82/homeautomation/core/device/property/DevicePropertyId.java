/*
 * Copyright 2021-2023 the original author or authors.
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

import static io.github.davemeier82.homeautomation.core.device.DeviceId.deviceIdFromDevice;

/**
 * @param deviceId device id
 * @param id       id of the device property
 * @since 0.5.0
 */
public record DevicePropertyId(DeviceId deviceId, int id) {

  public static DevicePropertyId devicePropertyIdFrom(DeviceProperty deviceProperty) {
    return new DevicePropertyId(deviceIdFromDevice(deviceProperty.getDevice()), deviceProperty.getId());
  }
}
