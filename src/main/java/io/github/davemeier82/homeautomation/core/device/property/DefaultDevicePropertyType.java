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

public enum DefaultDevicePropertyType implements DevicePropertyType {

  BATTERY_STATE_SENSOR("BatteryStateSensor"),
  CO2_SENSOR("Co2Sensor"),
  CLOUD_BASE_SENSOR("CloudBaseSensor"),
  ROLLER("Roller"),
  RELAY("Relay"),
  READ_ONLY_RELAY("ReadOnlyRelay"),
  RAIN_SENSOR("RainSensor"),
  POWER_SENSOR("PowerSensor"),
  MOTION_SENSOR("MotionSensor"),
  SMOKE_SENSOR("SmokeSensor"),
  UV_SENSOR("UvSensor"),
  WINDOW_SENSOR("WindowSensor"),
  WIND_SENSOR("WindSensor"),
  TEMPERATURE_SENSOR("TemperatureSensor"),
  HUMIDITY_SENSOR("HumiditySensor"),
  ILLUMINANCE_SENSOR("IlluminanceSensor"),
  PRESSURE_SENSOR("PressureSensor"),
  DIMMER("Dimmer"),
  ALARM("Alarm"),
  LIGHTNING_SENSOR("LightningSensor");

  private final String type;

  DefaultDevicePropertyType(String type) {
    this.type = type;
  }

  public static Optional<DefaultDevicePropertyType> fromType(String type) {
    return Arrays.stream(values()).filter(t -> t.getTypeName().equals(type)).findFirst();
  }

  @Override
  public String getTypeName() {
    return type;
  }
}
