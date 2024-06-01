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

package io.github.davemeier82.homeautomation.core.notification;

import io.github.davemeier82.homeautomation.core.event.DevicePropertyEvent;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class DefaultEventPushNotificationSender implements EventPushNotificationSender {

  private final EventPushNotificationConfigRepository repository;
  private final Set<PushNotificationService> pushNotificationServices;
  private final EventPushNotificationMessageTranslator translator;

  public DefaultEventPushNotificationSender(EventPushNotificationConfigRepository eventPushNotificationConfigRepository,
                                            Set<PushNotificationService> pushNotificationServices,
                                            EventPushNotificationMessageTranslator eventPushNotificationMessageTranslator
  ) {
    repository = eventPushNotificationConfigRepository;
    this.pushNotificationServices = pushNotificationServices;
    translator = eventPushNotificationMessageTranslator;
  }

  private static boolean sendToAll(Set<EventPushNotificationConfig> serviceIds) {
    return serviceIds.stream().anyMatch(c -> c.serviceIds().isEmpty());
  }

  @Override
  public void sendNotifications(DevicePropertyEvent<?> event) {
    Set<EventPushNotificationConfig> configs = repository.findAllByEvent(event);
    if (!configs.isEmpty()) {
      String title = translator.translateTitle(event);
      String message = translator.translateMessage(event);
      if (sendToAll(configs)) {
        pushNotificationServices.forEach(s -> s.sendTextMessageToAllServices(title, message));
      } else {
        Set<String> serviceIds = configs.stream().flatMap(c -> c.serviceIds().stream()).collect(toSet());
        serviceIds.forEach(id -> pushNotificationServices.stream().filter(service -> service.getServiceIds().contains(id)).forEach(s -> s.sendTextMessageToServiceWithId(id, title, message)));
      }
    }
  }
}
