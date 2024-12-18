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

package io.github.davemeier82.homeautomation.core.repositories;

import io.github.davemeier82.homeautomation.core.device.Device;
import io.github.davemeier82.homeautomation.core.device.DeviceId;
import io.github.davemeier82.homeautomation.core.device.DeviceType;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface DeviceRepository {

  Optional<Device> getByDeviceId(DeviceId deviceId);

  Set<Device> getDevices();

  void save(Device device);

  void delete(DeviceId deviceId);

  <T> Set<? extends T> getDeviceByType(DeviceType deviceType, Class<T> clazz);

  Map<DeviceId, Map<String, String>> getAllCustomIdentifiers();

  Map<DeviceId, Map<String, String>> getAllParameters();
}

