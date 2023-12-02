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

import java.util.List;
import java.util.Optional;

/**
 * Default implementation of a {@link EventFactory}.
 *
 * @author David Meier
 * @since 0.1.0
 */
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
  public MotionChangedEvent createMotionChangedEvent(MotionSensor sensor,
                                                     DataWithTimestamp<Boolean> motionDetected,
                                                     DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultMotionChangedPropertyEvent(sensor, motionDetected, previousValue);
  }

  @Override
  public MotionUpdatedEvent createMotionUpdatedEvent(MotionSensor sensor,
                                                     DataWithTimestamp<Boolean> motionDetected,
                                                     DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultMotionUpdatedPropertyEvent(sensor, motionDetected, previousValue);
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
  public RelayStateUpdatedEvent createRelayStateUpdatedEvent(ReadOnlyRelay relay,
                                                             DataWithTimestamp<Boolean> isOn,
                                                             DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultRelayStateUpdatedPropertyEvent(relay, isOn, previousValue);
  }

  @Override
  public WindowStateChangedEvent createWindowStateChangedEvent(WindowSensor windowSensor,
                                                               DataWithTimestamp<Boolean> isOpen,
                                                               DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultWindowStateChangedPropertyEvent(windowSensor, isOpen, previousValue);
  }

  @Override
  public WindowStateUpdatedEvent createWindowStateUpdatedEvent(WindowSensor windowSensor,
                                                               DataWithTimestamp<Boolean> isOpen,
                                                               DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultWindowStateUpdatedPropertyEvent(windowSensor, isOpen, previousValue);
  }

  @Override
  public SmokeStateChangedEvent createSmokeStateChangedEvent(SmokeSensor smokeSensor,
                                                             DataWithTimestamp<Boolean> isActive,
                                                             DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultSmokeStateChangedPropertyEvent(smokeSensor, isActive, previousValue);
  }

  @Override
  public SmokeStateUpdatedEvent createSmokeStateUpdatedEvent(SmokeSensor smokeSensor,
                                                             DataWithTimestamp<Boolean> isActive,
                                                             DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultSmokeStateUpdatedPropertyEvent(smokeSensor, isActive, previousValue);
  }

  @Override
  public TemperatureChangedEvent createTemperatureChangedEvent(TemperatureSensor temperatureSensor,
                                                               DataWithTimestamp<Float> temperatureInDegree,
                                                               DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultTemperatureChangedPropertyEvent(temperatureSensor, temperatureInDegree, previousValue);
  }

  @Override
  public TemperatureUpdatedEvent createTemperatureUpdatedEvent(TemperatureSensor temperatureSensor,
                                                               DataWithTimestamp<Float> temperatureInDegree,
                                                               DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultTemperatureUpdatedPropertyEvent(temperatureSensor, temperatureInDegree, previousValue);
  }

  @Override
  public HumidityChangedEvent createHumidityChangedEvent(HumiditySensor humiditySensor,
                                                         DataWithTimestamp<Float> relativeHumidityInPercent,
                                                         DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultHumidityChangedPropertyEvent(humiditySensor, relativeHumidityInPercent, previousValue);
  }

  @Override
  public HumidityUpdatedEvent createHumidityUpdatedEvent(HumiditySensor humiditySensor,
                                                         DataWithTimestamp<Float> relativeHumidityInPercent,
                                                         DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultHumidityUpdatedPropertyEvent(humiditySensor, relativeHumidityInPercent, previousValue);
  }

  @Override
  public BatteryLevelChangedEvent createBatteryLevelChangedEvent(BatteryStateSensor batteryStateSensor,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultBatteryLevelChangedPropertyEvent(batteryStateSensor, batteryLevelInPercent, previousValue);
  }

  @Override
  public BatteryLevelUpdatedEvent createBatteryLevelUpdatedEvent(BatteryStateSensor batteryStateSensor,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultBatteryLevelUpdatedPropertyEvent(batteryStateSensor, batteryLevelInPercent, previousValue);
  }

  @Override
  public DimmingLevelChangedEvent createDimmingLevelChangedEvent(Dimmer dimmer,
                                                                 DataWithTimestamp<Integer> levelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultDimmingLevelChangedPropertyEvent(dimmer, levelInPercent, previousValue);
  }

  @Override
  public DimmingLevelUpdatedEvent createDimmingLevelUpdatedEvent(Dimmer dimmer,
                                                                 DataWithTimestamp<Integer> brightnessInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultDimmingLevelUpdatedPropertyEvent(dimmer, brightnessInPercent, previousValue);
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
  public RollerStateUpdatedEvent createRollerStateUpdatedEvent(Roller roller,
                                                               DataWithTimestamp<RollerState> state,
                                                               DataWithTimestamp<RollerState> previousValue
  ) {
    return new DefaultRollerStateUpdatedPropertyEvent(roller, state, previousValue);
  }

  @Override
  public AlarmStateChangedEvent createAlarmStateChangedEvent(Alarm alarm,
                                                             DataWithTimestamp<AlarmState> state,
                                                             DataWithTimestamp<AlarmState> previousValue
  ) {
    return new DefaultAlarmStateChangedPropertyEvent(alarm, state, previousValue);
  }

  @Override
  public AlarmStateUpdatedEvent createAlarmStateUpdatedEvent(Alarm alarm,
                                                             DataWithTimestamp<AlarmState> state,
                                                             DataWithTimestamp<AlarmState> previousValue
  ) {
    return new DefaultAlarmStateUpdatedPropertyEvent(alarm, state, previousValue);
  }

  @Override
  public RollerPositionChangedEvent createRollerPositionChangedEvent(Roller roller,
                                                                     DataWithTimestamp<Integer> positionInPercent,
                                                                     DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultRollerPositionChangedPropertyEvent(roller, positionInPercent, previousValue);
  }

  @Override
  public RollerPositionUpdatedEvent createRollerPositionUpdatedEvent(Roller roller,
                                                                     DataWithTimestamp<Integer> positionInPercent,
                                                                     DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultRollerPositionUpdatedPropertyEvent(roller, positionInPercent, previousValue);
  }

  @Override
  public IlluminanceChangedEvent createIlluminanceChangedEvent(IlluminanceSensor sensor,
                                                               DataWithTimestamp<Integer> lux,
                                                               DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultIlluminanceChangedPropertyEvent(sensor, lux, previousValue);
  }

  @Override
  public IlluminanceUpdatedEvent createIlluminanceUpdatedEvent(IlluminanceSensor sensor,
                                                               DataWithTimestamp<Integer> lux,
                                                               DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultIlluminanceUpdatedPropertyEvent(sensor, lux, previousValue);
  }

  @Override
  public Co2LevelUpdatedEvent createCo2LevelUpdatedEvent(Co2Sensor sensor, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue) {
    return new DefaultICo2LevelUpdatedPropertyEvent(sensor, ppm, previousValue);
  }

  @Override
  public Co2LevelChangedEvent createCo2LevelChangedEvent(Co2Sensor sensor, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue) {
    return new DefaultICo2LevelChangedPropertyEvent(sensor, ppm, previousValue);
  }

  @Override
  public PowerChangedEvent createPowerChangedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue) {
    return new DefaultPowerChangedPropertyEvent(sensor, watt, previousValue);
  }

  @Override
  public PowerUpdatedEvent createPowerUpdatedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue) {
    return new DefaultPowerUpdatedPropertyEvent(sensor, watt, previousValue);
  }

  @Override
  public CloudBaseChangedEvent createCloudBaseChangedEvent(CloudBaseSensor sensor, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue) {
    return new DefaultCloudBaseChangedPropertyEvent(sensor, meter, previousValue) ;
  }

  @Override
  public CloudBaseUpdatedEvent createCloudBaseUpdatedEvent(CloudBaseSensor sensor, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue) {
    return new DefaultCloudBaseUpdatedPropertyEvent(sensor, meter, previousValue);
  }

  @Override
  public PressureChangedEvent createPressureChangedEvent(PressureSensor sensor, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue) {
    return new DefaultPressureChangedPropertyEvent(sensor, mbar, previousValue);
  }

  @Override
  public PressureUpdatedEvent createPressureUpdatedEvent(PressureSensor sensor, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue) {
    return new DefaultPressureUpdatedPropertyEvent(sensor, mbar, previousValue);
  }

  @Override
  public UvIndexChangedEvent createUvIndexChangedEvent(UvSensor sensor, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue) {
    return new DefaultUvIndexChangedPropertyEvent(sensor, uvIndex, previousValue);
  }

  @Override
  public UvIndexUpdatedEvent createUvIndexUpdatedEvent(UvSensor sensor, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue) {
    return new DefaultUvIndexUpdatedPropertyEvent(sensor, uvIndex, previousValue);
  }

  @Override
  public RainRateChangedEvent createRainRateChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainRateChangedPropertyEvent(sensor, millimeterPerHour, previousValue);
  }

  @Override
  public RainRateUpdatedEvent createRainRateUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainRateUpdatedPropertyEvent(sensor, millimeterPerHour, previousValue);
  }

  @Override
  public RainIntervalAmountChangedEvent createRainIntervalAmountChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainIntervalAmountChangedPropertyEvent(sensor, millimeter, previousValue);
  }

  @Override
  public RainIntervalAmountUpdatedEvent createRainIntervalAmountUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainIntervalAmountUpdatedPropertyEvent(sensor, millimeter, previousValue);
  }

  @Override
  public RainTodayAmountChangedEvent createRainTodayAmountChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainTodayAmountChangedPropertyEvent(sensor, millimeter, previousValue);
  }

  @Override
  public RainTodayAmountUpdatedEvent createRainTodayAmountUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainTodayAmountUpdatedPropertyEvent(sensor, millimeter, previousValue);
  }

  @Override
  public WindSpeedChangedEvent createWindSpeedChangedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindSpeedChangedPropertyEvent(sensor, kmh, previousValue);
  }

  @Override
  public WindSpeedUpdatedEvent createWindSpeedUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindSpeedUpdatedPropertyEvent(sensor, kmh, previousValue);
  }

  @Override
  public WindGustSpeedChangedEvent createWindGustSpeedChangedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustSpeedChangedPropertyEvent(sensor, kmh, previousValue);
  }

  @Override
  public WindGustSpeedUpdatedEvent createWindGustSpeedUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustSpeedUpdatedPropertyEvent(sensor, kmh, previousValue);
  }

  @Override
  public WindDirectionChangedEvent createWindDirectionChangedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindDirectionChangedPropertyEvent(sensor, degree, previousValue);
  }

  @Override
  public WindDirectionUpdatedEvent createWindDirectionUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindDirectionUpdatedPropertyEvent(sensor, degree, previousValue);
  }

  @Override
  public WindGustDirectionChangedEvent createWindGustDirectionChangedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustDirectionChangedPropertyEvent(sensor, degree, previousValue);
  }

  @Override
  public WindGustDirectionUpdatedEvent createWindGustDirectionUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustDirectionUpdatedPropertyEvent(sensor, degree, previousValue);
  }

  @Override
  public WindRunChangedEvent createWindRunChangedEvent(WindSensor sensor, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue) {
    return new DefaultWindRunChangedPropertyEvent(sensor, km, previousValue);
  }

  @Override
  public WindRunUpdatedEvent createWindRunUpdatedEvent(WindSensor sensor, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue) {
    return new DefaultWindRunUpdatedPropertyEvent(sensor, km, previousValue);
  }
}
