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
import io.github.davemeier82.homeautomation.core.event.LightningCountChangedEvent;
import io.github.davemeier82.homeautomation.core.event.LightningCountUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.LightningDistanceChangedEvent;
import io.github.davemeier82.homeautomation.core.event.LightningDistanceUpdatedEvent;
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
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultAlarmStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultAlarmStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultBatteryLevelChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultBatteryLevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultCloudBaseChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultCloudBaseUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultCo2LevelChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultCo2LevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultDimmingLevelChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultDimmingLevelUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultHumidityChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultHumidityUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultIlluminanceChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultIlluminanceUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultLightningCountChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultLightningCountUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultLightningDistanceChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultLightningDistanceUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultMotionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultMotionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultMqttClientConnectedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultNewDeviceCreatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultNewDeviceEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultPowerChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultPowerUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultPressureChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultPressureUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRainIntervalAmountChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRainIntervalAmountUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRainRateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRainRateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRainTodayAmountChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRainTodayAmountUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRelayStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRelayStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRollerPositionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRollerPositionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRollerStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultRollerStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultSmokeStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultSmokeStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultTemperatureChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultTemperatureUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultUvIndexChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultUvIndexUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindDirectionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindDirectionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindGustDirectionChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindGustDirectionUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindGustSpeedChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindGustSpeedUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindRunChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindRunUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindSpeedChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindSpeedUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindowStateChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindowStateUpdatedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindowTiltAngleChangedEvent;
import io.github.davemeier82.homeautomation.core.event.defaults.DefaultWindowTiltAngleUpdatedEvent;
import io.github.davemeier82.homeautomation.core.mqtt.MqttClient;

import java.util.Optional;

public class DefaultEventFactory implements EventFactory {

  private static final String DEFAULT_EVENT_PACKAGE = "io.github.davemeier82.homeautomation.core.event.";

  @Override
  public Optional<Class<?>> fromEventName(String eventName) {
    try {
      return Optional.of(Class.forName(DEFAULT_EVENT_PACKAGE + eventName));
    } catch (ClassNotFoundException e) {
      return Optional.empty();
    }
  }

