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

import io.github.davemeier82.homeautomation.core.device.property.AlarmState;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyType;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyValueType;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;
import io.github.davemeier82.homeautomation.core.repositories.DevicePropertyValueRepository;
import io.github.davemeier82.homeautomation.core.updater.AlarmStateValueUpdateService;
import io.github.davemeier82.homeautomation.core.updater.DevicePropertyCreator;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyType.ALARM;
import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.ALARM_STATE;

public class DefaultAlarmStateValueUpdateService extends AbstractValueUpdateService<AlarmState> implements AlarmStateValueUpdateService {

  private final EventFactory eventFactory;

  public DefaultAlarmStateValueUpdateService(DevicePropertyValueRepository devicePropertyValueRepository,
                                             DevicePropertyCreator devicePropertyCreator,
                                             EventPublisher eventPublisher,
                                             EventFactory eventFactory
  ) {
    super(devicePropertyValueRepository, devicePropertyCreator, eventPublisher, AlarmState.class);
    this.eventFactory = eventFactory;
  }

  @Override
  protected DevicePropertyType getDevicePropertyType() {
    return ALARM;
  }

  @Override
  protected DevicePropertyValueType getDevicePropertyValueType() {
    return ALARM_STATE;
  }

  @Override
  protected DevicePropertyEvent<AlarmState> createUpdatedEvent(DevicePropertyId devicePropertyId,
                                                               DataWithTimestamp<AlarmState> newValue,
                                                               DataWithTimestamp<AlarmState> previousValue,
                                                               String displayName
  ) {
    return eventFactory.createAlarmStateUpdatedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

  @Override
  protected DevicePropertyEvent<AlarmState> createChangedEvent(DevicePropertyId devicePropertyId,
                                                               DataWithTimestamp<AlarmState> newValue,
                                                               DataWithTimestamp<AlarmState> previousValue,
                                                               String displayName
  ) {
    return eventFactory.createAlarmStateChangedEvent(devicePropertyId, newValue, previousValue, displayName);
  }

}
