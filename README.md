Android Caffeine Library
========================
![ ](http://cfs.tistory.com/custom/blog/59/592130/skin/images/caffein.jpg?=480507757)

안드로이드 라이브러리 '카페인'

Caffeine Library is the contain functions and method required for the development of the Android app.

Please see the [issues](https://github.com/ShakeJ/Android-Caffeine-library/issues) section to report any bugs or feature requests and to see the list of known issues.



Using
========================

사용법


Project - Properties - Java Build Path - Source(Tab) - Link Source - Select 'Caffeine' Folder


In source code, in first Activity called



    ContextUtil.CONTEXT = this;


second, using many utils in Caffeine


	Logg.w("Caffeine", "is Connect WI-FI? " + SystemUtil.isConnectedWiFi());


