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

import io.github.davemeier82.homeautomation.core.device.DeviceId;
import io.github.davemeier82.homeautomation.core.device.property.AlarmState;
import io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId;
import io.github.davemeier82.homeautomation.core.device.property.RollerState;
import io.github.davemeier82.homeautomation.core.event.AlarmStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.AlarmStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.BatteryLevelChangedEvent;
import io.github.davemeier82.homeautomation.core.event.BatteryLevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.CloudBaseChangedEvent;
import io.github.davemeier82.homeautomation.core.event.CloudBaseUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.Co2LevelChangedEvent;
import io.github.davemeier82.homeautomation.core.event.Co2LevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.DataWithTimestamp;
import io.github.davemeier82.homeautomation.core.event.DimmingLevelChangedEvent;
import io.github.davemeier82.homeautomation.core.event.DimmingLevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.HumidityChangedEvent;
import io.github.davemeier82.homeautomation.core.event.HumidityUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.IlluminanceChangedEvent;
import io.github.davemeier82.homeautomation.core.event.IlluminanceUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.MotionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.MotionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.MqttClientConnectedEvent;
import io.github.davemeier82.homeautomation.core.event.NewDeviceCreatedEvent;
import io.github.davemeier82.homeautomation.core.event.NewDevicePropertyCreatedEvent;
import io.github.davemeier82.homeautomation.core.event.PowerChangedEvent;
import io.github.davemeier82.homeautomation.core.event.PowerUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.PressureChangedEvent;
import io.github.davemeier82.homeautomation.core.event.PressureUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.RainIntervalAmountChangedEvent;
import io.github.davemeier82.homeautomation.core.event.RainIntervalAmountUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.RainRateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.RainRateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.RainTodayAmountChangedEvent;
import io.github.davemeier82.homeautomation.core.event.RainTodayAmountUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.RelayStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.RelayStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.RollerPositionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.RollerPositionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.RollerStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.RollerStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.SmokeStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.SmokeStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.TemperatureChangedEvent;
import io.github.davemeier82.homeautomation.core.event.TemperatureUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.UvIndexChangedEvent;
import io.github.davemeier82.homeautomation.core.event.UvIndexUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.WindDirectionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindDirectionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.WindGustDirectionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindGustDirectionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.WindGustSpeedChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindGustSpeedUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.WindRunChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindRunUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.WindSpeedChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindSpeedUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.WindowStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindowStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.WindowTiltAngleChangedEvent;
import io.github.davemeier82.homeautomation.core.event.WindowTiltAngleUpdatedEvent;
import io.github.davemeier82.homeautomation.core.mqtt.MqttClient;

import java.util.Optional;

public interface EventFactory {

  Optional<Class<?>> fromEventName(String eventName);

  MotionChangedEvent createMotionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> motionDetected, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  MotionUpdatedEvent createMotionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> motionDetected, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  MqttClientConnectedEvent createMqttClientConnectedEvent(MqttClient client);

