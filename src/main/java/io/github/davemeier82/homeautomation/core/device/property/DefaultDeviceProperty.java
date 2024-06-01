/*
 * Copyright 2021-2024 the original author or authors.
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

public class DefaultDeviceProperty implements DeviceProperty {

  private final DevicePropertyId id;

  private final DevicePropertyType type;
  private String displayName;


  public DefaultDeviceProperty(DevicePropertyId id, DevicePropertyType type, String displayName) {
    this.id = id;
    this.type = type;
    this.displayName = displayName;
  }

  public DefaultDeviceProperty(DevicePropertyId id, DevicePropertyType type) {
    this.id = id;
    this.type = type;
  }

  @Override
  public DevicePropertyId getId() {
    return id;
  }

  @Override
  public DevicePropertyType getType() {
    return type;
  }

  @Override
  public String getDisplayName() {
    if (displayName == null) {
      return type.getTypeName();
    }
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
}
