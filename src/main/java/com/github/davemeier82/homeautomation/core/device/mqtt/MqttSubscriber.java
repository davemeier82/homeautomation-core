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

package com.github.davemeier82.homeautomation.core.device.mqtt;

import java.nio.ByteBuffer;
import java.util.Optional;

/**
 * A MQTT device that can process messages.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface MqttSubscriber extends MqttDevice {

  /**
   * This method get called from a MqttClient when a message has been received
   *
   * @param topic   the topic of the message
   * @param payload the payload of the message
   */
  void processMessage(String topic, Optional<ByteBuffer> payload);
}
