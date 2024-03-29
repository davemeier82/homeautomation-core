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

package io.github.davemeier82.homeautomation.core.device.mqtt;

import io.github.davemeier82.homeautomation.core.device.DeviceFactory;
import io.github.davemeier82.homeautomation.core.device.DeviceId;

import java.util.Optional;

/**
 * Factory to create MQTT devices.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface MqttDeviceFactory extends DeviceFactory {

  /**
   * @return the root MQTT topic of devices created by this factory
   */
  String getRootTopic();

  /**
   * @param topic the topic to create the id from
   * @return Optional.empty() if it is not possible to create an id
   */
  Optional<DeviceId> getDeviceId(String topic);

  /**
   * @param deviceId the id of the device
   * @return the MQTT device or Optional.empty() if no device for this topic can get created
   */
  Optional<MqttSubscriber> createMqttSubscriber(DeviceId deviceId);
}
