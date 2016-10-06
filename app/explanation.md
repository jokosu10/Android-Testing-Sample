## Android .jar vs Android .jar

You read it right, there are two Android.jar. The first one is the one we're using to develop Android Apps.
The other one is the one Android uses to run Apps.

When you run your app, the implementation code, or Android internal API, resides within your phone.
That's why we can't simply get methods or variables from android.jar.

Let me show you a snippet when creating a MainActivity

```
MainActivity activity = new MainActivity();
activity.onCreate(null);
```

And if we trace back it methods call, eventually you will see that Activity needs a window object.

```
AppCompatDelegateImplV9(Context context, Window window, AppCompatCallback callback) {
        super(context, window, callback);
    }
```

This will throws Null Pointer Exception, since activity objects requires a window variable.
But Window variable only exist on your phone android.jar
