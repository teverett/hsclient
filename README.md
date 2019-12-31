
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

<pre>

final HSClient hsClient = HSClientImpl.connect(URL, USERNAME, PASSWORD);
final StatusResponse statusResponse = hsClient.getStatus(null, null, null);

</pre>





