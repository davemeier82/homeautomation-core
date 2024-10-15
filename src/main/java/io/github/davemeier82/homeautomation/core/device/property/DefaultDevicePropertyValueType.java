/*
 * Copyright 2021-2024 the original author or authors.
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

package io.github.davemeier82.homeautomation.core.device.property;

import java.util.Arrays;
import java.util.Optional;

import static io.github.davemeier82.homeautomation.core.device.property.DefaultDevicePropertyType.*;

public enum DefaultDevicePropertyValueType implements DevicePropertyValueType {

  DIMMING_LEVEL("DimmingLevel", DIMMER, Integer.class, "%"),
  BATTERY_LEVEL("BatteryLevel", BATTERY_STATE_SENSOR, Integer.class, "%"),
  RELATIVE_HUMIDITY("RelativeHumidity", HUMIDITY_SENSOR, Float.class, "%"),
  TEMPERATURE("Temperature", TEMPERATURE_SENSOR, Float.class, "°C"),
  PRESSURE("Pressure", PRESSURE_SENSOR, Float.class, "mbar"),
  POWER("Power", POWER_SENSOR, Double.class, "W"),
  ILLUMINANCE("Illuminance", ILLUMINANCE_SENSOR, Integer.class, "lux"),
  RELAY_STATE("RelayState", RELAY, Boolean.class, "on/off"),
  MOTION_STATE("MotionState", MOTION_SENSOR, Boolean.class, "on/off"),
  WINDOW_STATE("WindowState", WINDOW_SENSOR, Boolean.class, "open/closed"),
  WINDOW_TILT_ANGLE("WindowTiltAngle", WINDOW_SENSOR, Integer.class, "°"),
  CO2_LEVEL("Co2Level", CO2_SENSOR, Integer.class, "ppm"),
  UV_INDEX("UvIndex", UV_SENSOR, Float.class, "index"),
  CLOUD_BASE("CloudBase", CLOUD_BASE_SENSOR, Float.class, "m"),
  WIND_SPEED("WindSpeed", WINDOW_SENSOR, Float.class, "km/h"),
  WIND_GUST_SPEED("WindGustSpeed", WINDOW_SENSOR, Float.class, "km/h"),
  WIND_DIRECTION("WindDirection", WINDOW_SENSOR, Float.class, "°"),
  WIND_GUST_DIRECTION("WindGustDirection", WINDOW_SENSOR, Float.class, "°"),
  WIND_RUN("WindRun", WINDOW_SENSOR, Double.class, "km"),
  RAIN_RATE("RainRate", RAIN_SENSOR, Float.class, "mm/h"),
  RAIN_INTERVAL_AMOUNT("RainIntervalAmount", RAIN_SENSOR, Float.class, "mm"),
  RAIN_TODAY_AMOUNT("RainTodayAmount", RAIN_SENSOR, Float.class, "mm"),
  SMOKE_STATE("SmokeState", SMOKE_SENSOR, Boolean.class, "on/off"),
  ALARM_STATE("AlarmState", ALARM, AlarmState.class, ""),
  ROLLER_POSITION("RollerPosition", ROLLER, Integer.class, "%"),
  ROLLER_STATE("RollerState", ROLLER, RollerState.class, ""),
  LIGHTNING_DISTANCE("LightningDistance", ROLLER, Integer.class, "km"),
  LIGHTNING_COUNT("LightningCount", ROLLER, Integer.class, "");

  private final String typeName;

  private final DevicePropertyType devicePropertyType;

  private final Class<?> clazz;

  private final String unit;

  DefaultDevicePropertyValueType(String typeName, DevicePropertyType devicePropertyType, Class<?> clazz, String unit) {
    this.typeName = typeName;
    this.devicePropertyType = devicePropertyType;
    this.clazz = clazz;
    this.unit = unit;
  }

  public static Optional<DefaultDevicePropertyValueType> fromTypeName(String typeName) {
    return Arrays.stream(values()).filter(t -> t.getTypeName().equals(typeName)).findFirst();
  }

  @Override
  public DevicePropertyType getDevicePropertyType() {
    return devicePropertyType;
  }

  @Override
  public String getTypeName() {
    return typeName;
  }

  @Override
  public Class<?> getClazz() {
    return clazz;
  }

  @Override
  public String getUnit() {
    return unit;
  }
}
