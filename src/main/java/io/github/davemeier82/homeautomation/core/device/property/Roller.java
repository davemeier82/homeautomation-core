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
 * A Roller (i.e. Blinds, Garage Door)
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface Roller extends DeviceProperty {

  /**
   * starts opening of the roller
   */
  void open();

  /**
   * starts closing of the roller
   */
  void close();

  /**
   * stops the roller movement
   */
  void stop();

  /**
   * Moves the roller to the desired position.
   *
   * @param percent 100 completely open, 0 closed
   */
  void setPosition(int percent);

  /**
   * Returns the position of the roller at the time of the report.
   * 100% completely open, 0% closed
   *
   * @return Optional.empty() if state is unknown
   */
  Optional<DataWithTimestamp<Integer>> getPositionInPercent();

  /**
   * Returns the roller state at the time of the report.
   *
   * @return Optional.empty() if state is unknown
   */
  Optional<DataWithTimestamp<RollerState>> getState();
}
