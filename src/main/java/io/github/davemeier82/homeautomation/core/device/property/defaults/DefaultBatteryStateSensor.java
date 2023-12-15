/*
 * Copyright 2021-2021 the original author or authors.
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

package io.github.davemeier82.homeautomation.core.device.property.defaults;

import io.github.davemeier82.homeautomation.core.device.Device;
import io.github.davemeier82.homeautomation.core.device.property.BatteryStateSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;

/**
 * Default implementation of a {@link BatteryStateSensor}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultBatteryStateSensor implements BatteryStateSensor {
  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final String label;
  private DataWithTimestamp<Integer> batteryLevel;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultBatteryStateSensor(long id,
                                   Device device,
                                   EventPublisher eventPublisher,
                                   EventFactory eventFactory
  ) {
    this(id, null, device, eventPublisher, eventFactory);
  }

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param label          the label
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultBatteryStateSensor(long id,
                                   String label,
                                   Device device,
                                   EventPublisher eventPublisher,
                                   EventFactory eventFactory
  ) {
    this.id = id;
    this.device = device;
    this.eventPublisher = eventPublisher;
    this.eventFactory = eventFactory;
    this.label = label;
  }

  /**
   * Sets the battery level with the current timestamp.
   *
   * @param batteryLevel the level in percent (0-100)
   */
  public void setBatteryLevel(int batteryLevel) {
    setBatteryLevel(new DataWithTimestamp<>(batteryLevel));
  }

  /**
   * Sets the battery level
   * @param newValue
   */
  public synchronized void setBatteryLevel(DataWithTimestamp<Integer> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Integer> previousValue = this.batteryLevel;
    this.batteryLevel = newValue;
    eventPublisher.publishEvent(eventFactory.createBatteryLevelUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createBatteryLevelChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Integer>> batteryLevelInPercent() {
    return Optional.ofNullable(batteryLevel);
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public Device getDevice() {
    return device;
  }

  @Override
  public String getLabel() {
    if (label != null) {
      return label;
    }
    return BatteryStateSensor.super.getLabel();
  }
}
