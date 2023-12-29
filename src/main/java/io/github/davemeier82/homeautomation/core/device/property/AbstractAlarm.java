/*
 * Copyright 2021-2023 the original author or authors.
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

package io.github.davemeier82.homeautomation.core.device.property;

import io.github.davemeier82.homeautomation.core.device.Device;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;

/**
 * Default implementation of an {@link Alarm}.
 *
 * @author David Meier
 * @since 0.3.0
 */
public abstract class AbstractAlarm implements Alarm {
  private final int id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private DataWithTimestamp<AlarmState> state;

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher the event publisher
   * @param eventFactory   the event factory
   */
  public AbstractAlarm(int id,
                       Device device,
                       EventPublisher eventPublisher,
                       EventFactory eventFactory
  ) {
    this.id = id;
    this.device = device;
    this.eventPublisher = eventPublisher;
    this.eventFactory = eventFactory;
  }

  /**
   * Sets state of the alarm with the current timestamp
   *
   * @param state the state
   */
  public synchronized void setAlarmState(AlarmState state) {
    DataWithTimestamp<AlarmState> previousValue = this.state;
    this.state = new DataWithTimestamp<>(state);
    eventPublisher.publishEvent(eventFactory.createAlarmStateUpdatedEvent(this, this.state, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(state)) {
      eventPublisher.publishEvent(eventFactory.createAlarmStateChangedEvent(this, this.state, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<AlarmState>> getState() {
    return Optional.ofNullable(state);
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public Device getDevice() {
    return device;
  }

}