  @Override
  public MotionChangedEvent createMotionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> motionDetected, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultMotionChangedEvent(devicePropertyId, displayName, motionDetected, previousValue);
  }

  @Override
  public MotionUpdatedEvent createMotionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> motionDetected, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultMotionUpdatedEvent(devicePropertyId, displayName, motionDetected, previousValue);
  }

  @Override
  public MqttClientConnectedEvent createMqttClientConnectedEvent(MqttClient client) {
    return new DefaultMqttClientConnectedEvent(client);
  }

  @Override
  public RelayStateChangedEvent createRelayStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultRelayStateChangedEvent(devicePropertyId, displayName, isOn, previousValue);
  }

  @Override
  public RelayStateUpdatedEvent createRelayStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultRelayStateUpdatedEvent(devicePropertyId, displayName, isOn, previousValue);
  }

  @Override
  public WindowStateChangedEvent createWindowStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultWindowStateChangedEvent(devicePropertyId, displayName, isOpen, previousValue);
  }

  @Override
  public WindowStateUpdatedEvent createWindowStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultWindowStateUpdatedEvent(devicePropertyId, displayName, isOpen, previousValue);
  }

  @Override
  public SmokeStateChangedEvent createSmokeStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isActive, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultSmokeStateChangedEvent(devicePropertyId, displayName, isActive, previousValue);
  }

  @Override
  public SmokeStateUpdatedEvent createSmokeStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isActive, DataWithTimestamp<Boolean> previousValue, String displayName
  ) {
    return new DefaultSmokeStateUpdatedEvent(devicePropertyId, displayName, isActive, previousValue);
  }

  @Override
  public TemperatureChangedEvent createTemperatureChangedEvent(DevicePropertyId devicePropertyId,
                                                               DataWithTimestamp<Float> temperatureInDegree,
                                                               DataWithTimestamp<Float> previousValue,
                                                               String displayName
  ) {
    return new DefaultTemperatureChangedEvent(devicePropertyId, displayName, temperatureInDegree, previousValue);
  }

  @Override
  public TemperatureUpdatedEvent createTemperatureUpdatedEvent(DevicePropertyId devicePropertyId,
                                                               DataWithTimestamp<Float> temperatureInDegree,
                                                               DataWithTimestamp<Float> previousValue,
                                                               String displayName
  ) {
    return new DefaultTemperatureUpdatedEvent(devicePropertyId, displayName, temperatureInDegree, previousValue);
  }

  @Override
  public HumidityChangedEvent createHumidityChangedEvent(DevicePropertyId devicePropertyId,
                                                         DataWithTimestamp<Float> relativeHumidityInPercent,
                                                         DataWithTimestamp<Float> previousValue,
                                                         String displayName
  ) {
    return new DefaultHumidityChangedEvent(devicePropertyId, displayName, relativeHumidityInPercent, previousValue);
  }

  @Override
  public HumidityUpdatedEvent createHumidityUpdatedEvent(DevicePropertyId devicePropertyId,
                                                         DataWithTimestamp<Float> relativeHumidityInPercent,
                                                         DataWithTimestamp<Float> previousValue,
                                                         String displayName
  ) {
    return new DefaultHumidityUpdatedEvent(devicePropertyId, displayName, relativeHumidityInPercent, previousValue);
  }

  @Override
  public BatteryLevelChangedEvent createBatteryLevelChangedEvent(DevicePropertyId devicePropertyId,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue,
                                                                 String displayName
  ) {
    return new DefaultBatteryLevelChangedEvent(devicePropertyId, displayName, batteryLevelInPercent, previousValue);
  }

  @Override
  public BatteryLevelUpdatedEvent createBatteryLevelUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue,
                                                                 String displayName
  ) {
    return new DefaultBatteryLevelUpdatedEvent(devicePropertyId, displayName, batteryLevelInPercent, previousValue);
  }

  @Override
  public DimmingLevelChangedEvent createDimmingLevelChangedEvent(DevicePropertyId devicePropertyId,
                                                                 DataWithTimestamp<Integer> levelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue,
                                                                 String displayName
  ) {
    return new DefaultDimmingLevelChangedEvent(devicePropertyId, displayName, levelInPercent, previousValue);
  }

  @Override
  public DimmingLevelUpdatedEvent createDimmingLevelUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                 DataWithTimestamp<Integer> brightnessInPercent,
                                                                 DataWithTimestamp<Integer> previousValue,
                                                                 String displayName
  ) {
    return new DefaultDimmingLevelUpdatedEvent(devicePropertyId, displayName, brightnessInPercent, previousValue);
  }

  @Override
  public NewDeviceCreatedEvent createNewDeviceCreatedEvent(DeviceId deviceId) {
    return new DefaultNewDeviceCreatedEvent(deviceId);
  }

  @Override
  public RollerStateChangedEvent createRollerStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<RollerState> state, DataWithTimestamp<RollerState> previousValue, String displayName
  ) {
    return new DefaultRollerStateChangedEvent(devicePropertyId, displayName, state, previousValue);
  }

  @Override
  public RollerStateUpdatedEvent createRollerStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<RollerState> state, DataWithTimestamp<RollerState> previousValue, String displayName
  ) {
    return new DefaultRollerStateUpdatedEvent(devicePropertyId, displayName, state, previousValue);
  }

  @Override
  public AlarmStateChangedEvent createAlarmStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<AlarmState> state, DataWithTimestamp<AlarmState> previousValue, String displayName
  ) {
    return new DefaultAlarmStateChangedEvent(devicePropertyId, displayName, state, previousValue);
  }

  @Override
  public AlarmStateUpdatedEvent createAlarmStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<AlarmState> state, DataWithTimestamp<AlarmState> previousValue, String displayName
  ) {
    return new DefaultAlarmStateUpdatedEvent(devicePropertyId, displayName, state, previousValue);
  }

  @Override
  public RollerPositionChangedEvent createRollerPositionChangedEvent(DevicePropertyId devicePropertyId,
                                                                     DataWithTimestamp<Integer> positionInPercent,
                                                                     DataWithTimestamp<Integer> previousValue,
                                                                     String displayName
  ) {
    return new DefaultRollerPositionChangedEvent(devicePropertyId, displayName, positionInPercent, previousValue);
  }

  @Override
  public RollerPositionUpdatedEvent createRollerPositionUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                     DataWithTimestamp<Integer> positionInPercent,
                                                                     DataWithTimestamp<Integer> previousValue,
                                                                     String displayName
  ) {
    return new DefaultRollerPositionUpdatedEvent(devicePropertyId, displayName, positionInPercent, previousValue);
  }

  @Override
  public IlluminanceChangedEvent createIlluminanceChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> lux, DataWithTimestamp<Integer> previousValue, String displayName
  ) {
    return new DefaultIlluminanceChangedEvent(devicePropertyId, displayName, lux, previousValue);
  }

  @Override
  public IlluminanceUpdatedEvent createIlluminanceUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> lux, DataWithTimestamp<Integer> previousValue, String displayName
  ) {
    return new DefaultIlluminanceUpdatedEvent(devicePropertyId, displayName, lux, previousValue);
  }

  @Override
  public Co2LevelUpdatedEvent createCo2LevelUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue, String displayName
  ) {
    return new DefaultCo2LevelUpdatedEvent(devicePropertyId, displayName, ppm, previousValue);
  }

  @Override
  public Co2LevelChangedEvent createCo2LevelChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue, String displayName
  ) {
    return new DefaultCo2LevelChangedEvent(devicePropertyId, displayName, ppm, previousValue);
  }

  @Override
  public PowerChangedEvent createPowerChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue, String displayName
  ) {
    return new DefaultPowerChangedEvent(devicePropertyId, displayName, watt, previousValue);
  }

  @Override
  public PowerUpdatedEvent createPowerUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue, String displayName
  ) {
    return new DefaultPowerUpdatedEvent(devicePropertyId, displayName, watt, previousValue);
  }

  @Override
  public CloudBaseChangedEvent createCloudBaseChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultCloudBaseChangedEvent(devicePropertyId, displayName, meter, previousValue);
  }

  @Override
  public CloudBaseUpdatedEvent createCloudBaseUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultCloudBaseUpdatedEvent(devicePropertyId, displayName, meter, previousValue);
  }

  @Override
  public PressureChangedEvent createPressureChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultPressureChangedEvent(devicePropertyId, displayName, mbar, previousValue);
  }

  @Override
  public PressureUpdatedEvent createPressureUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultPressureUpdatedEvent(devicePropertyId, displayName, mbar, previousValue);
  }

  @Override
  public UvIndexChangedEvent createUvIndexChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultUvIndexChangedEvent(devicePropertyId, displayName, uvIndex, previousValue);
  }

  @Override
  public UvIndexUpdatedEvent createUvIndexUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultUvIndexUpdatedEvent(devicePropertyId, displayName, uvIndex, previousValue);
  }

  @Override
  public RainRateChangedEvent createRainRateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultRainRateChangedEvent(devicePropertyId, displayName, millimeterPerHour, previousValue);
  }

  @Override
  public RainRateUpdatedEvent createRainRateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultRainRateUpdatedEvent(devicePropertyId, displayName, millimeterPerHour, previousValue);
  }

  @Override
  public RainIntervalAmountChangedEvent createRainIntervalAmountChangedEvent(DevicePropertyId devicePropertyId,
                                                                             DataWithTimestamp<Float> millimeter,
                                                                             DataWithTimestamp<Float> previousValue,
                                                                             String displayName
  ) {
    return new DefaultRainIntervalAmountChangedEvent(devicePropertyId, displayName, millimeter, previousValue);
  }

  @Override
  public RainIntervalAmountUpdatedEvent createRainIntervalAmountUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                             DataWithTimestamp<Float> millimeter,
                                                                             DataWithTimestamp<Float> previousValue,
                                                                             String displayName
  ) {
    return new DefaultRainIntervalAmountUpdatedEvent(devicePropertyId, displayName, millimeter, previousValue);
  }

  @Override
  public RainTodayAmountChangedEvent createRainTodayAmountChangedEvent(DevicePropertyId devicePropertyId,
                                                                       DataWithTimestamp<Float> millimeter,
                                                                       DataWithTimestamp<Float> previousValue,
                                                                       String displayName
  ) {
    return new DefaultRainTodayAmountChangedEvent(devicePropertyId, displayName, millimeter, previousValue);
  }

  @Override
  public RainTodayAmountUpdatedEvent createRainTodayAmountUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                       DataWithTimestamp<Float> millimeter,
                                                                       DataWithTimestamp<Float> previousValue,
                                                                       String displayName
  ) {
    return new DefaultRainTodayAmountUpdatedEvent(devicePropertyId, displayName, millimeter, previousValue);
  }

  @Override
  public WindSpeedChangedEvent createWindSpeedChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultWindSpeedChangedEvent(devicePropertyId, displayName, kmh, previousValue);
  }

  @Override
  public WindSpeedUpdatedEvent createWindSpeedUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultWindSpeedUpdatedEvent(devicePropertyId, displayName, kmh, previousValue);
  }

  @Override
  public WindGustSpeedChangedEvent createWindGustSpeedChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultWindGustSpeedChangedEvent(devicePropertyId, displayName, kmh, previousValue);
  }

  @Override
  public WindGustSpeedUpdatedEvent createWindGustSpeedUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultWindGustSpeedUpdatedEvent(devicePropertyId, displayName, kmh, previousValue);
  }

  @Override
  public WindDirectionChangedEvent createWindDirectionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultWindDirectionChangedEvent(devicePropertyId, displayName, degree, previousValue);
  }

  @Override
  public WindDirectionUpdatedEvent createWindDirectionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName
  ) {
    return new DefaultWindDirectionUpdatedEvent(devicePropertyId, displayName, degree, previousValue);
  }

  @Override
  public WindGustDirectionChangedEvent createWindGustDirectionChangedEvent(DevicePropertyId devicePropertyId,
                                                                           DataWithTimestamp<Float> degree,
                                                                           DataWithTimestamp<Float> previousValue,
                                                                           String displayName
  ) {
    return new DefaultWindGustDirectionChangedEvent(devicePropertyId, displayName, degree, previousValue);
  }

  @Override
  public WindGustDirectionUpdatedEvent createWindGustDirectionUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                           DataWithTimestamp<Float> degree,
                                                                           DataWithTimestamp<Float> previousValue,
                                                                           String displayName
  ) {
    return new DefaultWindGustDirectionUpdatedEvent(devicePropertyId, displayName, degree, previousValue);
  }

  @Override
  public WindRunChangedEvent createWindRunChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue, String displayName) {
    return new DefaultWindRunChangedEvent(devicePropertyId, displayName, km, previousValue);
  }

  @Override
  public WindRunUpdatedEvent createWindRunUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue, String displayName) {
    return new DefaultWindRunUpdatedEvent(devicePropertyId, displayName, km, previousValue);
  }

  @Override
  public NewDevicePropertyCreatedEvent createNewDevicePropertyCreatedEvent(DevicePropertyId devicePropertyId) {
    return new DefaultNewDeviceEvent(devicePropertyId);
  }

  @Override
  public WindowTiltAngleChangedEvent createWindowTiltAngleChangedEvent(DevicePropertyId devicePropertyId,
                                                                       DataWithTimestamp<Integer> newValue,
                                                                       DataWithTimestamp<Integer> previousValue,
                                                                       String displayName
  ) {
    return new DefaultWindowTiltAngleChangedEvent(devicePropertyId, displayName, newValue, previousValue);
  }

  @Override
  public WindowTiltAngleUpdatedEvent createWindowTiltAngleUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                       DataWithTimestamp<Integer> newValue,
                                                                       DataWithTimestamp<Integer> previousValue,
                                                                       String displayName
  ) {
    return new DefaultWindowTiltAngleUpdatedEvent(devicePropertyId, displayName, newValue, previousValue);
  }

  @Override
  public LightningCountChangedEvent createLightningCountChangedEvent(DevicePropertyId devicePropertyId,
                                                                     DataWithTimestamp<Integer> newValue,
                                                                     DataWithTimestamp<Integer> previousValue,
                                                                     String displayName
  ) {
    return new DefaultLightningCountChangedEvent(devicePropertyId, displayName, newValue, previousValue);
  }

  @Override
  public LightningCountUpdatedEvent createLightningCountUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                     DataWithTimestamp<Integer> newValue,
                                                                     DataWithTimestamp<Integer> previousValue,
                                                                     String displayName
  ) {
    return new DefaultLightningCountUpdatedEvent(devicePropertyId, displayName, newValue, previousValue);
  }

  @Override
  public LightningDistanceChangedEvent createLightningDistanceChangedEvent(DevicePropertyId devicePropertyId,
                                                                           DataWithTimestamp<Integer> newValue,
                                                                           DataWithTimestamp<Integer> previousValue,
                                                                           String displayName
  ) {
    return new DefaultLightningDistanceChangedEvent(devicePropertyId, displayName, newValue, previousValue);
  }

  @Override
  public LightningDistanceUpdatedEvent createLightningDistanceUpdatedEvent(DevicePropertyId devicePropertyId,
                                                                           DataWithTimestamp<Integer> newValue,
                                                                           DataWithTimestamp<Integer> previousValue,
                                                                           String displayName
  ) {
    return new DefaultLightningDistanceUpdatedEvent(devicePropertyId, displayName, newValue, previousValue);
  }
}
