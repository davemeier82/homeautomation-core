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

package io.github.davemeier82.homeautomation.core.updater.defaults;

import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyType;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyValueType;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.repositories.DevicePropertyValueRepository;
import io.github.davemeier82.homeautomation.core.updater.DevicePropertyCreator;

import java.time.OffsetDateTime;

public abstract class AbstractValueUpdateService<T> {

  private final DevicePropertyValueRepository devicePropertyValueRepository;
  private final EventPublisher eventPublisher;
  private final DevicePropertyCreator devicePropertyCreator;
  private final Class<T> clazz;

  protected AbstractValueUpdateService(DevicePropertyValueRepository devicePropertyValueRepository,
                                       DevicePropertyCreator devicePropertyCreator,
                                       EventPublisher eventPublisher,
                                       Class<T> clazz
  ) {
    this.devicePropertyValueRepository = devicePropertyValueRepository;
    this.devicePropertyCreator = devicePropertyCreator;
    this.eventPublisher = eventPublisher;
    this.clazz = clazz;
  }

  protected abstract DevicePropertyType getDevicePropertyType();

  protected abstract DevicePropertyValueType getDevicePropertyValueType();

  protected abstract DevicePropertyEvent<T> createUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<T> newValue, DataWithTimestamp<T> previousValue, String displayName);

  protected abstract DevicePropertyEvent<T> createChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<T> newValue, DataWithTimestamp<T> previousValue, String displayName);

  public void setValue(T value, OffsetDateTime timestamp, DevicePropertyId devicePropertyId, String displayName) {
    devicePropertyCreator.createDevicePropertyIfItDoesNotExist(devicePropertyId, getDevicePropertyType());
    DataWithTimestamp<T> previousValue = devicePropertyValueRepository.findLatestValue(devicePropertyId, getDevicePropertyValueType(), clazz).orElse(null);
    DataWithTimestamp<T> newValue = new DataWithTimestamp<>(timestamp, value);

    eventPublisher.publishEvent(createUpdatedEvent(devicePropertyId, newValue, previousValue, displayName));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(createChangedEvent(devicePropertyId, newValue, previousValue, displayName));
    }
  }

}
