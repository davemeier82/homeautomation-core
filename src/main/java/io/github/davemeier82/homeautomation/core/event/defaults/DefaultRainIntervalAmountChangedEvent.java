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
import io.github.davemeier82.homeautomation.core.event.RainIntervalAmountChangedEvent;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.RAIN_INTERVAL_AMOUNT;

public class DefaultRainIntervalAmountChangedEvent extends AbstractDevicePropertyEvent<Float> implements RainIntervalAmountChangedEvent {

  public DefaultRainIntervalAmountChangedEvent(DevicePropertyId devicePropertyId,
                                               String displayName,
                                               DataWithTimestamp<Float> amountInMm,
                                               DataWithTimestamp<Float> previousValue
  ) {
    super(devicePropertyId, RAIN_INTERVAL_AMOUNT, displayName, amountInMm, previousValue);
  }

  @Override
  public Float getMillimeter() {
    return getNewValue();
  }

  @Override
  public String getMessageKey() {
    return "rainIntervalAmountChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{getNewValue()};
  }

}