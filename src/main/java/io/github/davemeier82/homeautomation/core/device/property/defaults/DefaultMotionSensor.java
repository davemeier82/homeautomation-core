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

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a MotionSensor.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultMotionSensor implements MotionSensor {

  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<DataWithTimestamp<Boolean>> motionDetected = new AtomicReference<>();

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultMotionSensor(long id,
                             Device device,
                             EventPublisher eventPublisher,
                             EventFactory eventFactory
  ) {
    this.id = id;
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
   * Sets timestamp of the detected motion
   *
   * @param newValue the new motion state with the timestamp
   */
  public void setMotionDetected(DataWithTimestamp<Boolean> newValue) {
    DataWithTimestamp<Boolean> previousValue = motionDetected.getAndSet(newValue);
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createMotionDetectedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Boolean>> getMotionDetected() {
    return Optional.ofNullable(motionDetected.get());
  }
}
