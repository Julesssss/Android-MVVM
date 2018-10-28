# Android MVVM

Kotlin Android application demonstrating the MVVM pattern with Android Architecture ViewModels and data binding. 

Developed using Test Driven Development process for faster development cycle, simpler debugging and high test coverage.

### Architecture
MVVM
 
[Android Arch ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) (1.1.1)

### Testing
[Junit](https://junit.org/junit4/) (4.12)

[Mockito](http://site.mockito.org/) (2.11.0)

[Espresso](https://developer.android.com/training/testing/espresso/) (3.0.2)

### Documentation

The following docs were auto generated with the [Dokka](https://github.com/Kotlin/dokka) plugin

[Documentation](https://github.com/Julesssss/Android-MVVM/blob/master/documentation/index.md)

### Notes
- The use of AndroidViewModel means that state persistence on config change is handled for us.
- A ViewModel must never reference a view, Lifecycle, or any class that may hold a reference to the activity context.[source](https://developer.android.com/topic/libraries/architecture/viewmodel). This is solved by using AndroidViewModel as a base ViewModel class as it provides easy access to the application context.


![](https://i.imgur.com/UOhgdNa.png)
