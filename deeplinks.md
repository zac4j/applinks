Android M Links:
http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0718/3200.html

Best practice:
https://developer.yahoo.com/performance/rules.html?guccounter=1

微信内跳转唤醒APP
http://www.jianshu.com/p/0b210021cbd7

魔窗：
http://www.magicwindow.cn/doc/mlink-sdk-android.html

Invoke FAQ:
https://github.com/magicwindow/mw-sdk-faq/blob/master/android-sdk-faq.md

H5 wake up App:
https://my.oschina.net/liucundong/blog/354029

微信 H5:
https://github.com/capricorncd/app-download-boot

LinkedME:
https://www.linkedme.cc/price.html

需求评审：
https://segmentfault.com/a/1190000005848133?_ea=929252

应用宝微下载:
http://wiki.open.qq.com/index.php?title=mobile/%E5%BA%94%E7%94%A8%E5%AE%9D%E5%BE%AE%E4%B8%8B%E8%BD%BD

多一步逻辑：
http://blog.csdn.net/songchunmin_/article/details/52279319

应用宝 AppLink 接入：
http://wiki.open.qq.com/index.php?title=AppLink%E6%8E%A5%E5%85%A5

https://developer.android.google.cn/training/app-links/

微信内跳转 App
调研结果：微信内屏蔽了 URL Scheme，基于 URL Scheme 的安卓系统深度链接技术，如 AppLinks、Deep Linking 都无法生效（微信与 AppStore 有合作，未屏蔽 iOS 的 Universal links），为了在安卓系统内实现微信跳转 App 指定页的功能，可以有两种途径：
+ 让微信将 App 添加至白名单
+ 使用微信推荐的——应用宝微下载服务

目前已使用基于应用宝 Applink 服务实现跳转 App 指定页面的需求。

如何将用户带到正确的页面(Activity)，这个问题需要考虑2个方面：
+ 所在的容器：应用内浏览器，系统及第三方浏览器
+ 需要的技术：Deep Linking，App Links，应用宝 AppLink


## deep links
#### How to drive users to the right activity?
+ Add intent-filters
+ Extra data from incoming intent

#### Problem
+ Apps installed on a user's device can handle the same intent.

## Android App Links (API level 23)
#### What
+ Allow an app designate itself as the default handler of a given type of link
#### How to create Deep Links to App Content:
```xml
<activity
    android:name="com.zac4j.ui.GizmosActivity"
    android:label="@string/title_gizmos" >
    <intent-filter android:label="@string/filter_view_http_gizmos">
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <!-- Accepts URIs that begin with "http://www.zac4j.com/gizmos” -->
        <data android:scheme="http"
              android:host="www.zac4j.com"
              android:pathPrefix="/gizmos" />
        <!-- note that the leading "/" is required for pathPrefix-->
    </intent-filter>
    <intent-filter android:label="@string/filter_view_example_gizmos">
        <action android:name="android.intent.action.VIEW" />
        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />
        <!-- Accepts URIs that begin with "zac4j://gizmos” -->
        <data android:scheme="zac4j"
              android:host="gizmos" />
    </intent-filter>
</activity>
```

> Tips:
```xml
<intent-filter>
  <action android:name="android.intent.action.VIEW" />
	<category android:name="android.intent.category.DEFAULT" />
	<category android:name="android.intent.category.BROWSABLE" />
  <data android:scheme="https" android:host="www.example.com" />
  <data android:scheme="app" android:host="open.my.app" />
</intent-filter>
```

```shell
adb shell am start
        -W -a android.intent.action.VIEW
        -d <URI> <PACKAGE>

adb shell am start
        -W -a android.intent.action.VIEW
        -d "zac4j://gizmos" com.example.android
```