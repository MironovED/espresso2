//package ru.kkuzmichev.simpleappforespresso;
//
//
//import android.view.View;
//
//import androidx.recyclerview.widget.RecyclerView;
//import androidx.test.espresso.matcher.BoundedMatcher;
//
//import org.junit.runner.Description;
//
//import java.util.regex.Matcher;
//
//public class CustomViewMatcher {
//    public static Matcher<View> recyclerViewSizeMatchers(int size){
//        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
//            String result;
//
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("List size:" + size);
//                description.appendText("\nGet:");
//                description.appendText(result);
//            }
//
//            @Override
//            protected boolean matchesSafely(RecyclerView item) {
//                int items = item.getAdapter().getItemCount();
//                result = "List size:" + items;
//                return size == items;
//            }
//        };
//    }
//}
