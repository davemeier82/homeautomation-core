/*
 * Copyright 2021-2022 the original author or authors.
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

package io.github.davemeier82.homeautomation.core.device.mqtt;

import java.util.Map;

/**
 * Abstract implementation of a MqttSubscriber.
 *
 * @author David Meier
 * @since 0.1.0
 */
public abstract class DefaultMqttSubscriber implements MqttSubscriber {

  private String displayName;
  private Map<String, String> customIdentifiers;

  public DefaultMqttSubscriber(String displayName, Map<String, String> customIdentifiers) {
    this.displayName = displayName;
    this.customIdentifiers = customIdentifiers;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public Map<String, String> getCustomIdentifiers() {
    return customIdentifiers;
  }

  @Override
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public void setCustomIdentifiers(Map<String, String> customIdentifiers) {
    this.customIdentifiers = customIdentifiers;
  }
}
