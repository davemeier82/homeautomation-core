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

import io.github.davemeier82.homeautomation.core.device.property.AlarmState;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.event.AlarmStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.ALARM_STATE;

public class DefaultAlarmStateChangedEvent extends AbstractDevicePropertyEvent<AlarmState> implements AlarmStateChangedEvent {

  public DefaultAlarmStateChangedEvent(DevicePropertyId devicePropertyId,
                                       String displayName,
                                       DataWithTimestamp<AlarmState> state,
                                       DataWithTimestamp<AlarmState> previousState
  ) {
    super(devicePropertyId, ALARM_STATE, displayName, state, previousState);
  }

  @Override
  public AlarmState getState() {
    return getNewValue();
  }

  @Override
  public String getMessageKey() {
    switch (state.getValue()) {
      case OFF -> {
        return "alarmDeactivated";
      }
      case BURGLAR -> {
        return "burglarAlarmActivated";
      }
      case FIRE -> {
        return "fireAlarmActivated";
      }
      case PRE_ALARM -> {
        return "preAlarmActivated";
      }
      case SILENCED -> {
        return "silencedActivated";
      }
    }
    return null;
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{displayName};
  }
}
