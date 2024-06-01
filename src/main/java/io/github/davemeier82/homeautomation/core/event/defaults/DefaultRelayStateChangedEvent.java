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

import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.RelayStateChangedEvent;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.RELAY_STATE;

public class DefaultRelayStateChangedEvent extends AbstractDevicePropertyEvent<Boolean> implements RelayStateChangedEvent {

  public DefaultRelayStateChangedEvent(DevicePropertyId devicePropertyId,
                                       String displayName,
                                       DataWithTimestamp<Boolean> isOn,
                                       DataWithTimestamp<Boolean> previousState
  ) {
    super(devicePropertyId, RELAY_STATE, displayName, isOn, previousState);
  }

  @Override
  public Boolean isOn() {
    return getNewValue();
  }

  @Override
  public String getMessageKey() {
    return getNewValue() ? "relaySwitchedOn" : "relaySwitchedOff";
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{displayName};
  }

}
