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

package com.github.davemeier82.homeautomation.core.device.property.defaults;

import com.github.davemeier82.homeautomation.core.device.Device;
import com.github.davemeier82.homeautomation.core.device.property.MotionSensor;
import com.github.davemeier82.homeautomation.core.event.EventPublisher;
import com.github.davemeier82.homeautomation.core.event.factory.EventFactory;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Default implementation of a MotionSensor.
 *
 * @author David Meier
 * @since 0.1.0
 */
public class DefaultMotionSensor implements MotionSensor {

  private final long id;
  private final Device device;
  private final EventPublisher eventPublisher;
  private final EventFactory eventFactory;
  private final AtomicReference<ZonedDateTime> lastMotionDetected = new AtomicReference<>();

  public DefaultMotionSensor(long id,
                             Device device,
                             EventPublisher eventPublisher,
                             EventFactory eventFactory
  ) {
    this.id = id;
    this.device = device;
    this.eventPublisher = eventPublisher;
    this.eventFactory = eventFactory;
  }

  @Override
  public long getId() {
    return id;
  }

  @Override
  public Device getDevice() {
    return device;
  }

  /**
   * Sets timestamp of the detected motion
   *
   * @param zonedDateTime the time when the motion happened
   */
  public void setLastMotionDetected(ZonedDateTime zonedDateTime) {
    lastMotionDetected.set(zonedDateTime);
    eventPublisher.publishEvent(eventFactory.createMotionDetectedEvent(this, zonedDateTime));
  }

  @Override
  public Optional<ZonedDateTime> getLastMotionDetected() {
    return Optional.ofNullable(lastMotionDetected.get());
  }
}
