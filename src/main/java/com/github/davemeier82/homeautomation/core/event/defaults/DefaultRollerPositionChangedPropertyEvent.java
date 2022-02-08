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

import com.github.davemeier82.homeautomation.core.device.property.Roller;
import com.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import com.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import com.github.davemeier82.homeautomation.core.event.RollerPositionChangedEvent;

public class DefaultRollerPositionChangedPropertyEvent extends DevicePropertyEventBase<Roller> implements RollerPositionChangedEvent {

  private final DataWithTimestamp<Integer> positionInPercent;
  private final DataWithTimestamp<Integer> previousValue;

  public DefaultRollerPositionChangedPropertyEvent(Roller roller,
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
  public DataWithTimestamp<Integer> getPreviousValue() {
    return previousValue;
  }

  @Override
  public String getMessageKey() {
    return "rollerPositionChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Object[]{getDevice().getDisplayName(), positionInPercent.getValue()};
  }

  @Override
  public boolean wasPreviousValueNull() {
    return getPreviousValue() == null;
  }
}
