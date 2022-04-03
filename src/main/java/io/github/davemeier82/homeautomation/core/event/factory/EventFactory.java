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

package io.github.davemeier82.homeautomation.core.event.factory;

import io.github.davemeier82.homeautomation.core.device.Device;
import io.github.davemeier82.homeautomation.core.device.property.*;
import io.github.davemeier82.homeautomation.core.event.*;
import io.github.davemeier82.homeautomation.core.mqtt.MqttClient;

import java.util.List;
import java.util.Optional;

/**
 * Factory to create events.
 *
 * @author David Meier
 * @since 0.1.0
 */
public interface EventFactory {

  /**
   * @param eventName the event name
   * @return the class of the event with the name.
   */
  Optional<Class<?>> fromEventName(String eventName);

  /**
   * Creates a {@link MotionDetectedEvent}.
   *
   * @param sensor         the sensor that emits the event
   * @param motionDetected the new value
   * @param previousValue  the old value
   * @return the event
   */
  MotionDetectedEvent createMotionDetectedEvent(MotionSensor sensor,
                                                DataWithTimestamp<Boolean> motionDetected,
                                                DataWithTimestamp<Boolean> previousValue
  );

  /**
   * Creates a {@link MqttClientConnectedEvent}.
   *
   * @param client the MQTT event that connected to a broker
   * @return the event
   */
  MqttClientConnectedEvent createMqttClientConnectedEvent(MqttClient client);

  /**
   * Creates a {@link RelayStateChangedEvent}.
   *
   * @param relay         the relay that emits the event
   * @param isOn          the new value
   * @param previousValue the old value
   * @return the event
   */
  RelayStateChangedEvent createRelayStateChangedEvent(ReadOnlyRelay relay, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue);

  /**
   * Creates a {@link WindowStateChangedEvent}.
   *
   * @param windowSensor  the window sensor that emits the event
   * @param isOpen        the new value
   * @param previousValue the old value
   * @return the event
   */
  WindowStateChangedEvent createWindowStateChangedEvent(WindowSensor windowSensor,
                                                        DataWithTimestamp<Boolean> isOpen,
                                                        DataWithTimestamp<Boolean> previousValue
  );

  /**
   * Creates a {@link TemperatureChangedEvent}.
   *
   * @param temperatureSensor   the temperature sensor that emits the event
   * @param temperatureInDegree the new value
   * @param previousValue       the old value
   * @return the event
   */
  TemperatureChangedEvent createTemperatureChangedEvent(TemperatureSensor temperatureSensor,
                                                        DataWithTimestamp<Float> temperatureInDegree,
                                                        DataWithTimestamp<Float> previousValue
  );

  /**
   * Creates a {@link HumidityChangedEvent}.
   *
   * @param humiditySensor            the humidity sensor that emits the event
   * @param relativeHumidityInPercent the new value
   * @param previousValue             the old value
   * @return the event
   */
  HumidityChangedEvent createHumidityChangedEvent(HumiditySensor humiditySensor,
                                                  DataWithTimestamp<Float> relativeHumidityInPercent,
                                                  DataWithTimestamp<Float> previousValue
  );

  /**
   * Creates a {@link BatteryLevelChangedEvent}.
   *
   * @param batteryStateSensor    the battery state sensor that emits the event
   * @param batteryLevelInPercent the new value
   * @param previousValue         the old value
   * @return the event
   */
  BatteryLevelChangedEvent createBatteryLevelChangedEvent(BatteryStateSensor batteryStateSensor,
                                                          DataWithTimestamp<Integer> batteryLevelInPercent,
                                                          DataWithTimestamp<Integer> previousValue
  );

  /**
   * Creates a {@link DimmingLevelChangedEvent}.
   *
   * @param dimmer              the dimmer that emits the event
   * @param brightnessInPercent the new value
   * @param previousValue       the old value
   * @return the event
   */
  DimmingLevelChangedEvent createDimmingLevelChangedEvent(Dimmer dimmer,
                                                          DataWithTimestamp<Integer> brightnessInPercent,
                                                          DataWithTimestamp<Integer> previousValue
  );

  /**
   * Creates a {@link DevicesLoadedEvent}.
   *
   * @param devices the loaded devices
   * @return the event
   */
  DevicesLoadedEvent createDevicesLoadedEvent(List<Device> devices);

  /**
   * Creates a {@link NewDeviceCreatedEvent}.
   *
   * @param device the newly created device
   * @return the event
   */
  NewDeviceCreatedEvent createNewDeviceCreatedEvent(Device device);

  /**
   * Creates a {@link RollerStateChangedEvent}.
   *
   * @param roller        the roller that emits the event
   * @param state         the new value
   * @param previousValue the old value
   * @return the event
   */
  RollerStateChangedEvent createRollerStateChangedEvent(Roller roller,
                                                        DataWithTimestamp<RollerState> state,
                                                        DataWithTimestamp<RollerState> previousValue
  );

  /**
   * Creates a {@link RollerPositionChangedEvent}.
   *
   * @param roller            the roller that emits the event
   * @param positionInPercent the new value
   * @param previousValue     the old value
   * @return the event
   */
  RollerPositionChangedEvent createRollerPositionChangedEvent(Roller roller,
                                                              DataWithTimestamp<Integer> positionInPercent,
                                                              DataWithTimestamp<Integer> previousValue
  );

  /**
   * Creates a {@link IlluminanceChangedEvent}.
   *
   * @param sensor        the illuminance sensor that emits the event
   * @param lux           the new value
   * @param previousValue the old value
   * @return the event
   */
  IlluminanceChangedEvent createIlluminanceChangedEvent(IlluminanceSensor sensor,
                                                        DataWithTimestamp<Integer> lux,
                                                        DataWithTimestamp<Integer> previousValue
  );

  /**
   * Creates a {@link PowerChangedEvent}.
   *
   * @param sensor        the power sensor that emits the event
   * @param watt          the new value
   * @param previousValue the old value
   * @return the event
   */
  PowerChangedEvent createPowerChangedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue);
}