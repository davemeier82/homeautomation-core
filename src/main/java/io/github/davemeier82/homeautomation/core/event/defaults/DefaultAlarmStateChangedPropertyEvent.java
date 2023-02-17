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

import io.github.davemeier82.homeautomation.core.device.property.Alarm;
import io.github.davemeier82.homeautomation.core.device.property.AlarmState;
import io.github.davemeier82.homeautomation.core.event.AlarmStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;

import java.util.Optional;

/**
 * Default implementation of a {@link AlarmStateChangedEvent}.
 *
 * @author David Meier
 * @since 0.3.0
 */
public class DefaultAlarmStateChangedPropertyEvent extends DevicePropertyEventBase<Alarm> implements AlarmStateChangedEvent {

  private final DataWithTimestamp<AlarmState> state;
  private final DataWithTimestamp<AlarmState> previousState;

  /**
   * Constructor
   *
   * @param alarm         the alarm
   * @param state         the new state
   * @param previousState the old state
   */
  public DefaultAlarmStateChangedPropertyEvent(Alarm alarm,
                                               DataWithTimestamp<AlarmState> state,
                                               DataWithTimestamp<AlarmState> previousState
  ) {
    super(alarm);
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
    }
    return null;
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{getDevice().getDisplayName()};
  }

}
