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
import io.github.davemeier82.homeautomation.core.event.RainRateUpdatedEvent;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.RAIN_RATE;

public class DefaultRainRateUpdatedEvent extends AbstractDevicePropertyEvent<Float> implements RainRateUpdatedEvent {

  public DefaultRainRateUpdatedEvent(DevicePropertyId devicePropertyId,
                                     String displayName,
                                     DataWithTimestamp<Float> rateInMmph,
                                     DataWithTimestamp<Float> previousValue
  ) {
    super(devicePropertyId, RAIN_RATE, displayName, rateInMmph, previousValue);
  }

  @Override
  public Float getMillimeterPerHour() {
    return getNewValue();
  }

  @Override
  public String getMessageKey() {
    return "rainRateUpdatedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{getNewValue()};
  }

}
