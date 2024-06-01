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

package io.github.davemeier82.homeautomation.core.updater;

import io.github.davemeier82.homeautomation.core.device.property.DeviceProperty;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyFactory;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyType;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;
import io.github.davemeier82.homeautomation.core.repositories.DevicePropertyRepository;

import java.util.Optional;

public class DevicePropertyCreator {

  protected final DevicePropertyRepository devicePropertyRepository;
  protected final DevicePropertyFactory devicePropertyFactory;
  protected final EventPublisher eventPublisher;
  protected final EventFactory eventFactory;

  public DevicePropertyCreator(DevicePropertyRepository devicePropertyRepository, DevicePropertyFactory devicePropertyFactory, EventPublisher eventPublisher, EventFactory eventFactory) {
    this.devicePropertyRepository = devicePropertyRepository;
    this.devicePropertyFactory = devicePropertyFactory;
    this.eventPublisher = eventPublisher;
    this.eventFactory = eventFactory;
  }

  public DeviceProperty createDevicePropertyIfItDoesNotExist(DevicePropertyId devicePropertyId, DevicePropertyType devicePropertyType) {
    Optional<DeviceProperty> devicePropertyOptional = devicePropertyRepository.findByDevicePropertyId(devicePropertyId);
    if (devicePropertyOptional.isEmpty()) {
      DeviceProperty deviceProperty = devicePropertyFactory.createDeviceProperty(devicePropertyId, devicePropertyType);
      devicePropertyRepository.save(deviceProperty);
      eventPublisher.publishEvent(eventFactory.createNewDevicePropertyCreatedEvent(devicePropertyId));
      return deviceProperty;
    }
    return devicePropertyOptional.get();
  }

}
