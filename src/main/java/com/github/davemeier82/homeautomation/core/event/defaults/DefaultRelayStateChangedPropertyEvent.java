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

package com.github.davemeier82.homeautomation.core.event.defaults;

import com.github.davemeier82.homeautomation.core.device.property.ReadOnlyRelay;
import com.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import com.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import com.github.davemeier82.homeautomation.core.event.RelayStateChangedEvent;

public class DefaultRelayStateChangedPropertyEvent extends DevicePropertyEventBase<ReadOnlyRelay> implements RelayStateChangedEvent {

  private final DataWithTimestamp<Boolean> isOn;
  private final DataWithTimestamp<Boolean> previousValue;

  public DefaultRelayStateChangedPropertyEvent(ReadOnlyRelay relay,
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
  public DataWithTimestamp<Boolean> getPreviousValue() {
    return previousValue;
  }

  @Override
  public String getMessageKey() {
    return isOn.getValue() ? "relaySwitchedOn" : "relaySwitchedOff";
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{getDevice().getDisplayName()};
  }

  @Override
  public boolean wasPreviousValueNull() {
    return getPreviousValue() == null;
  }
}