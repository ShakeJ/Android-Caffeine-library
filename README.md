Android Caffeine Library
안드로이드 라이브러리 '카페인'
========================

Caffeine Library is the contain functions and method required for the development of the Android app.
Caffeine은 안드로이드 개발에 필요한 함수들을 정리해놓은 라이브러리입니다.

Please see the [issues](https://github.com/ShakeJ/Android-Caffeine-library/issues) section to report any bugs or feature requests and to see the list of known issues.
버그나 기능 요청은 [이슈](https://github.com/ShakeJ/Android-Caffeine-library/issues) 목록을 참조하십시오.


Using
사용법
========================

Project - Properties - Java Build Path - Source(Tab) - Link Source - Select 'Caffeine' Folder
사용할 프로젝트의 메뉴 - Properties - Java Build Path - Source(Tab) - Link Source - 카페인 라이브러리 폴더


In source code, in first Activity called
소스 내에서 첫번째 호출되는 액티비티에서 아래와 같이 호출합니다.

    ContextUtil.CONTEXT = this;

second, using many utils in Caffeine


	Log.w("Caffeine", "is Connect WI-FI? " + SystemUtil.isConnectedWiFi());


![ ](http://cfs.tistory.com/custom/blog/59/592130/skin/images/caffein.jpg?=480507757)