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

import com.github.davemeier82.homeautomation.core.device.property.HumiditySensor;
import com.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import com.github.davemeier82.homeautomation.core.event.DevicePropertyEventBase;
import com.github.davemeier82.homeautomation.core.event.HumidityChangedEvent;

public class DefaultHumidityChangedPropertyEvent extends DevicePropertyEventBase<HumiditySensor> implements HumidityChangedEvent {

  private final DataWithTimestamp<Float> relativeHumidityInPercent;

  public DefaultHumidityChangedPropertyEvent(HumiditySensor source, DataWithTimestamp<Float> relativeHumidityInPercent) {
    super(source);
    this.relativeHumidityInPercent = relativeHumidityInPercent;
  }

  @Override
  public DataWithTimestamp<Float> getRelativeHumidityInPercent() {
    return relativeHumidityInPercent;
  }

  @Override
  public String getMessageKey() {
    return "humidityChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{relativeHumidityInPercent.getValue()};
  }
}
