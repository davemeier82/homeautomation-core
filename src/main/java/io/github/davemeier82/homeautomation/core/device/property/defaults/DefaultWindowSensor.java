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
import io.github.davemeier82.homeautomation.core.device.property.WindowSensor;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a WindowSensor.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultWindowSensor implements WindowSensor {
  private final long id;
  private final Device device;

  private final boolean tiltingSupported;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<DataWithTimestamp<Boolean>> isOpen = new AtomicReference<>();
  private final AtomicReference<DataWithTimestamp<Integer>> tiltAngleInDegree = new AtomicReference<>();

  /**
   * Constructor
   *
   * @param id               the device property id
   * @param device           the device
   * @param tiltingSupported true if tilting is supported
   * @param eventPublisher   the event publisher
   * @param eventFactory     the event factory
   */
  public DefaultWindowSensor(long id,
                             Device device,
                             boolean tiltingSupported,
                             EventPublisher eventPublisher,
                             EventFactory eventFactory
  ) {
    this.id = id;
    this.device = device;
    this.tiltingSupported = tiltingSupported;
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
   * Sets the state of the door/window with the current timestamp
   *
   * @param open true if the window/door is open
   */
  public void setIsOpen(boolean open) {
    DataWithTimestamp<Boolean> newValue = new DataWithTimestamp<>(open);
    DataWithTimestamp<Boolean> previousValue = isOpen.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createWindowStateUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(open)) {
      eventPublisher.publishEvent(eventFactory.createWindowStateChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Sets the tilt angle of the door/window with the current timestamp
   *
   * @param angleInDegree the tilt angle of the window/door
   */
  public void setTiltAngleInDegree(int angleInDegree) {
    if (angleInDegree != -1) {
      tiltAngleInDegree.set(new DataWithTimestamp<>(angleInDegree));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Boolean>> isOpen() {
    return Optional.ofNullable(isOpen.get());
  }

  @Override
  public Optional<DataWithTimestamp<Integer>> getTiltAngleInDegree() {
    return Optional.ofNullable(tiltAngleInDegree.get());
  }

  @Override
  public boolean isTiltingSupported() {
    return tiltingSupported;
  }
}
