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
import io.github.davemeier82.homeautomation.core.device.property.RainSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a {@link RainSensor}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultRainSensor implements RainSensor {
  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<DataWithTimestamp<Float>> rate = new AtomicReference<>();
  private final AtomicReference<DataWithTimestamp<Float>> rainInterval = new AtomicReference<>();
  private final AtomicReference<DataWithTimestamp<Float>> rainToday = new AtomicReference<>();
  private final String label;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultRainSensor(long id,
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
  public DefaultRainSensor(long id,
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
   * Sets the rain rate
   *
   * @param newValue
   */
  public void setRate(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = this.rate.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createRainRateUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createRainRateChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Sets the rain interval amount
   *
   * @param newValue
   */
  public void setIntervalAmount(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = this.rainInterval.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createRainTodayAmountUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createRainTodayAmountChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Sets the rain today amount
   *
   * @param newValue
   */
  public void setTodayAmount(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = this.rainToday.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createRainIntervalAmountUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createRainIntervalAmountChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getRateInMmph() {
    return Optional.ofNullable(rate.get());
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getIntervalMm() {
    return Optional.ofNullable(rainInterval.get());
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getTodayInMm() {
    return Optional.ofNullable(rainToday.get());
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
    return RainSensor.super.getLabel();
  }
}
