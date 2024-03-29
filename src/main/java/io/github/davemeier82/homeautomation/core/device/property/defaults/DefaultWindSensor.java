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
import io.github.davemeier82.homeautomation.core.device.property.WindSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;

/**
 * Default implementation of a {@link WindSensor}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultWindSensor implements WindSensor {
  private final int id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final String label;
  private DataWithTimestamp<Float> speed;
  private DataWithTimestamp<Float> gustSpeed;
  private DataWithTimestamp<Float> direction;
  private DataWithTimestamp<Float> gustDirection;
  private DataWithTimestamp<Double> run;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultWindSensor(int id,
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
  public DefaultWindSensor(int id,
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
   * Sets the wind speed
   *
   * @param newValue
   */
  public synchronized void setSpeed(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = speed;
    speed = newValue;
    eventPublisher.publishEvent(eventFactory.createWindSpeedUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createWindSpeedChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Sets the wind gust speed
   *
   * @param newValue
   */
  public synchronized void setGustSpeed(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = gustSpeed;
    gustSpeed = newValue;
    eventPublisher.publishEvent(eventFactory.createWindGustSpeedUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createWindGustSpeedChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Sets the wind direction
   *
   * @param newValue
   */
  public synchronized void setDirection(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = direction;
    direction = newValue;
    eventPublisher.publishEvent(eventFactory.createWindDirectionUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createWindDirectionChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Sets the wind gust direction
   *
   * @param newValue
   */
  public synchronized void setGustDirection(DataWithTimestamp<Float> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Float> previousValue = gustDirection;
    gustDirection = newValue;
    eventPublisher.publishEvent(eventFactory.createWindGustDirectionUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createWindGustDirectionChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Sets the wind run
   *
   * @param newValue
   */
  public synchronized void setRun(DataWithTimestamp<Double> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Double> previousValue = run;
    run = newValue;
    eventPublisher.publishEvent(eventFactory.createWindRunUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createWindRunChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getSpeedInKmh() {
    return Optional.ofNullable(speed);
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getGustSpeedInKmh() {
    return Optional.ofNullable(gustSpeed);
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getDirectionInDegree() {
    return Optional.ofNullable(direction);
  }

  @Override
  public Optional<DataWithTimestamp<Float>> getGustDirectionInDegree() {
    return Optional.ofNullable(gustDirection);
  }

  @Override
  public Optional<DataWithTimestamp<Double>> getIntervalRunInKm() {
    return Optional.ofNullable(run);
  }

  @Override
  public int getId() {
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
    return WindSensor.super.getLabel();
  }
}
