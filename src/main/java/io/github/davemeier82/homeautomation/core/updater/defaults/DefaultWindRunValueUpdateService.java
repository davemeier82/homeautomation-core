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

import io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyType;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyType;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyValueType;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;
import io.github.davemeier82.homeautomation.core.repositories.DevicePropertyValueRepository;
import io.github.davemeier82.homeautomation.core.updater.DevicePropertyCreator;
import io.github.davemeier82.homeautomation.core.updater.WindRunValueUpdateService;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.WIND_RUN;

public class DefaultWindRunValueUpdateService extends AbstractValueUpdateService<Double> implements WindRunValueUpdateService {

  private final EventFactory eventFactory;

  public DefaultWindRunValueUpdateService(DevicePropertyValueRepository devicePropertyValueRepository,
                                          DevicePropertyCreator devicePropertyCreator,
                                          EventPublisher eventPublisher,
                                          EventFactory eventFactory
  ) {
    super(devicePropertyValueRepository, devicePropertyCreator, eventPublisher, Double.class);
    this.eventFactory = eventFactory;
  }

  @Override
  protected DevicePropertyType getDevicePropertyType() {
    return DefaultDevicePropertyType.WIND_SENSOR;
  }

  @Override
  protected DevicePropertyValueType getDevicePropertyValueType() {
    return WIND_RUN;
  }

  @Override
  protected DevicePropertyEvent<Double> createUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> newValue, DataWithTimestamp<Double> previousValue, String displayName) {
    return eventFactory.createWindRunUpdatedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

  @Override
  protected DevicePropertyEvent<Double> createChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> newValue, DataWithTimestamp<Double> previousValue, String displayName) {
    return eventFactory.createWindRunChangedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

}
