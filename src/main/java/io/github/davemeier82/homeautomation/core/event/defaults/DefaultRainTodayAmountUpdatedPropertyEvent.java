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
import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;
import io.github.davemeier82.homeautomation.core.event.RainTodayAmountUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link RainTodayAmountUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultRainTodayAmountUpdatedPropertyEvent implements DevicePropertyEvent, RainTodayAmountUpdatedEvent {

  private final DevicePropertyId devicePropertyId;
  DataWithTimestamp<Float> amountInMm;
  DataWithTimestamp<Float> previousAmountInMm;

  public DefaultRainTodayAmountUpdatedPropertyEvent(DevicePropertyId devicePropertyId,
                                                    DataWithTimestamp<Float> amountInMm,
                                                    DataWithTimestamp<Float> previousAmountInMm
  ) {
    this.devicePropertyId = devicePropertyId;
    this.amountInMm = amountInMm;
    this.previousAmountInMm = previousAmountInMm;
  }

  @Override
  public DataWithTimestamp<Float> getMillimeter() {
    return amountInMm;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousAmountInMm);
  }

  @Override
  public String getMessageKey() {
    return "rainTodayAmountUpdatedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{amountInMm.getValue()};
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
  }

}
