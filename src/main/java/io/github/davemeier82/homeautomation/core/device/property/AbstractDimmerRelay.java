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

import java.util.Optional;

/**
 * Abstract implementation of a {@link Dimmer}
 *
 * @author David Meier
 * @since 0.1.0
 */
public abstract class AbstractDimmerRelay implements Dimmer {

  /**
   * The relay
   */
  protected final AbstractRelay relay;
  /**
   * The current dimming level
   */
  protected DataWithTimestamp<Integer> dimmingLevel;

  /**
   * @param relay the relay
   */
  protected AbstractDimmerRelay(AbstractRelay relay) {
    this.relay = relay;
  }

  @Override
  public int getId() {
    return relay.getId();
  }

  @Override
  public Device getDevice() {
    return relay.getDevice();
  }

  /**
   * Changes the relay state
   *
   * @param on true to switch the relay on
   */
  public void setRelayStateTo(boolean on) {
    relay.setRelayStateTo(on);
  }

  @Override
  public Optional<DataWithTimestamp<Integer>> getDimmingLevelInPercent() {
    return Optional.ofNullable(dimmingLevel);
  }

  /**
   * Changes the dimming level
   *
   * @param levelInPercent dimming level in percent (0-100)
   */
  public synchronized void setDimmingLevelInPercent(int levelInPercent) {
    DataWithTimestamp<Integer> newValue = new DataWithTimestamp<>(levelInPercent);
    DataWithTimestamp<Integer> previousValue = dimmingLevel;
    dimmingLevel = newValue;
    relay.getEventPublisher().publishEvent(relay.getEventFactory().createDimmingLevelUpdatedEvent(this, newValue, previousValue));
    if (previousValue == null || !previousValue.getValue().equals(levelInPercent)) {
      relay.getEventPublisher().publishEvent(relay.getEventFactory().createDimmingLevelChangedEvent(this, newValue, previousValue));
    }
  }

  @Override
  public void turnOn() {
    relay.turnOn();
  }

  @Override
  public void turnOff() {
    relay.turnOff();
  }

  @Override
  public Optional<DataWithTimestamp<Boolean>> isOn() {
    return relay.isOn();
  }
}
