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
   * Creates a {@link MotionChangedEvent}.
   *
   * @param sensor         the sensor that emits the event
   * @param motionDetected the new value
   * @param previousValue  the old value
   * @return the event
   */
  MotionChangedEvent createMotionChangedEvent(MotionSensor sensor,
                                              DataWithTimestamp<Boolean> motionDetected,
                                              DataWithTimestamp<Boolean> previousValue
  );

  /**
   * Creates a {@link MotionUpdatedEvent}.
   *
   * @param sensor         the sensor that emits the event
   * @param motionDetected the new value
   * @param previousValue  the old value
   * @return the event
   */
  MotionUpdatedEvent createMotionUpdatedEvent(MotionSensor sensor,
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
   * Creates a {@link RelayStateUpdatedEvent}.
   *
   * @param relay         the relay that emits the event
   * @param isOn          the new value
   * @param previousValue the old value
   * @return the event
   */
  RelayStateUpdatedEvent createRelayStateUpdatedEvent(ReadOnlyRelay relay, DataWithTimestamp<Boolean> isOn, DataWithTimestamp<Boolean> previousValue);

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
   * Creates a {@link WindowStateUpdatedEvent}.
   *
   * @param windowSensor  the window sensor that emits the event
   * @param isOpen        the new value
   * @param previousValue the old value
   * @return the event
   */
  WindowStateUpdatedEvent createWindowStateUpdatedEvent(WindowSensor windowSensor,
                                                        DataWithTimestamp<Boolean> isOpen,
                                                        DataWithTimestamp<Boolean> previousValue
  );

  /**
   * Creates a {@link SmokeStateChangedEvent}.
   *
   * @param smokeSensor   the alarm that emits the event
   * @param isOpen        the new value
   * @param previousValue the old value
   * @return the event
   */
  SmokeStateChangedEvent createSmokeStateChangedEvent(SmokeSensor smokeSensor,
                                                      DataWithTimestamp<Boolean> isOpen,
                                                      DataWithTimestamp<Boolean> previousValue
  );

  /**
   * Creates a {@link SmokeStateUpdatedEvent}.
   *
   * @param smokeSensor   the alarm that emits the event
   * @param isOpen        the new value
   * @param previousValue the old value
   * @return the event
   */
  SmokeStateUpdatedEvent createSmokeStateUpdatedEvent(SmokeSensor smokeSensor,
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
   * Creates a {@link TemperatureUpdatedEvent}.
   *
   * @param temperatureSensor   the temperature sensor that emits the event
   * @param temperatureInDegree the new value
   * @param previousValue       the old value
   * @return the event
   */
  TemperatureUpdatedEvent createTemperatureUpdatedEvent(TemperatureSensor temperatureSensor,
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
   * Creates a {@link HumidityUpdatedEvent}.
   *
   * @param humiditySensor            the humidity sensor that emits the event
   * @param relativeHumidityInPercent the new value
   * @param previousValue             the old value
   * @return the event
   */
  HumidityUpdatedEvent createHumidityUpdatedEvent(HumiditySensor humiditySensor,
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
   * Creates a {@link BatteryLevelUpdatedEvent}.
   *
   * @param batteryStateSensor    the battery state sensor that emits the event
   * @param batteryLevelInPercent the new value
   * @param previousValue         the old value
   * @return the event
   */
  BatteryLevelUpdatedEvent createBatteryLevelUpdatedEvent(BatteryStateSensor batteryStateSensor,
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
   * Creates a {@link DimmingLevelUpdatedEvent}.
   *
   * @param dimmer              the dimmer that emits the event
   * @param brightnessInPercent the new value
   * @param previousValue       the old value
   * @return the event
   */
  DimmingLevelUpdatedEvent createDimmingLevelUpdatedEvent(Dimmer dimmer,
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
   * Creates a {@link RollerStateUpdatedEvent}.
   *
   * @param roller        the roller that emits the event
   * @param state         the new value
   * @param previousValue the old value
   * @return the event
   */
  RollerStateUpdatedEvent createRollerStateUpdatedEvent(Roller roller,
                                                        DataWithTimestamp<RollerState> state,
                                                        DataWithTimestamp<RollerState> previousValue
  );

  /**
   * Creates a {@link AlarmStateChangedEvent}.
   *
   * @param alarm         the alarm that emits the event
   * @param state         the new value
   * @param previousValue the old value
   * @return the event
   */
  AlarmStateChangedEvent createAlarmStateChangedEvent(Alarm alarm,
                                                      DataWithTimestamp<AlarmState> state,
                                                      DataWithTimestamp<AlarmState> previousValue
  );

  /**
   * Creates a {@link AlarmStateUpdatedEvent}.
   *
   * @param alarm         the alarm that emits the event
   * @param state         the new value
   * @param previousValue the old value
   * @return the event
   */
  AlarmStateUpdatedEvent createAlarmStateUpdatedEvent(Alarm alarm,
                                                      DataWithTimestamp<AlarmState> state,
                                                      DataWithTimestamp<AlarmState> previousValue
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
   * Creates a {@link RollerPositionUpdatedEvent}.
   *
   * @param roller            the roller that emits the event
   * @param positionInPercent the new value
   * @param previousValue     the old value
   * @return the event
   */
  RollerPositionUpdatedEvent createRollerPositionUpdatedEvent(Roller roller,
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
   * Creates a {@link IlluminanceUpdatedEvent}.
   *
   * @param sensor        the illuminance sensor that emits the event
   * @param lux           the new value
   * @param previousValue the old value
   * @return the event
   */
  IlluminanceUpdatedEvent createIlluminanceUpdatedEvent(IlluminanceSensor sensor,
                                                        DataWithTimestamp<Integer> lux,
                                                        DataWithTimestamp<Integer> previousValue
  );

  /**
   * Creates a {@link Co2LevelUpdatedEvent}.
   *
   * @param sensor        the co2 sensor that emits the event
   * @param ppm           the new value
   * @param previousValue the old value
   * @return the event
   */
  Co2LevelUpdatedEvent createCo2LevelUpdatedEvent(Co2Sensor sensor,
                                                  DataWithTimestamp<Integer> ppm,
                                                  DataWithTimestamp<Integer> previousValue
  );

  /**
   * Creates a {@link Co2LevelChangedEvent}.
   *
   * @param sensor        the co2 sensor that emits the event
   * @param ppm           the new value
   * @param previousValue the old value
   * @return the event
   */
  Co2LevelChangedEvent createCo2LevelChangedEvent(Co2Sensor sensor,
                                                  DataWithTimestamp<Integer> ppm,
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

  /**
   * Creates a {@link PowerUpdatedEvent}.
   *
   * @param sensor        the power sensor that emits the event
   * @param watt          the new value
   * @param previousValue the old value
   * @return the event
   */
  PowerUpdatedEvent createPowerUpdatedEvent(PowerSensor sensor, DataWithTimestamp<Double> watt, DataWithTimestamp<Double> previousValue);

  /**
   * Creates a {@link CloudBaseChangedEvent}.
   *
   * @param sensor        the cloud base sensor that emits the event
   * @param meter         the new value
   * @param previousValue the old value
   * @return the event
   */
  CloudBaseChangedEvent createCloudBaseChangedEvent(CloudBaseSensor sensor, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link CloudBaseUpdatedEvent}.
   *
   * @param sensor        the cloud base sensor that emits the event
   * @param meter         the new value
   * @param previousValue the old value
   * @return the event
   */
  CloudBaseUpdatedEvent createCloudBaseUpdatedEvent(CloudBaseSensor sensor, DataWithTimestamp<Float> meter, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link PressureChangedEvent}.
   *
   * @param sensor        the pressure sensor that emits the event
   * @param mbar          the new value
   * @param previousValue the old value
   * @return the event
   */
  PressureChangedEvent createPressureChangedEvent(PressureSensor sensor, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link PressureUpdatedEvent}.
   *
   * @param sensor        the pressure sensor that emits the event
   * @param mbar          the new value
   * @param previousValue the old value
   * @return the event
   */
  PressureUpdatedEvent createPressureUpdatedEvent(PressureSensor sensor, DataWithTimestamp<Float> mbar, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link UvIndexChangedEvent}.
   *
   * @param sensor        the UV sensor that emits the event
   * @param uvIndex       the new value
   * @param previousValue the old value
   * @return the event
   */
  UvIndexChangedEvent createUvIndexChangedEvent(UvSensor sensor, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link UvIndexUpdatedEvent}.
   *
   * @param sensor        the UV sensor that emits the event
   * @param uvIndex       the new value
   * @param previousValue the old value
   * @return the event
   */
  UvIndexUpdatedEvent createUvIndexUpdatedEvent(UvSensor sensor, DataWithTimestamp<Float> uvIndex, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link RainRateChangedEvent}.
   *
   * @param sensor the rain sensor
   * @param millimeterPerHour the new value
   * @param previousValue the previous value
   * @return the event
   */
  RainRateChangedEvent createRainRateChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link RainRateUpdatedEvent}.
   *
   * @param sensor the rain sensor
   * @param millimeterPerHour the new value
   * @param previousValue the previous value
   * @return the event
   */
  RainRateUpdatedEvent createRainRateUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeterPerHour, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link RainIntervalAmountChangedEvent}.
   *
   * @param sensor the rain sensor
   * @param millimeter the new value
   * @param previousValue the previous value
   * @return the event
   */
  RainIntervalAmountChangedEvent createRainIntervalAmountChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link RainIntervalAmountUpdatedEvent}.
   *
   * @param sensor the rain sensor
   * @param millimeter the new value
   * @param previousValue the previous value
   * @return the event
   */
  RainIntervalAmountUpdatedEvent createRainIntervalAmountUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link RainTodayAmountChangedEvent}.
   *
   * @param sensor the rain sensor
   * @param millimeter the new value
   * @param previousValue the previous value
   * @return the event
   */
  RainTodayAmountChangedEvent createRainTodayAmountChangedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link RainTodayAmountUpdatedEvent}.
   *
   * @param sensor the rain sensor
   * @param millimeter the new value
   * @param previousValue the previous value
   * @return the event
   */
  RainTodayAmountUpdatedEvent createRainTodayAmountUpdatedEvent(RainSensor sensor, DataWithTimestamp<Float> millimeter, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindSpeedChangedEvent}.
   *
   * @param sensor the wind sensor
   * @param kmh the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindSpeedChangedEvent createWindSpeedChangedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindSpeedUpdatedEvent}.
   *
   * @param sensor the wind sensor
   * @param kmh the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindSpeedUpdatedEvent createWindSpeedUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindGustSpeedChangedEvent}.
   *
   * @param sensor the wind sensor
   * @param kmh the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindGustSpeedChangedEvent createWindGustSpeedChangedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindGustSpeedUpdatedEvent}.
   *
   * @param sensor the wind sensor
   * @param kmh the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindGustSpeedUpdatedEvent createWindGustSpeedUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> kmh, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindDirectionChangedEvent}.
   *
   * @param sensor the wind sensor
   * @param degree the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindDirectionChangedEvent createWindDirectionChangedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindDirectionUpdatedEvent}.
   *
   * @param sensor the wind sensor
   * @param degree the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindDirectionUpdatedEvent createWindDirectionUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindGustDirectionChangedEvent}.
   *
   * @param sensor the wind sensor
   * @param degree the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindGustDirectionChangedEvent createWindGustDirectionChangedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindGustDirectionUpdatedEvent}.
   *
   * @param sensor the wind sensor
   * @param degree the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindGustDirectionUpdatedEvent createWindGustDirectionUpdatedEvent(WindSensor sensor, DataWithTimestamp<Float> degree, DataWithTimestamp<Float> previousValue);

  /**
   * Creates a {@link WindRunChangedEvent}.
   *
   * @param sensor the wind sensor
   * @param km the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindRunChangedEvent createWindRunChangedEvent(WindSensor sensor, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue);

  /**
   * Creates a {@link WindRunUpdatedEvent}.
   *
   * @param sensor the wind sensor
   * @param km the new value
   * @param previousValue the previous value
   * @return the event
   */
  WindRunUpdatedEvent createWindRunUpdatedEvent(WindSensor sensor, DataWithTimestamp<Double> km, DataWithTimestamp<Double> previousValue);

}
