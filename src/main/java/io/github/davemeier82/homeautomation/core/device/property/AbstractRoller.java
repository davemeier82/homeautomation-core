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

package io.github.davemeier82.homeautomation.core.device.property;

import io.github.davemeier82.homeautomation.core.device.Device;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Abstract implementation of a {@link Roller}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public abstract class AbstractRoller implements Roller {

  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<DataWithTimestamp<RollerState>> state = new AtomicReference<>();
  private final AtomicReference<DataWithTimestamp<Integer>> position = new AtomicReference<>();

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher event publisher
   * @param eventFactory   event factory
   */
  protected AbstractRoller(long id,
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
   * Changes the roller state
   *
   * @param rollerState the roler state
   */
  public void setRollerState(RollerState rollerState) {
    DataWithTimestamp<RollerState> newValue = new DataWithTimestamp<>(rollerState);
    DataWithTimestamp<RollerState> previousValue = state.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createRollerStateUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(rollerState)) {
      eventPublisher.publishEvent(eventFactory.createRollerStateChangedEvent(this, newValue, previousValue));
    }
  }

  /**
   * Changes the roller position
   *
   * @param positionInPercent the roller position in percent (0-100)
   */
  public void setPositionInPercent(int positionInPercent) {
    DataWithTimestamp<Integer> newValue = new DataWithTimestamp<>(positionInPercent);
    DataWithTimestamp<Integer> previousValue = position.getAndSet(newValue);
    eventPublisher.publishEvent(eventFactory.createRollerPositionUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(positionInPercent)) {
      eventPublisher.publishEvent(eventFactory.createRollerPositionChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public Optional<DataWithTimestamp<Integer>> getPositionInPercent() {
    return Optional.ofNullable(position.get());
  }

  @Override
  public Optional<DataWithTimestamp<RollerState>> getState() {
    return Optional.ofNullable(state.get());
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public Device getDevice() {
    return device;
  }
}
