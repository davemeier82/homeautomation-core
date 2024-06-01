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


public interface Device {

  /**
   * @return the type of the device (is unique in combination with {@link Device#getId()}
   */
  DeviceType getType();

  /**
   * @return the id of the device (is unique in combination with {@link Device#getType()}
   */
  String getId();

  /**
   * @return the human-readable name
   */
  String getDisplayName();

  /**
   * @param displayName the human-readable name
   */
  void setDisplayName(String displayName);

  /**
   * @return the parameters used to create this device
   */
  default Map<String, String> getParameters() {
    return Map.of();
  }

  /**
   * @return custom identifiers
   */
  Map<String, String> getCustomIdentifiers();

  /**
   * @param identifiers custom identifier
   */
  void setCustomIdentifiers(Map<String, String> identifiers);

}
