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
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;
import io.github.davemeier82.homeautomation.core.repositories.DevicePropertyValueRepository;
import io.github.davemeier82.homeautomation.core.updater.Co2ValueUpdateService;
import io.github.davemeier82.homeautomation.core.updater.DevicePropertyCreator;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyType.CO2_SENSOR;
import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.CO2_LEVEL;

public class DefaultCo2ValueUpdateService extends AbstractValueUpdateService<Integer> implements Co2ValueUpdateService {

  private final EventFactory eventFactory;

  public DefaultCo2ValueUpdateService(DevicePropertyValueRepository devicePropertyValueRepository,
                                      DevicePropertyCreator devicePropertyCreator,
                                      EventPublisher eventPublisher,
                                      EventFactory eventFactory
  ) {
    super(devicePropertyValueRepository, devicePropertyCreator, eventPublisher, Integer.class);
    this.eventFactory = eventFactory;
  }

  @Override
  protected DevicePropertyType getDevicePropertyType() {
    return CO2_SENSOR;
  }

  @Override
  protected DevicePropertyValueType getDevicePropertyValueType() {
    return CO2_LEVEL;
  }

  @Override
  protected DevicePropertyEvent<Integer> createUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> newValue, DataWithTimestamp<Integer> previousValue, String displayName) {
    return eventFactory.createCo2LevelUpdatedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

  @Override
  protected DevicePropertyEvent<Integer> createChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> newValue, DataWithTimestamp<Integer> previousValue, String displayName) {
    return eventFactory.createCo2LevelChangedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

}
