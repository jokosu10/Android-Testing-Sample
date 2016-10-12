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

## Testing Android MVP way

To solve this missing activity problem, we can use MVP architecture.
MVP allows us for separating concern for contract and implementation.

Assuming the view implementation, which is Android SDK, we can test our presenter to do it's job.


We can "test" our view to correctly implement what presenter want. But this doesn't really test the actual result.
What actually happened is we're blindly trusting Android SDK's framework to do its job.

## Shadow Activity
Sonic is not the only character who has Shadow, Activity also has ShadowActivity as well.
ShadowActivity has extra functionality to verify Activity action, like getting an intent.

## Espresso Syntax
Espresso Syntax consist of three part, View Matcher, View Action and View Assertion.
```
onView(withId(R.id.edit_text)).perform(typeText("Hello World"));
----------------------------    -------------------------------
        View Matcher                    View Action
```
I think the syntax is pretty self-explanatory,
View Matcher is for find a view, View Action is performing an action,
and View Assertion is to assert a view.

To assert a view, change View Action part into View Assertion.

```
onView(withId(R.id.editText)).check(doesNotExist());
----------------------------    -------------------
        View Matcher                View Assertion
```
