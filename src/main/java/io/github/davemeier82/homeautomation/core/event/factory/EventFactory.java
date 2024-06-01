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
   * Creates a {@link MotionChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param motionDetected   the new value
   * @param previousValue    the old value
   * @return the event
   */
  MotionChangedEvent createMotionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> motionDetected, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  /**
   * Creates a {@link MotionUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param motionDetected   the new value
   * @param previousValue    the old value
   * @return the event
   */
  MotionUpdatedEvent createMotionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> motionDetected, DataWithTimestamp<Boolean> previousValue, String displayName
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
   * @param devicePropertyId the id of the sensor
   * @param isOn             the new value
   * @param previousValue    the old value
   * @return the event
   */
  RelayStateChangedEvent createRelayStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue, String displayName);

  /**
   * Creates a {@link RelayStateUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param isOn             the new value
   * @param previousValue    the old value
   * @return the event
   */
  RelayStateUpdatedEvent createRelayStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue, String displayName);

  /**
   * Creates a {@link WindowStateChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param isOpen           the new value
   * @param previousValue    the old value
   * @return the event
   */
  WindowStateChangedEvent createWindowStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  /**
   * Creates a {@link WindowStateUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param isOpen           the new value
   * @param previousValue    the old value
   * @return the event
   */
  WindowStateUpdatedEvent createWindowStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  /**
   * Creates a {@link SmokeStateChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param isOpen           the new value
   * @param previousValue    the old value
   * @return the event
   */
  SmokeStateChangedEvent createSmokeStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  /**
   * Creates a {@link SmokeStateUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param isOpen           the new value
   * @param previousValue    the old value
   * @return the event
   */
  SmokeStateUpdatedEvent createSmokeStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Boolean> isOpen, DataWithTimestamp<Boolean> previousValue, String displayName
  );

  /**
   * Creates a {@link TemperatureChangedEvent}.
   *
   * @param devicePropertyId    the id of the sensor
   * @param temperatureInDegree the new value
   * @param previousValue       the old value
   * @return the event
   */
  TemperatureChangedEvent createTemperatureChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> temperatureInDegree, DataWithTimestamp<Float> previousValue, String displayName
  );

  /**
   * Creates a {@link TemperatureUpdatedEvent}.
   *
   * @param devicePropertyId    the id of the sensor
   * @param temperatureInDegree the new value
   * @param previousValue       the old value
   * @return the event
   */
  TemperatureUpdatedEvent createTemperatureUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> temperatureInDegree, DataWithTimestamp<Float> previousValue, String displayName
  );

  /**
   * Creates a {@link HumidityChangedEvent}.
   *
   * @param devicePropertyId          the id of the sensor
   * @param relativeHumidityInPercent the new value
   * @param previousValue             the old value
   * @return the event
   */
  HumidityChangedEvent createHumidityChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> relativeHumidityInPercent, DataWithTimestamp<Float> previousValue, String displayName
  );

  /**
   * Creates a {@link HumidityUpdatedEvent}.
   *
   * @param devicePropertyId          the id of the sensor
   * @param relativeHumidityInPercent the new value
   * @param previousValue             the old value
   * @return the event
   */
  HumidityUpdatedEvent createHumidityUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> relativeHumidityInPercent, DataWithTimestamp<Float> previousValue, String displayName
  );

  /**
   * Creates a {@link BatteryLevelChangedEvent}.
   *
   * @param devicePropertyId      the id of the sensor
   * @param batteryLevelInPercent the new value
   * @param previousValue         the old value
   * @return the event
   */
  BatteryLevelChangedEvent createBatteryLevelChangedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> batteryLevelInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  /**
   * Creates a {@link BatteryLevelUpdatedEvent}.
   *
   * @param devicePropertyId      the id of the sensor
   * @param batteryLevelInPercent the new value
   * @param previousValue         the old value
   * @return the event
   */
  BatteryLevelUpdatedEvent createBatteryLevelUpdatedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> batteryLevelInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  /**
   * Creates a {@link DimmingLevelChangedEvent}.
   *
   * @param devicePropertyId    the id of the dimmer
   * @param brightnessInPercent the new value
   * @param previousValue       the old value
   * @return the event
   */
  DimmingLevelChangedEvent createDimmingLevelChangedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> brightnessInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  /**
   * Creates a {@link DimmingLevelUpdatedEvent}.
   *
   * @param devicePropertyId    the id of the dimmer
   * @param brightnessInPercent the new value
   * @param previousValue       the old value
   * @return the event
   */
  DimmingLevelUpdatedEvent createDimmingLevelUpdatedEvent(DevicePropertyId devicePropertyId,
                                                          DataWithTimestamp<Integer> brightnessInPercent,
                                                          DataWithTimestamp<Integer> previousValue,
                                                          String displayName
  );

  /**
   * Creates a {@link NewDeviceCreatedEvent}.
   *
   * @param deviceId the id of the newly created device
   * @return the event
   */
  NewDeviceCreatedEvent createNewDeviceCreatedEvent(DeviceId deviceId);

  /**
   * Creates a {@link RollerStateChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor roller
   * @param state            the new value
   * @param previousValue    the old value
   * @return the event
   */
  RollerStateChangedEvent createRollerStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<RollerState> state, DataWithTimestamp<RollerState> previousValue, String displayName);

  /**
   * Creates a {@link RollerStateUpdatedEvent}.
   *
   * @param devicePropertyId the id of the roller
   * @param state            the new value
   * @param previousValue    the old value
   * @return the event
   */
  RollerStateUpdatedEvent createRollerStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<RollerState> state, DataWithTimestamp<RollerState> previousValue, String displayName);

  /**
   * Creates a {@link AlarmStateChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param state            the new value
   * @param previousValue    the old value
   * @return the event
   */
  AlarmStateChangedEvent createAlarmStateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<AlarmState> state, DataWithTimestamp<AlarmState> previousValue, String displayName);

  /**
   * Creates a {@link AlarmStateUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param state            the new value
   * @param previousValue    the old value
   * @return the event
   */
  AlarmStateUpdatedEvent createAlarmStateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<AlarmState> state, DataWithTimestamp<AlarmState> previousValue, String displayName);

  /**
   * Creates a {@link RollerPositionChangedEvent}.
   *
   * @param devicePropertyId  the id of the roller
   * @param positionInPercent the new value
   * @param previousValue     the old value
   * @return the event
   */
  RollerPositionChangedEvent createRollerPositionChangedEvent(DevicePropertyId devicePropertyId,
                                                              DataWithTimestamp<Integer> positionInPercent,
                                                              DataWithTimestamp<Integer> previousValue,
                                                              String displayName
  );

  /**
   * Creates a {@link RollerPositionUpdatedEvent}.
   *
   * @param devicePropertyId  the id of the roller
   * @param positionInPercent the new value
   * @param previousValue     the old value
   * @return the event
   */
  RollerPositionUpdatedEvent createRollerPositionUpdatedEvent(DevicePropertyId devicePropertyId,
                                                              DataWithTimestamp<Integer> positionInPercent,
                                                              DataWithTimestamp<Integer> previousValue,
                                                              String displayName
  );

  /**
   * Creates a {@link IlluminanceChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param lux              the new value
   * @param previousValue    the old value
   * @return the event
   */
  IlluminanceChangedEvent createIlluminanceChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> lux, DataWithTimestamp<Integer> previousValue, String displayName);

  /**
   * Creates a {@link IlluminanceUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param lux              the new value
   * @param previousValue    the old value
   * @return the event
   */
  IlluminanceUpdatedEvent createIlluminanceUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> lux, DataWithTimestamp<Integer> previousValue, String displayName);

  /**
   * Creates a {@link Co2LevelUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param ppm              the new value
   * @param previousValue    the old value
   * @return the event
   */
  Co2LevelUpdatedEvent createCo2LevelUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue, String displayName);

  /**
   * Creates a {@link Co2LevelChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param ppm              the new value
   * @param previousValue    the old value
   * @return the event
   */
  Co2LevelChangedEvent createCo2LevelChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> ppm, DataWithTimestamp<Integer> previousValue, String displayName);

  /**
   * Creates a {@link PowerChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param watt             the new value
   * @param previousValue    the old value
   * @return the event
   */
  PowerChangedEvent createPowerChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue, String displayName);

  /**
   * Creates a {@link PowerUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param watt             the new value
   * @param previousValue    the old value
   * @return the event
   */
  PowerUpdatedEvent createPowerUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue, String displayName);

  /**
   * Creates a {@link CloudBaseChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param meter            the new value
   * @param previousValue    the old value
   * @return the event
   */
  CloudBaseChangedEvent createCloudBaseChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link CloudBaseUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param meter            the new value
   * @param previousValue    the old value
   * @return the event
   */
  CloudBaseUpdatedEvent createCloudBaseUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link PressureChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param mbar             the new value
   * @param previousValue    the old value
   * @return the event
   */
  PressureChangedEvent createPressureChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link PressureUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param mbar             the new value
   * @param previousValue    the old value
   * @return the event
   */
  PressureUpdatedEvent createPressureUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link UvIndexChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param uvIndex          the new value
   * @param previousValue    the old value
   * @return the event
   */
  UvIndexChangedEvent createUvIndexChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link UvIndexUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param uvIndex          the new value
   * @param previousValue    the old value
   * @return the event
   */
  UvIndexUpdatedEvent createUvIndexUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link RainRateChangedEvent}.
   *
   * @param devicePropertyId  the id of the sensor
   * @param millimeterPerHour the new value
   * @param previousValue     the previous value
   * @return the event
   */
  RainRateChangedEvent createRainRateChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link RainRateUpdatedEvent}.
   *
   * @param devicePropertyId  the id of the sensor
   * @param millimeterPerHour the new value
   * @param previousValue     the previous value
   * @return the event
   */
  RainRateUpdatedEvent createRainRateUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link RainIntervalAmountChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param millimeter       the new value
   * @param previousValue    the previous value
   * @return the event
   */
  RainIntervalAmountChangedEvent createRainIntervalAmountChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName
  );

  /**
   * Creates a {@link RainIntervalAmountUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param millimeter       the new value
   * @param previousValue    the previous value
   * @return the event
   */
  RainIntervalAmountUpdatedEvent createRainIntervalAmountUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName
  );

  /**
   * Creates a {@link RainTodayAmountChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param millimeter       the new value
   * @param previousValue    the previous value
   * @return the event
   */
  RainTodayAmountChangedEvent createRainTodayAmountChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link RainTodayAmountUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param millimeter       the new value
   * @param previousValue    the previous value
   * @return the event
   */
  RainTodayAmountUpdatedEvent createRainTodayAmountUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindSpeedChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param kmh              the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindSpeedChangedEvent createWindSpeedChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindSpeedUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param kmh              the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindSpeedUpdatedEvent createWindSpeedUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindGustSpeedChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param kmh              the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindGustSpeedChangedEvent createWindGustSpeedChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindGustSpeedUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param kmh              the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindGustSpeedUpdatedEvent createWindGustSpeedUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindDirectionChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param degree           the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindDirectionChangedEvent createWindDirectionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindDirectionUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param degree           the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindDirectionUpdatedEvent createWindDirectionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindGustDirectionChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param degree           the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindGustDirectionChangedEvent createWindGustDirectionChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindGustDirectionUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param degree           the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindGustDirectionUpdatedEvent createWindGustDirectionUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue, String displayName);

  /**
   * Creates a {@link WindRunChangedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param km               the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindRunChangedEvent createWindRunChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue, String displayName);

  /**
   * Creates a {@link WindRunUpdatedEvent}.
   *
   * @param devicePropertyId the id of the sensor
   * @param km               the new value
   * @param previousValue    the previous value
   * @return the event
   */
  WindRunUpdatedEvent createWindRunUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue, String displayName);

  NewDevicePropertyCreatedEvent createNewDevicePropertyCreatedEvent(DevicePropertyId devicePropertyId);

  WindowTiltAngleChangedEvent createWindowTiltAngleChangedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> newValue, DataWithTimestamp<Integer> previousValue, String displayName);

  WindowTiltAngleUpdatedEvent createWindowTiltAngleUpdatedEvent(DevicePropertyId devicePropertyId, DataWithTimestamp<Integer> newValue, DataWithTimestamp<Integer> previousValue, String displayName);
}
