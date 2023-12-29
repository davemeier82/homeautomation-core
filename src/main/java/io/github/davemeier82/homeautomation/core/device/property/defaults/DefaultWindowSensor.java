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

/**
 * Default implementation of a {@link WindowSensor}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultWindowSensor implements WindowSensor {
  private final int id;
  private final Device device;

  private final boolean tiltingSupported;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final String label;
  private DataWithTimestamp<Boolean> isOpen;
  private DataWithTimestamp<Integer> tiltAngleInDegree;

  /**
   * Constructor
   *
   * @param id               the device property id
   * @param device           the device
   * @param tiltingSupported true if tilting is supported
   * @param eventPublisher   the event publisher
   * @param eventFactory     the event factory
   */
  public DefaultWindowSensor(int id,
                             Device device,
                             boolean tiltingSupported,
                             EventPublisher eventPublisher,
                             EventFactory eventFactory
  ) {
    this(id, null, device, tiltingSupported, eventPublisher, eventFactory);
  }

  /**
   * Constructor
   *
   * @param id               the device property id
   * @param label            the label
   * @param device           the device
   * @param tiltingSupported true if tilting is supported
   * @param eventPublisher   the event publisher
   * @param eventFactory     the event factory
   */
  public DefaultWindowSensor(int id,
                             String label,
                             Device device,
                             boolean tiltingSupported,
                             EventPublisher eventPublisher,
                             EventFactory eventFactory
  ) {
    this.id = id;
    this.label = label;
    this.device = device;
    this.tiltingSupported = tiltingSupported;
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

  /**
   * Sets the state of the door/window with the current timestamp
   *
   * @param open true if the window/door is open
   */
  public void setIsOpen(boolean open) {
    setIsOpen(new DataWithTimestamp<>(open));
  }

  public synchronized void setIsOpen(DataWithTimestamp<Boolean> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Boolean> previousValue = isOpen;
    isOpen = newValue;
    eventPublisher.publishEvent(eventFactory.createWindowStateUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createWindowStateChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Boolean>> isOpen() {
    return Optional.ofNullable(isOpen);
  }

  @Override
  public Optional<DataWithTimestamp<Integer>> getTiltAngleInDegree() {
    return Optional.ofNullable(tiltAngleInDegree);
  }

  /**
   * Sets the tilt angle of the door/window with the current timestamp
   *
   * @param angleInDegree the tilt angle of the window/door
   */
  public synchronized void setTiltAngleInDegree(DataWithTimestamp<Integer> angleInDegree) {
    if (angleInDegree.getValue() != -1) {
      tiltAngleInDegree = angleInDegree;
    }
  }

  @Override
  public boolean isTiltingSupported() {
    return tiltingSupported;
  }

  @Override
  public String getLabel() {
    if (label != null) {
      return label;
    }
    return WindowSensor.super.getLabel();
  }
}
