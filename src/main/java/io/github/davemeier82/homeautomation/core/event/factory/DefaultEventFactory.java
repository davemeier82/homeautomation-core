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

import static io.github.davemeier82.homeautomation.core.device.property.DevicePropertyId.devicePropertyIdFrom;

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
    return new DefaultMotionChangedPropertyEvent(devicePropertyIdFrom(sensor), sensor.getDevice().getDisplayName(), motionDetected, previousValue);
  }

  @Override
  public MotionUpdatedEvent createMotionUpdatedEvent(MotionSensor sensor,
                                                     DataWithTimestamp<Boolean> motionDetected,
                                                     DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultMotionUpdatedPropertyEvent(devicePropertyIdFrom(sensor), sensor.getDevice().getDisplayName(), motionDetected, previousValue);
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
    return new DefaultRelayStateChangedPropertyEvent(devicePropertyIdFrom(relay), relay.getDevice().getDisplayName(), isOn, previousValue);
  }

  @Override
  public RelayStateUpdatedEvent createRelayStateUpdatedEvent(ReadOnlyRelay relay,
                                                             DataWithTimestamp<Boolean> isOn,
                                                             DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultRelayStateUpdatedPropertyEvent(devicePropertyIdFrom(relay), relay.getDevice().getDisplayName(), isOn, previousValue);
  }

  @Override
  public WindowStateChangedEvent createWindowStateChangedEvent(WindowSensor sensor,
                                                               DataWithTimestamp<Boolean> isOpen,
                                                               DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultWindowStateChangedPropertyEvent(devicePropertyIdFrom(sensor), sensor.getDevice().getDisplayName(), isOpen, previousValue);
  }

  @Override
  public WindowStateUpdatedEvent createWindowStateUpdatedEvent(WindowSensor sensor,
                                                               DataWithTimestamp<Boolean> isOpen,
                                                               DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultWindowStateUpdatedPropertyEvent(devicePropertyIdFrom(sensor), sensor.getDevice().getDisplayName(), isOpen, previousValue);
  }

  @Override
  public SmokeStateChangedEvent createSmokeStateChangedEvent(SmokeSensor sensor,
                                                             DataWithTimestamp<Boolean> isActive,
                                                             DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultSmokeStateChangedPropertyEvent(devicePropertyIdFrom(sensor), sensor.getDevice().getDisplayName(), isActive, previousValue);
  }

  @Override
  public SmokeStateUpdatedEvent createSmokeStateUpdatedEvent(SmokeSensor sensor,
                                                             DataWithTimestamp<Boolean> isActive,
                                                             DataWithTimestamp<Boolean> previousValue
  ) {
    return new DefaultSmokeStateUpdatedPropertyEvent(devicePropertyIdFrom(sensor), sensor.getDevice().getDisplayName(), isActive, previousValue);
  }

  @Override
  public TemperatureChangedEvent createTemperatureChangedEvent(TemperatureSensor sensor,
                                                               DataWithTimestamp<Float> temperatureInDegree,
                                                               DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultTemperatureChangedPropertyEvent(devicePropertyIdFrom(sensor), temperatureInDegree, previousValue);
  }

  @Override
  public TemperatureUpdatedEvent createTemperatureUpdatedEvent(TemperatureSensor sensor,
                                                               DataWithTimestamp<Float> temperatureInDegree,
                                                               DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultTemperatureUpdatedPropertyEvent(devicePropertyIdFrom(sensor), temperatureInDegree, previousValue);
  }

  @Override
  public HumidityChangedEvent createHumidityChangedEvent(HumiditySensor sensor,
                                                         DataWithTimestamp<Float> relativeHumidityInPercent,
                                                         DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultHumidityChangedPropertyEvent(devicePropertyIdFrom(sensor), relativeHumidityInPercent, previousValue);
  }

  @Override
  public HumidityUpdatedEvent createHumidityUpdatedEvent(HumiditySensor sensor,
                                                         DataWithTimestamp<Float> relativeHumidityInPercent,
                                                         DataWithTimestamp<Float> previousValue
  ) {
    return new DefaultHumidityUpdatedPropertyEvent(devicePropertyIdFrom(sensor), relativeHumidityInPercent, previousValue);
  }

  @Override
  public BatteryLevelChangedEvent createBatteryLevelChangedEvent(BatteryStateSensor sensor,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultBatteryLevelChangedPropertyEvent(devicePropertyIdFrom(sensor), batteryLevelInPercent, previousValue);
  }

  @Override
  public BatteryLevelUpdatedEvent createBatteryLevelUpdatedEvent(BatteryStateSensor sensor,
                                                                 DataWithTimestamp<Integer> batteryLevelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultBatteryLevelUpdatedPropertyEvent(devicePropertyIdFrom(sensor), batteryLevelInPercent, previousValue);
  }

  @Override
  public DimmingLevelChangedEvent createDimmingLevelChangedEvent(Dimmer dimmer,
                                                                 DataWithTimestamp<Integer> levelInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultDimmingLevelChangedPropertyEvent(devicePropertyIdFrom(dimmer), levelInPercent, previousValue);
  }

  @Override
  public DimmingLevelUpdatedEvent createDimmingLevelUpdatedEvent(Dimmer dimmer,
                                                                 DataWithTimestamp<Integer> brightnessInPercent,
                                                                 DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultDimmingLevelUpdatedPropertyEvent(devicePropertyIdFrom(dimmer), brightnessInPercent, previousValue);
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
    return new DefaultRollerStateChangedPropertyEvent(devicePropertyIdFrom(roller), roller.getDevice().getDisplayName(), state, previousValue);
  }

  @Override
  public RollerStateUpdatedEvent createRollerStateUpdatedEvent(Roller roller,
                                                               DataWithTimestamp<RollerState> state,
                                                               DataWithTimestamp<RollerState> previousValue
  ) {
    return new DefaultRollerStateUpdatedPropertyEvent(devicePropertyIdFrom(roller), roller.getDevice().getDisplayName(), state, previousValue);
  }

  @Override
  public AlarmStateChangedEvent createAlarmStateChangedEvent(Alarm alarm,
                                                             DataWithTimestamp<AlarmState> state,
                                                             DataWithTimestamp<AlarmState> previousValue
  ) {
    return new DefaultAlarmStateChangedPropertyEvent(devicePropertyIdFrom(alarm), alarm.getDevice().getDisplayName(), state, previousValue);
  }

  @Override
  public AlarmStateUpdatedEvent createAlarmStateUpdatedEvent(Alarm alarm,
                                                             DataWithTimestamp<AlarmState> state,
                                                             DataWithTimestamp<AlarmState> previousValue
  ) {
    return new DefaultAlarmStateUpdatedPropertyEvent(devicePropertyIdFrom(alarm), alarm.getDevice().getDisplayName(), state, previousValue);
  }

  @Override
  public RollerPositionChangedEvent createRollerPositionChangedEvent(Roller roller,
                                                                     DataWithTimestamp<Integer> positionInPercent,
                                                                     DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultRollerPositionChangedPropertyEvent(devicePropertyIdFrom(roller), roller.getDevice().getDisplayName(), positionInPercent, previousValue);
  }

  @Override
  public RollerPositionUpdatedEvent createRollerPositionUpdatedEvent(Roller roller,
                                                                     DataWithTimestamp<Integer> positionInPercent,
                                                                     DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultRollerPositionUpdatedPropertyEvent(devicePropertyIdFrom(roller), roller.getDevice().getDisplayName(), positionInPercent, previousValue);
  }

  @Override
  public IlluminanceChangedEvent createIlluminanceChangedEvent(IlluminanceSensor sensor,
                                                               DataWithTimestamp<Integer> lux,
                                                               DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultIlluminanceChangedPropertyEvent(devicePropertyIdFrom(sensor), lux, previousValue);
  }

  @Override
  public IlluminanceUpdatedEvent createIlluminanceUpdatedEvent(IlluminanceSensor sensor,
                                                               DataWithTimestamp<Integer> lux,
                                                               DataWithTimestamp<Integer> previousValue
  ) {
    return new DefaultIlluminanceUpdatedPropertyEvent(devicePropertyIdFrom(sensor), lux, previousValue);
  }

  @Override
  public Co2LevelUpdatedEvent createCo2LevelUpdatedEvent(Co2Sensor sensor, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue) {
    return new DefaultICo2LevelUpdatedPropertyEvent(devicePropertyIdFrom(sensor), ppm, previousValue);
  }

  @Override
  public Co2LevelChangedEvent createCo2LevelChangedEvent(Co2Sensor sensor, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue) {
    return new DefaultICo2LevelChangedPropertyEvent(devicePropertyIdFrom(sensor), ppm, previousValue);
  }

  @Override
  public PowerChangedEvent createPowerChangedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue) {
    return new DefaultPowerChangedPropertyEvent(devicePropertyIdFrom(sensor), watt, previousValue);
  }

  @Override
  public PowerUpdatedEvent createPowerUpdatedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue) {
    return new DefaultPowerUpdatedPropertyEvent(devicePropertyIdFrom(sensor), watt, previousValue);
  }

  @Override
  public CloudBaseChangedEvent createCloudBaseChangedEvent(CloudBaseSensor sensor, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue) {
    return new DefaultCloudBaseChangedPropertyEvent(devicePropertyIdFrom(sensor), meter, previousValue);
  }

  @Override
  public CloudBaseUpdatedEvent createCloudBaseUpdatedEvent(CloudBaseSensor sensor, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue) {
    return new DefaultCloudBaseUpdatedPropertyEvent(devicePropertyIdFrom(sensor), meter, previousValue);
  }

  @Override
  public PressureChangedEvent createPressureChangedEvent(PressureSensor sensor, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue) {
    return new DefaultPressureChangedPropertyEvent(devicePropertyIdFrom(sensor), mbar, previousValue);
  }

  @Override
  public PressureUpdatedEvent createPressureUpdatedEvent(PressureSensor sensor, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue) {
    return new DefaultPressureUpdatedPropertyEvent(devicePropertyIdFrom(sensor), mbar, previousValue);
  }

  @Override
  public UvIndexChangedEvent createUvIndexChangedEvent(UvSensor sensor, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue) {
    return new DefaultUvIndexChangedPropertyEvent(devicePropertyIdFrom(sensor), uvIndex, previousValue);
  }

  @Override
  public UvIndexUpdatedEvent createUvIndexUpdatedEvent(UvSensor sensor, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue) {
    return new DefaultUvIndexUpdatedPropertyEvent(devicePropertyIdFrom(sensor), uvIndex, previousValue);
  }

  @Override
  public RainRateChangedEvent createRainRateChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainRateChangedPropertyEvent(devicePropertyIdFrom(sensor), millimeterPerHour, previousValue);
  }

  @Override
  public RainRateUpdatedEvent createRainRateUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainRateUpdatedPropertyEvent(devicePropertyIdFrom(sensor), millimeterPerHour, previousValue);
  }

  @Override
  public RainIntervalAmountChangedEvent createRainIntervalAmountChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainIntervalAmountChangedPropertyEvent(devicePropertyIdFrom(sensor), millimeter, previousValue);
  }

  @Override
  public RainIntervalAmountUpdatedEvent createRainIntervalAmountUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainIntervalAmountUpdatedPropertyEvent(devicePropertyIdFrom(sensor), millimeter, previousValue);
  }

  @Override
  public RainTodayAmountChangedEvent createRainTodayAmountChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainTodayAmountChangedPropertyEvent(devicePropertyIdFrom(sensor), millimeter, previousValue);
  }

  @Override
  public RainTodayAmountUpdatedEvent createRainTodayAmountUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue) {
    return new DefaultRainTodayAmountUpdatedPropertyEvent(devicePropertyIdFrom(sensor), millimeter, previousValue);
  }

  @Override
  public WindSpeedChangedEvent createWindSpeedChangedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindSpeedChangedPropertyEvent(devicePropertyIdFrom(sensor), kmh, previousValue);
  }

  @Override
  public WindSpeedUpdatedEvent createWindSpeedUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindSpeedUpdatedPropertyEvent(devicePropertyIdFrom(sensor), kmh, previousValue);
  }

  @Override
  public WindGustSpeedChangedEvent createWindGustSpeedChangedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustSpeedChangedPropertyEvent(devicePropertyIdFrom(sensor), kmh, previousValue);
  }

  @Override
  public WindGustSpeedUpdatedEvent createWindGustSpeedUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustSpeedUpdatedPropertyEvent(devicePropertyIdFrom(sensor), kmh, previousValue);
  }

  @Override
  public WindDirectionChangedEvent createWindDirectionChangedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindDirectionChangedPropertyEvent(devicePropertyIdFrom(sensor), degree, previousValue);
  }

  @Override
  public WindDirectionUpdatedEvent createWindDirectionUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindDirectionUpdatedPropertyEvent(devicePropertyIdFrom(sensor), degree, previousValue);
  }

  @Override
  public WindGustDirectionChangedEvent createWindGustDirectionChangedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustDirectionChangedPropertyEvent(devicePropertyIdFrom(sensor), degree, previousValue);
  }

  @Override
  public WindGustDirectionUpdatedEvent createWindGustDirectionUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue) {
    return new DefaultWindGustDirectionUpdatedPropertyEvent(devicePropertyIdFrom(sensor), degree, previousValue);
  }

  @Override
  public WindRunChangedEvent createWindRunChangedEvent(WindSensor sensor, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue) {
    return new DefaultWindRunChangedPropertyEvent(devicePropertyIdFrom(sensor), km, previousValue);
  }

  @Override
  public WindRunUpdatedEvent createWindRunUpdatedEvent(WindSensor sensor, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue) {
    return new DefaultWindRunUpdatedPropertyEvent(devicePropertyIdFrom(sensor), km, previousValue);
  }
}
