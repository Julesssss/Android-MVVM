# Android MVVM

Kotlin Android application demonstrating the MVVM pattern with Android Architecture ViewModels and data binding. 

Developed using Test Driven Development process for faster development cycle, simpler debugging and high test coverage.

### Architecture
MVVM
 
[Android Arch ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

### Testing
Junit

Mockito

### Notes
- A ViewModel must never reference a view, Lifecycle, or any class that may hold a reference to the activity context. ([source]([https://developer.android.com/topic/libraries/architecture/viewmodel]())). This is solved by using AndroidViewModel as a base ViewModel class as it provides easy access to the application context.


![](https://i.imgur.com/UOhgdNa.png)
