package ru.kkuzmichev.simpleappforespresso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import androidx.appcompat.widget.AppCompatImageButton;
import androidx.test.espresso.ViewInteraction;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import androidx.test.espresso.IdlingRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;


@RunWith(AndroidJUnit4.class)
public class IdlingTestCustom {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Before
    public void registerIdlingResources(){
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    public void secondTestOpenGallery(){
        ViewInteraction imageButton = onView(isAssignableFrom(AppCompatImageButton.class));
        imageButton.check(matches(isDisplayed()));
        imageButton.perform(click());
        ViewInteraction gallery = onView(withId(R.id.nav_gallery));
        gallery.perform(click());


        ViewInteraction recyclerView = onView(withId(R.id.recycle_view));

        recyclerView.check(matches(isDisplayed()));

    }

}
