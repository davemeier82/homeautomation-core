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

package io.github.davemeier82.homeautomation.core;

import io.github.davemeier82.homeautomation.core.device.DeviceId;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;

import java.time.Instant;
import java.util.Optional;

/**
 * A repository that can save the values of a device (i.e. a time series database).
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface DeviceStateRepository {

  /**
   * Insert a double value.
   *
   * @param deviceId the device id
   * @param category the category to with the value belongs to (i.e. illuminance)
   * @param label    the label of the device property
   * @param value    the value
   * @param time     the timestamp
   */
  void insert(DeviceId deviceId, String category, String label, double value, Instant time);

  /**
   * Insert a int value.
   *
   * @param deviceId the device id
   * @param category the category to with the value belongs to (i.e. illuminance)
   * @param label    the label of the device property
   * @param value    the value
   * @param time     the timestamp
   */
  void insert(DeviceId deviceId, String category, String label, int value, Instant time);

  /**
   * Insert a boolean value.
   *
   * @param deviceId the device id
   * @param category the category to with the value belongs to (i.e. illuminance)
   * @param label    the label of the device property
   * @param value    the value
   * @param time     the timestamp
   */
  void insert(DeviceId deviceId, String category, String label, boolean value, Instant time);

  /**
   * Get the latest value of a device and category
   *
   * @param deviceId the device id
   * @param category the category
   * @param <T>      the expected value type
   * @return the latest value stored in the repository if any
   */
  <T> Optional<DataWithTimestamp<T>> findLatestValue(DeviceId deviceId, String category);

}
