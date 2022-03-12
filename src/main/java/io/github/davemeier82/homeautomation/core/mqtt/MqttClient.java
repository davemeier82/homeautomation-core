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

package io.github.davemeier82.homeautomation.core.mqtt;

import java.nio.ByteBuffer;
import java.util.Optional;
import java.util.function.BiConsumer;

/**
 * Client that connects to a MQTT broker to send and receive messages.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface MqttClient {

  /**
   * Connect to the broker
   */
  void connect();

  /**
   * @return true if the client is connected
   */
  boolean isConnected();

  /**
   * Publish a message on a topic
   *
   * @param topic   the MQTT topic
   * @param payload the message payload
   */
  void publish(String topic, byte[] payload);

  /**
   * Publish a string message on a topic
   *
   * @param topic   the MQTT topic
   * @param payload the message payload
   */
  void publish(String topic, String payload);

  /**
   * Subscribe to a MQTT topic to receive messages.
   *
   * @param mqttTopic the topic to subscribe to
   * @param consumer  a consumer that processes the incoming messages
   */
  void subscribe(String mqttTopic, BiConsumer<String, Optional<ByteBuffer>> consumer);

  /**
   * Disconnect from the broker
   */
  void disconnect();
}
