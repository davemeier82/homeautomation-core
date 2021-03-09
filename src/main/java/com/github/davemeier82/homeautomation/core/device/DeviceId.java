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

package com.github.davemeier82.homeautomation.core.device;

import java.util.Objects;

public class DeviceId {

  private final String id;
  private final String type;

  public DeviceId(String id, String type) {
    this.id = id.toUpperCase();
    this.type = type.toUpperCase();
  }

  public static DeviceId deviceIdFromDevice(Device device) {
    return new DeviceId(device.getId(), device.getType());
  }

  public String getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DeviceId deviceId = (DeviceId) o;
    return Objects.equals(id, deviceId.id) && Objects.equals(type, deviceId.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }

  @Override
  public String toString() {
    return type + "-" + id;
  }
}
