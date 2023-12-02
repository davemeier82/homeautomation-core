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
import io.github.davemeier82.homeautomation.core.device.property.SmokeSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a {@link SmokeSensor}.
 *
 * @author David Meier
 * @since 0.3.0
 */
public class DefaultSmokeSensor implements SmokeSensor {
  private final long id;
  private final Device device;

  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<DataWithTimestamp<Boolean>> isSmokeDetected = new AtomicReference<>();
  private final String label;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultSmokeSensor(long id,
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
  public DefaultSmokeSensor(long id,
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

  @Override
  public long getId() {
    return id;
  }

  @Override
  public Device getDevice() {
    return device;
  }

  /**
   * Sets the state of the smoke sensor with the current timestamp
   *
   * @param hasSmoke true if the sensor detected smoke
   */
  public void setSmokeDetected(boolean hasSmoke) {
    setSmokeDetected(new DataWithTimestamp<>(hasSmoke));
  }

  /**
   * Sets the state of the smoke sensor
   * @param newValue
   */
  public void setSmokeDetected(DataWithTimestamp<Boolean> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Boolean> previousValue = isSmokeDetected.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createSmokeStateUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createSmokeStateChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Boolean>> isSmokeDetected() {
    return Optional.ofNullable(isSmokeDetected.get());
  }


  @Override
  public String getLabel() {
    if (label != null) {
      return label;
    }
    return SmokeSensor.super.getLabel();
  }

}
