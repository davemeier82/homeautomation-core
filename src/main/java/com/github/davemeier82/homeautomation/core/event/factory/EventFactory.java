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

package com.github.davemeier82.homeautomation.core.event.factory;

import com.github.davemeier82.homeautomation.core.device.Device;
import com.github.davemeier82.homeautomation.core.device.property.*;
import com.github.davemeier82.homeautomation.core.event.*;
import com.github.davemeier82.homeautomation.core.mqtt.MqttClient;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public interface EventFactory {

  Optional<Class<?>> fromEventName(String eventName);

  MotionDetectedEvent createMotionDetectedEvent(MotionSensor sensor, ZonedDateTime eventTime);

  MqttClientConnectedEvent createMqttClientConnectedEvent(MqttClient client);

  RelayStateChangedEvent createRelayStateChangedEvent(ReadOnlyRelay relay, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue);

  WindowStateChangedEvent createWindowStateChangedEvent(WindowSensor windowSensor,
                                                        DataWithTimestamp<Boolean> isOpen,
                                                        DataWithTimestamp<Boolean> previousValue
  );

  TemperatureChangedEvent createTemperatureChangedEvent(TemperatureSensor temperatureSensor,
                                                        DataWithTimestamp<Float> temperatureInDegree,
                                                        DataWithTimestamp<Float> previousValue
  );

  HumidityChangedEvent createHumidityChangedEvent(HumiditySensor humiditySensor,
                                                  DataWithTimestamp<Float> relativeHumidityInPercent,
                                                  DataWithTimestamp<Float> previousValue
  );

  BatteryLevelChangedEvent createBatteryLevelChangedEvent(BatteryStateSensor batteryStateSensor,
                                                          DataWithTimestamp<Integer> batteryLevelInPercent,
                                                          DataWithTimestamp<Integer> previousValue
  );

  DimmingLevelChangedEvent createDimmingLevelChangedEvent(Dimmer dimmer,
                                                          DataWithTimestamp<Integer> brightnessInPercent,
                                                          DataWithTimestamp<Integer> previousValue
  );

  DevicesLoadedEvent createDevicesLoadedEvent(List<Device> devices);

  NewDeviceCreatedEvent createNewDeviceCreatedEvent(Device device);

  RollerStateChangedEvent createRollerStateChangedEvent(Roller roller,
                                                        DataWithTimestamp<RollerState> state,
                                                        DataWithTimestamp<RollerState> previousValue
  );

  RollerPositionChangedEvent createRollerPositionChangedEvent(Roller roller,
                                                              DataWithTimestamp<Integer> positionInPercent,
                                                              DataWithTimestamp<Integer> previousValue
  );

  IlluminanceChangedEvent createIlluminanceChangedEvent(IlluminanceSensor sensor,
                                                        DataWithTimestamp<Integer> lux,
                                                        DataWithTimestamp<Integer> previousValue
  );

  PowerChangedEvent createPowerChangedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue);
}
