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

import io.github.davemeier82.homeautomation.core.device.property.Roller;
import io.github.davemeier82.homeautomation.core.device.property.RollerState;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import io.github.davemeier82.homeautomation.core.event.RollerStateChangedEvent;

public class DefaultRollerStateChangedPropertyEvent extends DevicePropertyEventBase<Roller> implements RollerStateChangedEvent {

  private final DataWithTimestamp<RollerState> state;
  private final DataWithTimestamp<RollerState> previousState;

  public DefaultRollerStateChangedPropertyEvent(Roller roller,
                                                DataWithTimestamp<RollerState> state,
                                                DataWithTimestamp<RollerState> previousState
  ) {
    super(roller);
    this.state = state;
    this.previousState = previousState;
  }

  @Override
  public DataWithTimestamp<RollerState> getState() {
    return state;
  }

  @Override
  public DataWithTimestamp<RollerState> getPreviousState() {
    return previousState;
  }

  @Override
  public String getMessageKey() {
    switch (state.getValue()) {
      case OPENING -> {
        return "rollerIsOpening";
      }
      case CLOSING -> {
        return "rollerIsClosing";
      }
      case IDLE -> {
        return "rollerStopped";
      }
    }
    return null;
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{getDevice().getDisplayName()};
  }

  @Override
  public boolean wasPreviousValueNull() {
    return getPreviousState() == null;
  }
}
