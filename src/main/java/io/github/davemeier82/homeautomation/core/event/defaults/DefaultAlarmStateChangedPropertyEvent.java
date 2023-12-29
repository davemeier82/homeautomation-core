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
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link AlarmStateChangedEvent}.
 *
 * @author David Meier
 * @since 0.3.0
 */
public class DefaultAlarmStateChangedPropertyEvent implements DevicePropertyEvent, AlarmStateChangedEvent {

  private final DevicePropertyId devicePropertyId;
  private final String displayName;
  private final DataWithTimestamp<AlarmState> state;
  private final DataWithTimestamp<AlarmState> previousState;

  /**
   * Constructor
   *
   * @param devicePropertyId the id
   * @param displayName      the display name for the event message
   * @param state            the new state
   * @param previousState    the old state
   */
  public DefaultAlarmStateChangedPropertyEvent(DevicePropertyId devicePropertyId,
                                               String displayName,
                                               DataWithTimestamp<AlarmState> state,
                                               DataWithTimestamp<AlarmState> previousState
  ) {
    this.devicePropertyId = devicePropertyId;
    this.displayName = displayName;
    this.state = state;
    this.previousState = previousState;
  }

  @Override
  public DataWithTimestamp<AlarmState> getState() {
    return state;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousState);
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
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
