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
import io.github.davemeier82.homeautomation.core.event.defaults.*;
import io.github.davemeier82.homeautomation.core.mqtt.MqttClient;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class DefaultEventFactory implements EventFactory {

  public static final String DEFAULT_EVENT_PACKAGE = "io.github.davemeier82.homeautomation.core.event.";

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
  public RelayStateChangedEvent createRelayStateChangedEvent(ReadOnlyRelay relay,
                                                             DataWithTimestamp<Boolean> isOn,
                                                             DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultRelayStateChangedPropertyEvent(relay, isOn, previousValue);
  }

  @Override
  public WindowStateChangedEvent createWindowStateChangedEvent(WindowSensor windowSensor,
                                                               DataWithTimestamp<Boolean> isOpen,
                                                               DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultWindowStateChangedPropertyEvent(windowSensor, isOpen, previousValue);
  }

  @Override
  public TemperatureChangedEvent createTemperatureChangedEvent(TemperatureSensor temperatureSensor,
                                                               DataWithTimestamp<Float> temperatureInDegree,
                                                               DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultTemperatureChangedPropertyEvent(temperatureSensor, temperatureInDegree, previousValue);
  }

  @Override
  public HumidityChangedEvent createHumidityChangedEvent(HumiditySensor humiditySensor,
                                                         DataWithTimestamp<Float> relativeHumidityInPercent,
                                                         DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultHumidityChangedPropertyEvent(humiditySensor, relativeHumidityInPercent, previousValue);
  }

  @Override
  public BatteryLevelChangedEvent createBatteryLevelChangedEvent(BatteryStateSensor batteryStateSensor,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultBatteryLevelChangedPropertyEvent(batteryStateSensor, batteryLevelInPercent, previousValue);
  }

  @Override
  public DimmingLevelChangedEvent createDimmingLevelChangedEvent(Dimmer dimmer,
                                                                 DataWithTimestamp<Integer> levelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultDimmingLevelChangedPropertyEvent(dimmer, levelInPercent, previousValue);
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
  public RollerStateChangedEvent createRollerStateChangedEvent(Roller roller,
                                                               DataWithTimestamp<RollerState> state,
                                                               DataWithTimestamp<RollerState> previousValue
  ) {
    return new DefaultRollerStateChangedPropertyEvent(roller, state, previousValue);
  }

  @Override
  public RollerPositionChangedEvent createRollerPositionChangedEvent(Roller roller,
                                                                     DataWithTimestamp<Integer> positionInPercent,
                                                                     DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultRollerPositionChangedPropertyEvent(roller, positionInPercent, previousValue);
  }

  @Override
  public IlluminanceChangedEvent createIlluminanceChangedEvent(IlluminanceSensor sensor,
                                                               DataWithTimestamp<Integer> lux,
                                                               DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultIlluminanceChangedPropertyEvent(sensor, lux, previousValue);
  }

  @Override
  public PowerChangedEvent createPowerChangedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue) {
    return new DefaultPowerChangedPropertyEvent(sensor, watt, previousValue);
  }
}
