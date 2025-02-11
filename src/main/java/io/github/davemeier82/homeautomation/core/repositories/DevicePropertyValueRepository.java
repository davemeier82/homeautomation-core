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

import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyValueType;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;

import java.time.OffsetDateTime;
import java.util.Optional;

public interface DevicePropertyValueRepository {

  void insert(DevicePropertyId devicePropertyId, DevicePropertyValueType devicePropertyValueType, String displayName, Object value, OffsetDateTime time);

  <T> Optional<DataWithTimestamp<T>> findLatestValue(DevicePropertyId devicePropertyId, DevicePropertyValueType devicePropertyValueType, Class<T> clazz);

  Optional<OffsetDateTime> lastTimeValueMatched(DevicePropertyId devicePropertyId, DevicePropertyValueType devicePropertyValueType, Object value);

}
