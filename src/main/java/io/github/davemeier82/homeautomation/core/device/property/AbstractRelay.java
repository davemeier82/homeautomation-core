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

package io.github.davemeier82.homeautomation.core.device.property;

import io.github.davemeier82.homeautomation.core.device.Device;
import io.github.davemeier82.homeautomation.core.device.property.defaults.DefaultReadOnlyRelay;
import io.github.davemeier82.homeautomation.core.event.EventPublisher;
import io.github.davemeier82.homeautomation.core.event.factory.EventFactory;

/**
 * Abstract implementation of a {@link Relay}.
 *
 * @author David Meier
 * @since 0.1.0
 */
public abstract class AbstractRelay extends DefaultReadOnlyRelay implements Relay {

  /**
   * Constructor
   *
   * @param id             the device property id
   * @param device         the device
   * @param eventPublisher event publisher
   * @param eventFactory   event factory
   */
  protected AbstractRelay(int id,
                          Device device,
                          EventPublisher eventPublisher,
                          EventFactory eventFactory
  ) {
    super(id, device, eventPublisher, eventFactory);
  }

}
