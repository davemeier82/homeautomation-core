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

import io.github.davemeier82.homeautomation.core.device.property.Dimmer;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import io.github.davemeier82.homeautomation.core.event.DimmingLevelUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link DimmingLevelUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultDimmingLevelUpdatedPropertyEvent extends DevicePropertyEventBase<Dimmer> implements DimmingLevelUpdatedEvent {

  private final DataWithTimestamp<Integer> dimmingLevelInPercent;
  private final DataWithTimestamp<Integer> previousValue;

  /**
   * @param dimmer                the dimmer to which the event belongs to
   * @param dimmingLevelInPercent the new value
   * @param previousValue         the previous
   */
  public DefaultDimmingLevelUpdatedPropertyEvent(Dimmer dimmer,
                                                 DataWithTimestamp<Integer> dimmingLevelInPercent,
                                                 DataWithTimestamp<Integer> previousValue
  ) {
    super(dimmer);
    this.dimmingLevelInPercent = dimmingLevelInPercent;
    this.previousValue = previousValue;
  }

  @Override
  public DataWithTimestamp<Integer> getDimmingLevelInPercent() {
    return dimmingLevelInPercent;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousValue);
  }

  @Override
  public String getMessageKey() {
    return "dimmingLevelChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Integer[]{dimmingLevelInPercent.getValue()};
  }

}
