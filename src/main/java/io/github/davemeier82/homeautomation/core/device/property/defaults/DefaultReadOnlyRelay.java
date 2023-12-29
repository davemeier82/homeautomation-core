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
import io.github.davemeier82.homeautomation.core.device.property.ReadOnlyRelay;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a {@link ReadOnlyRelay}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultReadOnlyRelay implements ReadOnlyRelay {
  private final int id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final String label;
  /**
   * The relay state and the time of the state change.
   */
  protected final AtomicReference<DataWithTimestamp<Boolean>> isOn = new AtomicReference<>();

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultReadOnlyRelay(int id,
                              Device device,
                              EventPublisher eventPublisher,
                              EventFactory eventFactory
  ) {
    this(id, null, device, eventPublisher, eventFactory);
  }

  /**
   * @param id             the device property id
   * @param label          the label
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public DefaultReadOnlyRelay(int id, String label, Device device, EventPublisher eventPublisher, EventFactory eventFactory) {
    this.id = id;
    this.device = device;
    this.eventPublisher = eventPublisher;
    this.eventFactory = eventFactory;
    this.label = label;
  }

  /**
   * Sets the relay state with the current timestamp
   *
   * @param on true if the relay is switched on
   */
  public void setRelayStateTo(boolean on) {
    setRelayStateTo(new DataWithTimestamp<>(on));
  }

  /**
   * Sets the relay state
   * @param newValue
   */
  public synchronized void setRelayStateTo(DataWithTimestamp<Boolean> newValue) {
    if (newValue == null) {
      return;
    }
    DataWithTimestamp<Boolean> previousValue = isOn.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createRelayStateUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(newValue.getValue())) {
      eventPublisher.publishEvent(eventFactory.createRelayStateChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Boolean>> isOn() {
    return Optional.ofNullable(isOn.get());
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
   * @return the event publisher
   */
  public EventPublisher getEventPublisher() {
    return eventPublisher;
  }

  /**
   * @return the event eventFactory
   */
  public EventFactory getEventFactory() {
    return eventFactory;
  }

  @Override
  public String getLabel() {
    if (label != null) {
      return label;
    }
    return ReadOnlyRelay.super.getLabel();
  }
}
