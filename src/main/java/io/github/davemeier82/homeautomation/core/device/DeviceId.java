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

package io.github.davemeier82.homeautomation.core.device;

/**
 * A {@link Device} can uniquely be identified by a type and an id.
 */
public record DeviceId(String id, DeviceType type) {

  public static DeviceId deviceIdFromDevice(Device device) {
    return new DeviceId(device.getId(), device.getType());
  }

  @Override
  public String toString() {
    return type.getTypeName() + "-" + id;
  }
}
