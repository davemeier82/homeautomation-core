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
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import io.github.davemeier82.homeautomation.core.event.RollerPositionUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link RollerPositionUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultRollerPositionUpdatedPropertyEvent extends DevicePropertyEventBase<Roller> implements RollerPositionUpdatedEvent {

  private final DataWithTimestamp<Integer> positionInPercent;
  private final DataWithTimestamp<Integer> previousValue;

  /**
   * Constructor
   *
   * @param roller            the roller
   * @param positionInPercent the new value
   * @param previousValue     the old value
   */
  public DefaultRollerPositionUpdatedPropertyEvent(Roller roller,
                                                   DataWithTimestamp<Integer> positionInPercent,
                                                   DataWithTimestamp<Integer> previousValue
  ) {
    super(roller);
    this.positionInPercent = positionInPercent;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Integer> getPositionInPercent() {
    return positionInPercent;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "rollerPositionChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Object[]{getDevice().getDisplayName(), positionInPercent.getValue()};
  }

}
