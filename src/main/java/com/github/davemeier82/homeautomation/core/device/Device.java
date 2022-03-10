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

import com.github.davemeier82.homeautomation.core.device.property.DeviceProperty;

import java.util.List;
import java.util.Map;

/**
 * A device. Devices contain DeviceProperties.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface Device {

  String getType();

  String getId();

  String getDisplayName();

  void setDisplayName(String displayName);

  List<? extends DeviceProperty> getDeviceProperties();

  default Map<String, String> getParameters() {
    return Map.of();
  }

  Map<String, String> getCustomIdentifiers();

  void setCustomIdentifiers(Map<String, String> identifiers);

}
