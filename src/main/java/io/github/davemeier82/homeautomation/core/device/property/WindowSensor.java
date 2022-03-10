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
 * A Sensor that reports if a door/window is open, closed or tilted.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface WindowSensor extends DeviceProperty {
  /**
   * Returns true if the window is open at the time of the measurement.
   *
   * @return Optional.empty() if state is unknown
   */
  Optional<DataWithTimestamp<Boolean>> isOpen();

  /**
   * Returns the tilt angle in degree at the time of the measurement.
   *
   * @return Optional.empty() if angle is unknown
   */
  Optional<DataWithTimestamp<Integer>> getTiltAngleInDegree();

  /**
   * @return true if this sensor supports tilting
   */
  boolean isTiltingSupported();
}
