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
 * A Sensor that reports the wind.
 *
 * @author David Meier
 * @since 0.4.0
 */
public interface WindSensor extends DeviceProperty {

  String TYPE = "WindSensor";

  /**
   * Returns the sustained wind speed in km/h at the time of the measurement.
   *
   * @return Optional.empty() if the wind speed is unknown
   */
  Optional<DataWithTimestamp<Float>> getSpeedInKmh();

  /**
   * Returns the wind gust speed in km/h at the time of the measurement.
   *
   * @return Optional.empty() if the wind speed is unknown
   */
  Optional<DataWithTimestamp<Float>> getGustSpeedInKmh();

  /**
   * Returns the sustained wind direction in degree at the time of the measurement.
   *
   * @return Optional.empty() if the direction is unknown
   */
  Optional<DataWithTimestamp<Float>> getDirectionInDegree();

  /**
   * Returns the wind gust direction in degree at the time of the measurement.
   *
   * @return Optional.empty() if the direction is unknown
   */
  Optional<DataWithTimestamp<Float>> getGustDirectionInDegree();

  /**
   * Returns the wind run in km for the interval defined in the sensor at the time of the measurement.
   *
   * @return Optional.empty() if the distance is unknown
   */
  Optional<DataWithTimestamp<Double>> getIntervalRunInKm();

  @Override
  default String getType() {
    return TYPE;
  }
}
