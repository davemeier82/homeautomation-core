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
import com.github.davemeier82.homeautomation.core.event.defaults.*;
import com.github.davemeier82.homeautomation.core.mqtt.MqttClient;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class DefaultEventFactory implements EventFactory {

  public static final String DEFAULT_EVENT_PACKAGE = "com.github.davemeier82.homeautomation.core.event.";

  @Override
  public Optional<Class<?>> fromEventName(String eventName) {
    try {
      return Optional.of(Class.forName(DEFAULT_EVENT_PACKAGE + eventName));
    } catch (ClassNotFoundException e) {
      return Optional.empty();
    }
  }

  @Override
  public MotionDetectedEvent createMotionDetectedEvent(MotionSensor sensor, ZonedDateTime eventTime) {
    return new DefaultMotionDetectedPropertyEvent(sensor, eventTime);
  }

  @Override
  public MqttClientConnectedEvent createMqttClientConnectedEvent(MqttClient client) {
    return new DefaultMqttClientConnectedEvent(client);
  }

  @Override
  public RelayStateChangedEvent createRelayStateChangedEvent(ReadOnlyRelay relay, DataWithTimestamp<Boolean> isOn) {
    return new DefaultRelayStateChangedPropertyEvent(relay, isOn);
  }

  @Override
  public WindowStateChangedEvent createWindowStateChangedEvent(WindowSensor windowSensor, DataWithTimestamp<Boolean> isOpen) {
    return new DefaultWindowStateChangedPropertyEvent(windowSensor, isOpen);
  }

  @Override
  public TemperatureChangedEvent createTemperatureChangedEvent(TemperatureSensor temperatureSensor, DataWithTimestamp<Float> temperatureInDegree) {
    return new DefaultTemperatureChangedPropertyEvent(temperatureSensor, temperatureInDegree);
  }

  @Override
  public HumidityChangedEvent createHumidityChangedEvent(HumiditySensor humiditySensor, DataWithTimestamp<Float> relativeHumidityInPercent) {
    return new DefaultHumidityChangedPropertyEvent(humiditySensor, relativeHumidityInPercent);
  }

  @Override
  public BatteryLevelChangedEvent createBatteryLevelChangedEvent(BatteryStateSensor batteryStateSensor,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent
  ) {
    return new DefaultBatteryLevelChangedPropertyEvent(batteryStateSensor, batteryLevelInPercent);
  }

  @Override
  public DimmingLevelChangedEvent createDimmingLevelChangedEvent(Dimmer dimmer, DataWithTimestamp<Integer> levelInPercent) {
    return new DefaultDimmingLevelChangedPropertyEvent(dimmer, levelInPercent);
  }

  @Override
  public DevicesLoadedEvent createDevicesLoadedEvent(List<Device> devices) {
    return new DefaultDevicesLoadedEvent(devices);
  }

  @Override
  public NewDeviceCreatedEvent createNewDeviceCreatedEvent(Device device) {
    return new DefaultNewDeviceCreatedEvent(device);
  }

  @Override
  public RollerStateChangedEvent createRollerStateChangedEvent(Roller roller, DataWithTimestamp<RollerState> state) {
    return new DefaultRollerStateChangedPropertyEvent(roller, state);
  }

  @Override
  public RollerPositionChangedEvent createRollerPositionChangedEvent(Roller roller, DataWithTimestamp<Integer> positionInPercent) {
    return new DefaultRollerPositionChangedPropertyEvent(roller, positionInPercent);
  }

  @Override
  public IlluminanceChangedEvent createIlluminanceChangedEvent(IlluminanceSensor sensor, DataWithTimestamp<Integer> lux) {
    return new DefaultIlluminanceChangedPropertyEvent(sensor, lux);
  }

  @Override
  public PowerChangedEvent createPowerChangedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt) {
    return new DefaultPowerChangedPropertyEvent(sensor, watt);
  }
}
