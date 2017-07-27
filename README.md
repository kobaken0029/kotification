kotification
====

Demo app for push notification using FCM by kotlin

## Description

Notify and receive message from FCM(Firebase Could Messaging).

If you tap notification, the custom data(key/value) you set will be displayed on the screen.  
Default keys are `id` and `type`.

This app is written in kotlin.

## Requirement

Android SDK Build Tools 25.0.3  
kotlin 1.1.3-2  
gradle 2.3.3  

## Usage

If you want to change to custom data, you can edit pendingIntent in MyFirebaseMessagingService.

```kotlin
companion object {
    val FCM_DATA_KEY_ID = "id"
    val FCM_DATA_KEY_CUSTOM_KEY = "custom_key"
}

...

val pendingIntent = PendingIntent.getActivity(context, 0,
        Intent(context, MainActivity::class.java).apply {
            putExtra(ARG_ID, this@run.data[FCM_DATA_KEY_ID])
            putExtra(ARG_CUSTOM_KEY, this@run.data[FCM_DATA_KEY_CUSTOM_KEY]) // You can easily change the data sent to you.
        }, PendingIntent.FLAG_UPDATE_CURRENT)
```

Then, you should edit MainActivity because to display received data.

```kotlin
class MainActivity : AppCompatActivity() {
    companion object {
        val ARG_ID = "id"
        val ARG_CUSTOM_KEY = "custom_key"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.id.text = intent.getStringExtra(ARG_ID)
        binding.type.text = intent.getStringExtra(ARG_CUSTOM_KEY)
    }
}
```

## Licence

[MIT](https://github.com/kobaken0029/kotification/blob/master/LICENSE)

## Author

[kobaken0029](https://github.com/kobaken0029)
