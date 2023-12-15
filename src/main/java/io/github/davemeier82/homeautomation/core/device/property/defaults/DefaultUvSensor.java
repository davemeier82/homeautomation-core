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
import io.github.davemeier82.homeautomation.core.device.property.UvSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;

/**
 * Default implementation of a {@link UvSensor}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultUvSensor implements UvSensor {
  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final String label;
  private DataWithTimestamp<Float> uvIndex;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultUvSensor(long id,
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
  public DefaultUvSensor(long id,
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
   * Sets the UV index with the current timestamp
   *
   * @param uvIndex the UV index [0, 1]
   */
  public void setUvIndex(float uvIndex) {
    setUvIndex(new DataWithTimestamp<>(uvIndex));
  }

  /**
   * Sets the UV index
   * @param newValue the UV index [0, 1]
   */
  public synchronized void setUvIndex(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = this.uvIndex;
    this.uvIndex = newValue;
    eventPublisher.publishEvent(eventFactory.createUvIndexUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createUvIndexChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getIndex() {
    return Optional.ofNullable(uvIndex);
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
    return UvSensor.super.getLabel();
  }
}
