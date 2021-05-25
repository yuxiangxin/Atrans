/*
 * Copyright 2021 yuxiangxin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.xiangxin.atrans.data;

import java.util.LinkedHashMap;

/**
 * @author yuxiangxin
 * @since 2021-05-24
 */
public class UIWidgetMap {
    static final java.util.Map<String, Attribute> Map = new LinkedHashMap<String, Attribute>() {
        {
            put("View",                                 new Attribute().setMode("word_all")      .setText("Component"));
            put("ViewStub",                             new Attribute().setMode("word_all")      .setText(""));
            put("SurfaceView",                          new Attribute().setMode("word_all")      .setText("SurfaceProvider"));
            put("GLSurfaceView",                        new Attribute().setMode("word_all")      .setText("SurfaceProvider"));
            put("VideoView",                            new Attribute().setMode("word_all")      .setText(""));
            put("ProgressBar",                          new Attribute().setMode("word_all")      .setText("ProgressBar"));
            put("SeekBar",                              new Attribute().setMode("word_all")      .setText("Slider"));
            put("AppCompatSeekBar",                     new Attribute().setMode("contains_all")  .setText("Slider"));
            put("RatingBar",                            new Attribute().setMode("word_all")      .setText("Rating"));
            put("AppCompatRatingBar",                   new Attribute().setMode("contains_all")  .setText("Rating"));
            put("ContentLoadingProgressBar",            new Attribute().setMode("contains_all")  .setText("ProgressBar"));
            put("Space",                                new Attribute().setMode("word_all")      .setText(""));
            put("ImageView",                            new Attribute().setMode("word_all")      .setText("Image"));
            put("ImageButton",                          new Attribute().setMode("word_all")      .setText("Image"));
            put("ZoomButton",                           new Attribute().setMode("word_all")      .setText(""));
            put("AppCompatImageButton",                 new Attribute().setMode("contains_all")  .setText("Image"));
            put("CheckableImageButton",                 new Attribute().setMode("contains_all")  .setText("Image"));
            put("VisibilityAwareImageButton",           new Attribute().setMode("contains_all")  .setText("Image"));
            put("FloatingActionButton",                 new Attribute().setMode("contains_all")  .setText(""));
            put("AppCompatImageView",                   new Attribute().setMode("contains_all")  .setText("Image"));
            put("QuickContactBadge",                    new Attribute().setMode("word_all")      .setText(""));
            put("ViewStubCompat",                       new Attribute().setMode("contains_all")  .setText(""));
            put("ConstraintHelper",                     new Attribute().setMode("contains_all")  .setText(""));
            put("Barrier",                              new Attribute().setMode("contains_all")  .setText(""));
            put("Group",                                new Attribute().setMode("contains_all")  .setText(""));
            put("MediaRouteButton",                     new Attribute().setMode("word_all")      .setText("Button"));
            put("TextureView",                          new Attribute().setMode("word_all")      .setText("TextureComponentEx"));
            put("ViewGroup",                            new Attribute().setMode("word_all")      .setText("ComponentContainer"));
            put("DrawerLayout",                         new Attribute().setMode("contains_all")  .setText(""));
            put("LinearLayout",                         new Attribute().setMode("word_all")      .setText("DirectionalLayout"));
            put("SnackbarContentLayout",                new Attribute().setMode("contains_all")  .setText(""));
            put("FitWindowsLinearLayout",               new Attribute().setMode("contains_all")  .setText(""));
            put("ZoomControls",                         new Attribute().setMode("word_all")      .setText(""));
            put("SearchView",                           new Attribute().setMode("word_all")      .setText(""));
            put("TableLayout",                          new Attribute().setMode("word_all")      .setText("TableLayout"));
            put("TextInputLayout",                      new Attribute().setMode("contains_all")  .setText(""));
            put("ListMenuItemView",                     new Attribute().setMode("contains_all")  .setText(""));
            put("ButtonBarLayout",                      new Attribute().setMode("contains_all")  .setText(""));
            put("RadioGroup",                           new Attribute().setMode("word_all")      .setText("RadioContainer"));
            put("AppBarLayout",                         new Attribute().setMode("contains_all")  .setText(""));
            put("ActionMenuView",                       new Attribute().setMode("word_all")      .setText(""));
            put("TableRow",                             new Attribute().setMode("word_all")      .setText(""));
            put("MaterialButtonToggleGroup",            new Attribute().setMode("contains_all")  .setText(""));
            put("TabWidget",                            new Attribute().setMode("word_all")      .setText(""));
            put("CircularRevealLinearLayout",           new Attribute().setMode("contains_all")  .setText(""));
            put("NumberPicker",                         new Attribute().setMode("word_all")      .setText(""));
            put("FrameLayout",                          new Attribute().setMode("word_all")      .setText("StackLayout"));
            put("CalendarView",                         new Attribute().setMode("word_all")      .setText(""));
            put("BottomNavigationView",                 new Attribute().setMode("contains_all")  .setText(""));
            put("FitWindowsFrameLayout",                new Attribute().setMode("contains_all")  .setText(""));
            put("ContentFrameLayout",                   new Attribute().setMode("contains_all")  .setText(""));
            put("NestedScrollView",                     new Attribute().setMode("contains_all")  .setText("NestedScrollView"));
            put("TabHost",                              new Attribute().setMode("word_all")      .setText(""));
            put("FragmentTabHost",                      new Attribute().setMode("contains_all")  .setText(""));
            put("MediaController",                      new Attribute().setMode("word_all")      .setText(""));
            put("GestureOverlayView",                   new Attribute().setMode("word_all")      .setText(""));
            put("GhostViewHolder",                      new Attribute().setMode("contains_all")  .setText(""));
            put("CollapsingToolbarLayout",              new Attribute().setMode("contains_all")  .setText(""));
            put("DatePicker",                           new Attribute().setMode("word_all")      .setText(""));
            put("BottomNavigationItemView",             new Attribute().setMode("contains_all")  .setText(""));
            put("HorizontalScrollView",                 new Attribute().setMode("word_all")      .setText(""));
            put("TabLayout",                            new Attribute().setMode("contains_all")  .setText("PageSliderIndicator"));
            put("ScrollingTabContainerView",            new Attribute().setMode("contains_all")  .setText(""));
            put("ScrollView",                           new Attribute().setMode("word_all")      .setText("ScrollView"));
            put("AppWidgetHostView",                    new Attribute().setMode("word_all")      .setText(""));
            put("ViewAnimator",                         new Attribute().setMode("word_all")      .setText(""));
            put("ViewSwitcher",                         new Attribute().setMode("word_all")      .setText(""));
            put("TextSwitcher",                         new Attribute().setMode("word_all")      .setText(""));
            put("ImageSwitcher",                        new Attribute().setMode("word_all")      .setText(""));
            put("ViewFlipper",                          new Attribute().setMode("word_all")      .setText(""));
            put("ActionBarContainer",                   new Attribute().setMode("contains_all")  .setText(""));
            put("TimePicker",                           new Attribute().setMode("word_all")      .setText("TimePicker"));
            put("CircularRevealFrameLayout",            new Attribute().setMode("contains_all")  .setText(""));
            put("TransformationChildLayout",            new Attribute().setMode("contains_all")  .setText(""));
            put("ScrimInsetsFrameLayout",               new Attribute().setMode("contains_all")  .setText(""));
            put("NavigationView",                       new Attribute().setMode("contains_all")  .setText(""));
            put("CardView",                             new Attribute().setMode("contains_all")  .setText(""));
            put("MaterialCardView",                     new Attribute().setMode("contains_all")  .setText(""));
            put("CircularRevealCardView",               new Attribute().setMode("contains_all")  .setText(""));
            put("TransformationChildCard",              new Attribute().setMode("contains_all")  .setText(""));
            put("ViewPager",                            new Attribute().setMode("contains_all")  .setText("PageSlider"));
            put("ViewPager2",                           new Attribute().setMode("contains_all")  .setText("PageSlider"));
            put("InlineContentView",                    new Attribute().setMode("word_all")      .setText(""));
            put("LinearLayoutCompat",                   new Attribute().setMode("contains_all")  .setText(""));
            put("AlertDialogLayout",                    new Attribute().setMode("contains_all")  .setText(""));
            put("ForegroundLinearLayout",               new Attribute().setMode("contains_all")  .setText(""));
            put("NavigationMenuItemView",               new Attribute().setMode("contains_all")  .setText(""));
            put("PagerTitleStrip",                      new Attribute().setMode("contains_all")  .setText(""));
            put("PagerTabStrip",                        new Attribute().setMode("contains_all")  .setText(""));
            put("WebView",                              new Attribute().setMode("word_all")      .setText("WebView"));
            put("SlidingDrawer",                        new Attribute().setMode("word_all")      .setText(""));
            put("RecyclerView",                         new Attribute().setMode("contains_all")  .setText("ListContainer"));
            put("NavigationMenuView",                   new Attribute().setMode("contains_all")  .setText(""));
            put("AdapterView",                          new Attribute().setMode("word_all")      .setText(""));
            put("AdapterViewAnimator",                  new Attribute().setMode("word_all")      .setText(""));
            put("StackView",                            new Attribute().setMode("word_all")      .setText(""));
            put("AdapterViewFlipper",                   new Attribute().setMode("word_all")      .setText(""));
            put("Gallery",                              new Attribute().setMode("word_all")      .setText(""));
            put("Spinner",                              new Attribute().setMode("word_all")      .setText(""));
            put("AppCompatSpinner",                     new Attribute().setMode("contains_all")  .setText(""));
            put("GridView",                             new Attribute().setMode("word_all")      .setText("ListContainer"));
            put("MaterialCalendarGridView",             new Attribute().setMode("contains_all")  .setText("ListContainer"));
            put("ListView",                             new Attribute().setMode("word_all")      .setText("ListContainer"));
            put("DropDownListView",                     new Attribute().setMode("contains_all")  .setText(""));
            put("ExpandedMenuView",                     new Attribute().setMode("contains_all")  .setText(""));
            put("ExpandableListView",                   new Attribute().setMode("word_all")      .setText("ListContainer"));
            put("TvView",                               new Attribute().setMode("word_all")      .setText(""));
            put("GridLayout",                           new Attribute().setMode("word_all")      .setText("ListContainer"));
            put("CircularRevealGridLayout",             new Attribute().setMode("contains_all")  .setText(""));
            put("ActionBarContextView",                 new Attribute().setMode("contains_all")  .setText(""));
            put("CoordinatorLayout",                    new Attribute().setMode("contains_all")  .setText(""));
            put("CircularRevealCoordinatorLayout",      new Attribute().setMode("contains_all")  .setText(""));
            put("ActionBarOverlayLayout",               new Attribute().setMode("contains_all")  .setText(""));
            put("FragmentBreadCrumbs",                  new Attribute().setMode("word_all")      .setText(""));
            put("BaselineLayout",                       new Attribute().setMode("contains_all")  .setText(""));
            put("BottomNavigationMenuView",             new Attribute().setMode("contains_all")  .setText(""));
            put("ActivityChooserView",                  new Attribute().setMode("contains_all")  .setText(""));
            put("ConstraintLayout",                     new Attribute().setMode("contains_all")  .setText(""));
            put("Toolbar",                              new Attribute().setMode("contains_all")  .setText(""));
            put("BottomAppBar",                         new Attribute().setMode("contains_all")  .setText(""));
            put("MaterialToolbar",                      new Attribute().setMode("contains_all")  .setText(""));
            put("RelativeLayout",                       new Attribute().setMode("word_all")      .setText("DependentLayout"));
            put("DialerFilter",                         new Attribute().setMode("word_all")      .setText(""));
            put("TwoLineListItem",                      new Attribute().setMode("word_all")      .setText(""));
            put("CircularRevealRelativeLayout",         new Attribute().setMode("contains_all")  .setText(""));
            put("GhostViewPort",                        new Attribute().setMode("contains_all")  .setText(""));
            put("Constraints",                          new Attribute().setMode("contains_all")  .setText(""));
            put("FlowLayout",                           new Attribute().setMode("contains_all")  .setText(""));
            put("ChipGroup",                            new Attribute().setMode("contains_all")  .setText(""));
            put("KeyboardView",                         new Attribute().setMode("word_all")      .setText(""));
            put("TextView",                             new Attribute().setMode("word_all")      .setText("Text"));
            put("AppCompatTextView",                    new Attribute().setMode("contains_all")  .setText("Text"));
            put("MaterialTextView",                     new Attribute().setMode("contains_all")  .setText(""));
            put("ActionMenuItemView",                   new Attribute().setMode("contains_all")  .setText(""));
            put("DialogTitle",                          new Attribute().setMode("contains_all")  .setText(""));
            put("DigitalClock",                         new Attribute().setMode("word_all")      .setText(""));
            put("CheckedTextView",                      new Attribute().setMode("word_all")      .setText(""));
            put("AppCompatCheckedTextView",             new Attribute().setMode("contains_all")  .setText(""));
            put("TextClock",                            new Attribute().setMode("word_all")      .setText("Clock"));
            put("Button",                               new Attribute().setMode("word_all")      .setText("Button"));
            put("CompoundButton",                       new Attribute().setMode("word_all")      .setText("Button"));
            put("Switch",                               new Attribute().setMode("word_all")      .setText("Switch"));
            put("SwitchCompat",                         new Attribute().setMode("contains_all")  .setText(""));
            put("SwitchMaterial",                       new Attribute().setMode("contains_all")  .setText(""));
            put("CheckBox",                             new Attribute().setMode("word_all")      .setText("Checkbox"));
            put("AppCompatCheckBox",                    new Attribute().setMode("contains_all")  .setText("Checkbox"));
            put("Chip",                                 new Attribute().setMode("contains_all")  .setText(""));
            put("MaterialCheckBox",                     new Attribute().setMode("contains_all")  .setText(""));
            put("RadioButton",                          new Attribute().setMode("word_all")      .setText("RadioButton"));
            put("AppCompatRadioButton",                 new Attribute().setMode("contains_all")  .setText("RadioButton"));
            put("MaterialRadioButton",                  new Attribute().setMode("contains_all")  .setText(""));
            put("ToggleButton",                         new Attribute().setMode("word_all")      .setText("ToggleButton"));
            put("AppCompatToggleButton",                new Attribute().setMode("contains_all")  .setText("RadioButton"));
            put("AppCompatButton",                      new Attribute().setMode("contains_all")  .setText("RadioButton"));
            put("MaterialButton",                       new Attribute().setMode("contains_all")  .setText(""));
            put("ExtendedFloatingActionButton",         new Attribute().setMode("contains_all")  .setText(""));
            put("Chronometer",                          new Attribute().setMode("word_all")      .setText(""));
            put("EditText",                             new Attribute().setMode("word_all")      .setText("TextField"));
            put("ExtractEditText",                      new Attribute().setMode("word_all")      .setText("TextField"));
            put("AppCompatEditText",                    new Attribute().setMode("contains_all")  .setText("TextField"));
            put("TextInputEditText",                    new Attribute().setMode("contains_all")  .setText("TextField"));
            put("AutoCompleteTextView",                 new Attribute().setMode("word_all")      .setText("TextField"));
            put("AppCompatAutoCompleteTextView",        new Attribute().setMode("contains_all")  .setText("TextField"));
            put("MultiAutoCompleteTextView",            new Attribute().setMode("word_all")      .setText(""));
            put("AppCompatMultiAutoCompleteTextView",   new Attribute().setMode("contains_all")  .setText(""));
            put("TabItem",                              new Attribute().setMode("contains_all")  .setText(""));
            put("Placeholder",                          new Attribute().setMode("contains_all")  .setText(""));
            put("AnalogClock",                          new Attribute().setMode("word_all")      .setText(""));
            put("Guideline",                            new Attribute().setMode("contains_all")  .setText(""));
        }
    };
}
