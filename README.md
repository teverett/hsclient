[![Codacy Badge](https://api.codacy.com/project/badge/Grade/8ed69ebaffaa4cf5a78a79d8ac5a3113)](https://www.codacy.com/manual/teverett/hsclient?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=teverett/hsclient&amp;utm_campaign=Badge_Grade)


HomeSeer Java Client
========

A simple Java client for the HomeSeer JSON API.

The client was built based on [this documentation](https://homeseer.com/support/homeseer/HS3/hs3sdk.pdf) and tested against `HS3 Pro (SEL) Edition 3.0.0.548`

License
-------------------

hsclient is distributed under the BSD 3-Clause License.

Usage
-------------------

Simply instantiate an [HSClient](https://github.com/teverett/hsclient/blob/master/src/main/java/com/khubla/hsclient/HSClient.java) and call the API methods

To get all Devices:

```java
final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
try {
   final Map<Integer, Device> allDevices = hsClient.getDevicesByRef();
} finally {
   hsClient.close();
}
```

To get all Events:

```java
final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
try {
   final Map<Integer, Event> allEvents = hsClient.getEventsById();
} finally {
   hsClient.close();
}
```

To get a single Device:

```java
final HSClient hsClient = new HSClientImpl(URL, USERNAME, PASSWORD);
try {
   final Device device = hsClient.getDevice(DEVICEREF);
} finally {
   hsClient.close();
}
```