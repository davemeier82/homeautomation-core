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

package io.github.davemeier82.homeautomation.core.event.defaults;

import io.github.davemeier82.homeautomation.core.device.property.ReadOnlyRelay;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import io.github.davemeier82.homeautomation.core.event.RelayStateUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link RelayStateUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultRelayStateUpdatedPropertyEvent extends DevicePropertyEventBase<ReadOnlyRelay> implements RelayStateUpdatedEvent {

  private final DataWithTimestamp<Boolean> isOn;
  private final DataWithTimestamp<Boolean> previousValue;

  /**
   * Constructor
   *
   * @param relay         the relay
   * @param isOn          the new value
   * @param previousValue the old value
   */
  public DefaultRelayStateUpdatedPropertyEvent(ReadOnlyRelay relay,
                                               DataWithTimestamp<Boolean> isOn,
                                               DataWithTimestamp<Boolean> previousValue
  ) {
    super(relay);
    this.isOn = isOn;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Boolean> isOn() {
    return isOn;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return isOn.getValue() ? "relayIsOn" : "relayIsOff";
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{getDevice().getDisplayName()};
  }

}
