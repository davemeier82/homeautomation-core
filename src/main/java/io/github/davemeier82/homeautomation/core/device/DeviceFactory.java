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

import java.util.Map;
import java.util.Set;

/**
 * A Factory to create devices.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface DeviceFactory {

  /**
   * @param type the device type
   * @return true if this factory supports the device type
   */
  boolean supportsDeviceType(String type);

  /**
   * @return returns the supported device types
   */
  Set<String> getSupportedDeviceTypes();

  /**
   * Creates a device
   *
   * @param type              device type
   * @param id                the id of the device
   * @param displayName       the display name
   * @param parameters        optional parameters to create the device
   * @param customIdentifiers optional custom identifiers
   * @return a new instance of the device
   */
  Device createDevice(String type, String id, String displayName, Map<String, String> parameters, Map<String, String> customIdentifiers);
}
