## Deep Link
> The deep link should take users directly to the content without any prompts,interstitial page, 
  or login.Make sure that users can see the app content even if they never previously opened the application.

## Add Android App Links
The general steps for creating Android App Links are as follows:
+ Create deep links to specific content in your app
    - Add intent filters for incoming links
    - Read data from incoming intents
+ Add verification for your deep links
    - Request automatic app link verification in your manifest.
    ```xml
    <intent-filter android:autoVerify="true" android:label="@string/filter_view_zac4j">
        <action android:name="android.intent.action.VIEW"/>
        <category android:name="android.intent.category.DEFAULT"/>
        <category android:name="android.intent.category.BROWSABLE"/>
        <!-- Accepts URIs that begin with "http://www.zac4j.com/zaccc” -->
        <data
            android:host="www.zac4j.com"
            android:pathPrefix="/zaccc"
            android:scheme="http"/>
        <data android:scheme="https"/>
        <!-- note that the leading "/" is required for pathPrefix-->
    </intent-filter>
    ```
    - Declare the relationship between your website and your intent filters by hosting a 
    [Digital Asset Links][dal] JSON file at the following location:
    `https://domain.name/.well-known/assetlinks.json`

[dal]:https://developers.google.cn/digital-asset-links/v1/getting-started

