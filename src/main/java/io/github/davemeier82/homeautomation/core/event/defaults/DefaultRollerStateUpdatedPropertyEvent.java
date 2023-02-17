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
import io.github.davemeier82.homeautomation.core.event.RollerStateUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link RollerStateUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultRollerStateUpdatedPropertyEvent extends DevicePropertyEventBase<Roller> implements RollerStateUpdatedEvent {

  private final DataWithTimestamp<RollerState> state;
  private final DataWithTimestamp<RollerState> previousState;

  /**
   * Constructor
   *
   * @param roller        the roller
   * @param state         the new state
   * @param previousState the old state
   */
  public DefaultRollerStateUpdatedPropertyEvent(Roller roller,
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
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousState);
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
        return "rollerIsIdle";
      }
    }
    return null;
  }

  @Override
  public Object[] getMessageArgs() {
    return new String[]{getDevice().getDisplayName()};
  }

}
