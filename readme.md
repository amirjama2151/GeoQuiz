# Extending GeoQuiz

In this repository, you will find an empty application named GeoQuiz. You must complete it to the point of the end of Chapter 2 plus some extras.

## Customize the toast

Customize the toast given to show at the top of the screen instead of the bottom. You may use the `setGravity` function and the constants found in the `Gravity` class to accomplish this. Here is the Android documentation on this task: https://developer.android.com/reference/kotlin/android/widget/Toast#setgravity[]

## Add a listener to the TextView

The next button is nice, but what if the user could press the text itself to see the next question?

Use the `View.onClickListener` (similar to buttons) to add the Next functionality to the `TextView`

## Add a previous button

The user can go forward, but why not back? Add a previous button so that the user may return to the previous question. It should be horizontally in line with the Next button and vertically in line with the True button (before the next change).

## From Button to ImageButton

Let's make the UI look better and replace these ugly Next and Previous buttons so that they have icons instead of text. After all, icons are the universal language! (sarcasm)

Convert the two buttons to `ImageButton` instead of regular `Button`. Instead of `android:text`, you will need to have an `android:src` drawing an image from the `@drawable` resources. Select some free resources or create your own. Be sure to set `android:contentDescription` to support the visually impared and use `@string` resources for those descriptions.

## Add a score

There is no way for the user to know how many correct and incorrect guesses they have made so far. Add a text view to show the user's score and the code to track and update that view. It should show similarly to: `Score 3/8` if the user has guessed 3 questions correctly but answered 8 questions. You may place this text centered underneath the next/previous buttons.

## Turn in

1. Commit all of these changes to this repository.
2. Take screenshots of your program running and commit them to this repository.
3. **Push** your code to submit.
