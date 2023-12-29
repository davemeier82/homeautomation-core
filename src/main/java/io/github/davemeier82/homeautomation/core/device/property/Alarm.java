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

package io.github.davemeier82.homeautomation.core.device.property;

import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;

import java.util.Optional;

/**
 * An Alarm
 *
 * @author David Meier
 * @since 0.3.0
 */
public interface Alarm extends DeviceProperty {

  String TYPE = "Alarm";

  /**
   * Returns the alarm state at the time of the report.
   *
   * @return Optional.empty() if state is unknown
   */
  Optional<DataWithTimestamp<AlarmState>> getState();

  /**
   * Sets the alarm state.
   *
   * @param state the new state
   */
  void setState(AlarmState state);

  @Override
  default String getType() {
    return TYPE;
  }
}
