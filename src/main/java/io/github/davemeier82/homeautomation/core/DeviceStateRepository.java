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

public interface DeviceStateRepository {

  void insert(DeviceId deviceId, String category, double value, Instant time);

  void insert(DeviceId deviceId, String category, int value, Instant time);

  void insert(DeviceId deviceId, String category, boolean value, Instant time);

  <T> Optional<DataWithTimestamp<T>> findLatestValue(DeviceId deviceId, String category);

}
