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

import io.github.davemeier82.homeautomation.core.device.DeviceId;
import io.github.davemeier82.homeautomation.core.device.property.DeviceProperty;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface DevicePropertyRepository {

  Optional<DeviceProperty> findByDevicePropertyId(DevicePropertyId devicePropertyId);

  List<DeviceProperty> findByDeviceId(DeviceId deviceId);

  Set<DeviceProperty> findByType(DevicePropertyType type);

  void save(DeviceProperty deviceProperty);

  void delete(DevicePropertyId devicePropertyId);
}
