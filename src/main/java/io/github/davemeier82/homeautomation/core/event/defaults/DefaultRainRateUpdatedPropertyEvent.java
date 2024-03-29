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
import io.github.davemeier82.homeautomation.core.event.RainRateUpdatedEvent;

import java.util.Optional;

/**
 * Default implementation of a {@link RainRateUpdatedEvent}.
 *
 * @author David Meier
 * @since 0.4.0
 */
public class DefaultRainRateUpdatedPropertyEvent implements DevicePropertyEvent, RainRateUpdatedEvent {

  private final DevicePropertyId devicePropertyId;
  DataWithTimestamp<Float> rateInMmph;
  DataWithTimestamp<Float> previousRateInMmph;


  public DefaultRainRateUpdatedPropertyEvent(DevicePropertyId devicePropertyId,
                                             DataWithTimestamp<Float> rateInMmph,
                                             DataWithTimestamp<Float> previousRateInMmph
  ) {
    this.devicePropertyId = devicePropertyId;
    this.rateInMmph = rateInMmph;
    this.previousRateInMmph = previousRateInMmph;
  }

  @Override
  public DataWithTimestamp<Float> getMillimeterPerHour() {
    return rateInMmph;
  }

  @Override
  public Optional<DataWithTimestamp<?>> getPreviousValue() {
    return Optional.ofNullable(previousRateInMmph);
  }

  @Override
  public String getMessageKey() {
    return "rainRateUpdatedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{rateInMmph.getValue()};
  }

  @Override
  public DevicePropertyId getDevicePropertyId() {
    return devicePropertyId;
  }

}
