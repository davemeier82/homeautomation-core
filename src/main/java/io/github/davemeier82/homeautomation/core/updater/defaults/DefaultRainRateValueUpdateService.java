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
import io.github.davemeier82.homeautomation.core.updater.DevicePropertyCreator;
import io.github.davemeier82.homeautomation.core.updater.RainRateValueUpdateService;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyType.RAIN_SENSOR;
import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.RAIN_RATE;

public class DefaultRainRateValueUpdateService extends AbstractValueUpdateService<Float> implements RainRateValueUpdateService {

  private final EventFactory eventFactory;

  public DefaultRainRateValueUpdateService(DevicePropertyValueRepository devicePropertyValueRepository,
                                           DevicePropertyCreator devicePropertyCreator,
                                           EventPublisher eventPublisher,
                                           EventFactory eventFactory
  ) {
    super(devicePropertyValueRepository, devicePropertyCreator, eventPublisher, Float.class);
    this.eventFactory = eventFactory;
  }

  @Override
  protected DevicePropertyType getDevicePropertyType() {
    return RAIN_SENSOR;
  }

  @Override
  protected DevicePropertyValueType getDevicePropertyValueType() {
    return RAIN_RATE;
  }

  @Override
  protected DevicePropertyEvent<Float> createUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> newValue, DataWithTimestamp<Float> previousValue, String displayName) {
    return eventFactory.createRainRateUpdatedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

  @Override
  protected DevicePropertyEvent<Float> createChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> newValue, DataWithTimestamp<Float> previousValue, String displayName) {
    return eventFactory.createRainRateChangedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

}
