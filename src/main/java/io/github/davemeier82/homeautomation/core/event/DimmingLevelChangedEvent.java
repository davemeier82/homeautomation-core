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

package io.github.davemeier82.homeautomation.core.event;

import io.github.davemeier82.homeautomation.core.device.property.Dimmer;

/**
 * Event that gets emitted when the dimming level of a {@link Dimmer} changed.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface DimmingLevelChangedEvent extends DevicePropertyEvent {

  /**
   * @return the new dimming level and the time of the measurement
   */
  DataWithTimestamp<Integer> getDimmingLevelInPercent();

}