  RelayStateChangedEvent createRelayStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue, String displayName);

  RelayStateUpdatedEvent createRelayStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue, String displayName);

  WindowStateChangedEvent createWindowStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  WindowStateUpdatedEvent createWindowStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  SmokeStateChangedEvent createSmokeStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  SmokeStateUpdatedEvent createSmokeStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  TemperatureChangedEvent createTemperatureChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> temperatureInDegree, DataWithTimestamp<Float> previousValue, String displayName
  );

  TemperatureUpdatedEvent createTemperatureUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> temperatureInDegree, DataWithTimestamp<Float> previousValue, String displayName
  );

  HumidityChangedEvent createHumidityChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> relativeHumidityInPercent, DataWithTimestamp<Float> previousValue, String displayName
  );

  HumidityUpdatedEvent createHumidityUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> relativeHumidityInPercent, DataWithTimestamp<Float> previousValue, String displayName
  );

  BatteryLevelChangedEvent createBatteryLevelChangedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> batteryLevelInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  BatteryLevelUpdatedEvent createBatteryLevelUpdatedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> batteryLevelInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  DimmingLevelChangedEvent createDimmingLevelChangedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> brightnessInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  DimmingLevelUpdatedEvent createDimmingLevelUpdatedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> brightnessInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  NewDeviceCreatedEvent createNewDeviceCreatedEvent(DeviceId deviceId);

  RollerStateChangedEvent createRollerStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<RollerState> state, DataWithTimestamp<RollerState> previousValue, String displayName);

  RollerStateUpdatedEvent createRollerStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<RollerState> state, DataWithTimestamp<RollerState> previousValue, String displayName);

  AlarmStateChangedEvent createAlarmStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<AlarmState> state, DataWithTimestamp<AlarmState> previousValue, String displayName);

  AlarmStateUpdatedEvent createAlarmStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<AlarmState> state, DataWithTimestamp<AlarmState> previousValue, String displayName);

  RollerPositionChangedEvent createRollerPositionChangedEvent(DevicePropertyId devicePropertyId,
                                                              DataWithTimestamp<Integer> positionInPercent,
                                                              DataWithTimestamp<Integer> previousValue,
                                                              String displayName
  );

  RollerPositionUpdatedEvent createRollerPositionUpdatedEvent(DevicePropertyId devicePropertyId,
                                                              DataWithTimestamp<Integer> positionInPercent,
                                                              DataWithTimestamp<Integer> previousValue,
                                                              String displayName
  );

  IlluminanceChangedEvent createIlluminanceChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> lux, DataWithTimestamp<Integer> previousValue, String displayName);

  IlluminanceUpdatedEvent createIlluminanceUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> lux, DataWithTimestamp<Integer> previousValue, String displayName);

  Co2LevelUpdatedEvent createCo2LevelUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue, String displayName);

  Co2LevelChangedEvent createCo2LevelChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue, String displayName);

  PowerChangedEvent createPowerChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue, String displayName);

  PowerUpdatedEvent createPowerUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue, String displayName);

  CloudBaseChangedEvent createCloudBaseChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue, String displayName);

  CloudBaseUpdatedEvent createCloudBaseUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue, String displayName);

  PressureChangedEvent createPressureChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue, String displayName);

  PressureUpdatedEvent createPressureUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue, String displayName);

  UvIndexChangedEvent createUvIndexChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue, String displayName);

  UvIndexUpdatedEvent createUvIndexUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue, String displayName);

  RainRateChangedEvent createRainRateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue, String displayName);

  RainRateUpdatedEvent createRainRateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue, String displayName);

  RainIntervalAmountChangedEvent createRainIntervalAmountChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName
  );

  RainIntervalAmountUpdatedEvent createRainIntervalAmountUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName
  );

  RainTodayAmountChangedEvent createRainTodayAmountChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName);

  RainTodayAmountUpdatedEvent createRainTodayAmountUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName);

  WindSpeedChangedEvent createWindSpeedChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  WindSpeedUpdatedEvent createWindSpeedUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  WindGustSpeedChangedEvent createWindGustSpeedChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  WindGustSpeedUpdatedEvent createWindGustSpeedUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  WindDirectionChangedEvent createWindDirectionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  WindDirectionUpdatedEvent createWindDirectionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  WindGustDirectionChangedEvent createWindGustDirectionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  WindGustDirectionUpdatedEvent createWindGustDirectionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  WindRunChangedEvent createWindRunChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue, String displayName);

  WindRunUpdatedEvent createWindRunUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue, String displayName);

  NewDevicePropertyCreatedEvent createNewDevicePropertyCreatedEvent(DevicePropertyId devicePropertyId);

  WindowTiltAngleChangedEvent createWindowTiltAngleChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> newValue, DataWithTimestamp<Integer> previousValue, String displayName);

  WindowTiltAngleUpdatedEvent createWindowTiltAngleUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> newValue, DataWithTimestamp<Integer> previousValue, String displayName);
}
