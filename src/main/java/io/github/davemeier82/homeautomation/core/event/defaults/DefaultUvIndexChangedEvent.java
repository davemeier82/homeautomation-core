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
import io.github.davemeier82.homeautomation.core.event.UvIndexChangedEvent;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyValueType.UV_INDEX;

public class DefaultUvIndexChangedEvent extends AbstractDevicePropertyEvent<Float> implements UvIndexChangedEvent {

  public DefaultUvIndexChangedEvent(DevicePropertyId devicePropertyId,
                                    String displayName,
                                    DataWithTimestamp<Float> index,
                                    DataWithTimestamp<Float> previousValue
  ) {
    super(devicePropertyId, UV_INDEX, displayName, index, previousValue);
  }

  @Override
  public Float getUvIndex() {
    return getNewValue();
  }

  @Override
  public String getMessageKey() {
    return "uvIndexChangedTo";
  }

  @Override
  public Object[] getMessageArgs() {
    return new Float[]{getNewValue()};
  }

}