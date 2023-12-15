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
import io.github.davemeier82.homeautomation.core.device.property.PowerSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;

/**
 * Default implementation of a {@link PowerSensor}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultPowerSensor implements PowerSensor {
  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private DataWithTimestamp<Double> watt;
  private final String label;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultPowerSensor(long id,
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
  public DefaultPowerSensor(long id,
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
   * Sets the power consumption with the current timestamp
   *
   * @param watt the power consumption in watt
   */
  public void setWatt(double watt) {
    setWatt(new DataWithTimestamp<>(watt));
  }

  @Override
  public Optional<DataWithTimestamp<Double>> getWatt() {
    return Optional.ofNullable(watt);
  }

  /**
   * Sets the power consumption
   *
   * @param newValue the power consumption in watt with the timestamp
   */
  public synchronized void setWatt(DataWithTimestamp<Double> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Double> previousValue = watt;
    watt = newValue;
    eventPublisher.publishEvent(eventFactory.createPowerUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createPowerChangedEvent(this, newValue, previousValue));
    }
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
    return PowerSensor.super.getLabel();
  }
}
