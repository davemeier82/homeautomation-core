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
import io.github.davemeier82.homeautomation.core.device.property.MotionSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a {@link MotionSensor}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultMotionSensor implements MotionSensor {

  private final int id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<ZonedDateTime> lastMotionDetected = new AtomicReference<>();
  private DataWithTimestamp<Boolean> motionDetected;
  private final String label;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultMotionSensor(int id,
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
  public DefaultMotionSensor(int id,
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
  public int getId() {
    return id;
  }

  @Override
  public Device getDevice() {
    return device;
  }

  @Override
  public Optional<DataWithTimestamp<Boolean>> getMotionDetected() {
    return Optional.ofNullable(motionDetected);
  }

  /**
   * Sets timestamp of the detected motion
   *
   * @param newValue the new motion state with the timestamp
   */
  public synchronized void setMotionDetected(DataWithTimestamp<Boolean> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Boolean> previousValue = motionDetected;
    motionDetected = newValue;
    eventPublisher.publishEvent(eventFactory.createMotionUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      lastMotionDetected.set(newValue.getDateTime());
      eventPublisher.publishEvent(eventFactory.createMotionChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<ZonedDateTime> getLastMotionDetected() {
    return Optional.ofNullable(lastMotionDetected.get());
  }

  @Override
  public String getLabel() {
    if (label != null) {
      return label;
    }
    return MotionSensor.super.getLabel();
  }

}
