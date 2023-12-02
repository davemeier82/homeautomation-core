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
import io.github.davemeier82.homeautomation.core.device.property.CloudBaseSensor;
import io.github.davemeier82.homeautomation.core.device.property.Co2Sensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a {@link Co2Sensor}.
 *
 * @author David Meier
 * @since 0.3.0
 */
public class DefaultCo2Sensor implements Co2Sensor {
  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<DataWithTimestamp<Integer>> ppm = new AtomicReference<>();
  private final String label;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultCo2Sensor(long id,
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
   * @param label          the label
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultCo2Sensor(long id,
                          String label,
                          Device device,
                          EventPublisher eventPublisher,
                          EventFactory eventFactory
  ) {
    this.id = id;
    this.label = label;
    this.device = device;
    this.eventPublisher = eventPublisher;
    this.eventFactory = eventFactory;
  }

  /**
   * Sets co2 level with the current timestamp
   *
   * @param ppm the co2 level in ppm
   */
  public void setCo2LevelInPpm(int ppm) {
    setCo2LevelInPpm( new DataWithTimestamp<>(ppm));
  }
  public void setCo2LevelInPpm(DataWithTimestamp<Integer> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Integer> previousValue = this.ppm.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createCo2LevelUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createCo2LevelChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Integer>> getPpm() {
    return Optional.ofNullable(ppm.get());
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
    return Co2Sensor.super.getLabel();
  }

}
