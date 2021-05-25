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
 * @since 2021-05-25
 */
public class AttributeNameMap {
    public static final String MODE_CONTAINS = "contains_match";
    public static final String MODE_WORD = "word_all";
    public static final String MODE_CONTAINS_ALL = "contains_all";

    static final java.util.Map<String, Attribute> Map = new LinkedHashMap<String, Attribute>() {
        {
            put("layout_gravity", new Attribute().setMode(MODE_WORD).setText("layout_alignment"));
            put("gravity", new Attribute().setMode(MODE_WORD).setText("alignment"));
            put("", new Attribute().setMode(MODE_WORD).setText("format"));
            put("", new Attribute().setMode(MODE_WORD).setText("count_down"));
            put("", new Attribute().setMode(MODE_WORD).setText("marked"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_color_on"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_color_off"));
            put("", new Attribute().setMode(MODE_WORD).setText("check_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("date_order"));
            put("", new Attribute().setMode(MODE_WORD).setText("day_fixed"));
            put("", new Attribute().setMode(MODE_WORD).setText("month_fixed"));
            put("", new Attribute().setMode(MODE_WORD).setText("year_fixed"));
            put("", new Attribute().setMode(MODE_WORD).setText("max_date"));
            put("", new Attribute().setMode(MODE_WORD).setText("min_date"));
            put("textSize", new Attribute().setMode(MODE_WORD).setText("text_size"));
            put("", new Attribute().setMode(MODE_WORD).setText("normal_text_size"));
            put("", new Attribute().setMode(MODE_WORD).setText("selected_text_size"));
            put("", new Attribute().setMode(MODE_WORD).setText("normal_text_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("selected_text_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("operated_text_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("selected_normal_text_margin_ratio"));
            put("", new Attribute().setMode(MODE_WORD).setText("top_line_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("bottom_line_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("wheel_mode_enabled"));
            put("", new Attribute().setMode(MODE_WORD).setText("selector_item_num"));
            put("", new Attribute().setMode(MODE_WORD).setText("shader_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("basement"));
            put("", new Attribute().setMode(MODE_WORD).setText("alignment_type"));
            put("", new Attribute().setMode(MODE_WORD).setText("column_count"));
            put("", new Attribute().setMode(MODE_WORD).setText("row_count"));
            put("", new Attribute().setMode(MODE_WORD).setText("orientation"));
            put("", new Attribute().setMode(MODE_WORD).setText("clip_direction"));
            put("", new Attribute().setMode(MODE_WORD).setText("clip_alignment"));
            put("src", new Attribute().setMode(MODE_WORD).setText("image_src"));
            put("scaleType", new Attribute().setMode(MODE_WORD).setText("scale_mode"));
            put("maxHeight", new Attribute().setMode(MODE_WORD).setText("max_height"));
            put("maxWidth", new Attribute().setMode(MODE_WORD).setText("max_width"));
            put("layout_weight", new Attribute().setMode(MODE_WORD).setText("weight"));
            put("", new Attribute().setMode(MODE_WORD).setText("rebound_effect"));
            put("", new Attribute().setMode(MODE_WORD).setText("element_padding"));
            put("", new Attribute().setMode(MODE_WORD).setText("max_value"));
            put("", new Attribute().setMode(MODE_WORD).setText("min_value"));
            put("", new Attribute().setMode(MODE_WORD).setText("value"));
            put("", new Attribute().setMode(MODE_WORD).setText("infinite"));
            put("max", new Attribute().setMode(MODE_WORD).setText("max"));
            put("min", new Attribute().setMode(MODE_WORD).setText("min"));
            put("progress", new Attribute().setMode(MODE_WORD).setText("progress"));
            put("", new Attribute().setMode(MODE_WORD).setText("vice_progress"));
            put("", new Attribute().setMode(MODE_WORD).setText("step"));
            put("", new Attribute().setMode(MODE_WORD).setText("infinite_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("background_instruct_element"));
            put("progressDrawable", new Attribute().setMode(MODE_WORD).setText("progress_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("vice_progress_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("progress_hint_text"));
            put("", new Attribute().setMode(MODE_WORD).setText("progress_hint_text_size"));
            put("", new Attribute().setMode(MODE_WORD).setText("progress_hint_text_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("progress_hint_text_alignment"));
            put("", new Attribute().setMode(MODE_WORD).setText("progress_width"));
            put("", new Attribute().setMode(MODE_WORD).setText("progress_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("divider_lines_enabled"));
            put("", new Attribute().setMode(MODE_WORD).setText("divider_lines_number"));
            put("", new Attribute().setMode(MODE_WORD).setText("marked_button"));
            put("", new Attribute().setMode(MODE_WORD).setText("rating_items"));
            put("", new Attribute().setMode(MODE_WORD).setText("operable"));
            put("", new Attribute().setMode(MODE_WORD).setText("score"));
            put("", new Attribute().setMode(MODE_WORD).setText("grain_size"));
            put("layout_toLeftOf", new Attribute().setMode(MODE_WORD).setText("left_of"));
            put("layout_toRightOf", new Attribute().setMode(MODE_WORD).setText("right_of"));
            put("layout_above", new Attribute().setMode(MODE_WORD).setText("above"));
            put("layout_below", new Attribute().setMode(MODE_WORD).setText("below"));
            put("layout_alignBaseline", new Attribute().setMode(MODE_WORD).setText("align_baseline"));
            put("layout_alignLeft", new Attribute().setMode(MODE_WORD).setText("align_left"));
            put("layout_alignTop", new Attribute().setMode(MODE_WORD).setText("align_top"));
            put("layout_alignRight", new Attribute().setMode(MODE_WORD).setText("align_right"));
            put("layout_alignBottom", new Attribute().setMode(MODE_WORD).setText("align_bottom"));
            put("layout_alignParentLeft", new Attribute().setMode(MODE_WORD).setText("align_parent_left"));
            put("layout_alignParentTop", new Attribute().setMode(MODE_WORD).setText("align_parent_top"));
            put("layout_alignParentRight", new Attribute().setMode(MODE_WORD).setText("align_parent_right"));
            put("layout_alignParentBottom", new Attribute().setMode(MODE_WORD).setText("align_parent_bottom"));
            put("layout_centerInParent", new Attribute().setMode(MODE_WORD).setText("center_in_parent"));
            put("layout_centerHorizontal", new Attribute().setMode(MODE_WORD).setText("horizontal_center"));
            put("layout_centerVertical", new Attribute().setMode(MODE_WORD).setText("vertical_center"));
            put("layout_toStartOf", new Attribute().setMode(MODE_WORD).setText("start_of"));
            put("layout_toEndOf", new Attribute().setMode(MODE_WORD).setText("end_of"));
            put("layout_alignStart", new Attribute().setMode(MODE_WORD).setText("align_start"));
            put("layout_alignEnd", new Attribute().setMode(MODE_WORD).setText("align_end"));
            put("layout_alignParentStart", new Attribute().setMode(MODE_WORD).setText("align_parent_start"));
            put("layout_alignParentEnd", new Attribute().setMode(MODE_WORD).setText("align_parent_end"));
            put("", new Attribute().setMode(MODE_WORD).setText("reference_size"));
            put("", new Attribute().setMode(MODE_WORD).setText("start_angle"));
            put("", new Attribute().setMode(MODE_WORD).setText("max_angle"));
            put("", new Attribute().setMode(MODE_WORD).setText("match_viewport"));
            put("", new Attribute().setMode(MODE_WORD).setText("query_hint"));
            put("", new Attribute().setMode(MODE_WORD).setText("query_text_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("thumb_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_state_on"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_state_off"));
            put("", new Attribute().setMode(MODE_WORD).setText("track_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("tab_icon_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("mode_12_hour"));
            put("", new Attribute().setMode(MODE_WORD).setText("mode_24_hour"));
            put("", new Attribute().setMode(MODE_WORD).setText("time_zone"));
            put("", new Attribute().setMode(MODE_WORD).setText("time"));
            put("text", new Attribute().setMode(MODE_WORD).setText("text"));
            put("textColor", new Attribute().setMode(MODE_WORD).setText("text_color"));
            put("hint", new Attribute().setMode(MODE_WORD).setText("hint"));
            put("textColorHint", new Attribute().setMode(MODE_WORD).setText("hint_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("selection_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("bubble_width"));
            put("", new Attribute().setMode(MODE_WORD).setText("bubble_height"));
            put("", new Attribute().setMode(MODE_WORD).setText("bubble_left_width"));
            put("", new Attribute().setMode(MODE_WORD).setText("bubble_left_height"));
            put("", new Attribute().setMode(MODE_WORD).setText("bubble_right_width"));
            put("", new Attribute().setMode(MODE_WORD).setText("bubble_right_height"));
            put("textAlignment", new Attribute().setMode(MODE_WORD).setText("text_alignment"));
            put("", new Attribute().setMode(MODE_WORD).setText("multiple_lines"));
            put("", new Attribute().setMode(MODE_WORD).setText("auto_font_size"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollable"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_cursor_visible"));
            put("maxLines", new Attribute().setMode(MODE_WORD).setText("max_text_lines"));
            put("lineSpacingExtra", new Attribute().setMode(MODE_WORD).setText("additional_line_spacing"));
            put("lineHeight", new Attribute().setMode(MODE_WORD).setText("line_height_num"));
            put("inputType", new Attribute().setMode(MODE_WORD).setText("text_input_type"));
            put("drawableLeft", new Attribute().setMode(MODE_WORD).setText("element_left"));
            put("drawableTop", new Attribute().setMode(MODE_WORD).setText("element_top"));
            put("drawableRight", new Attribute().setMode(MODE_WORD).setText("element_right"));
            put("drawableBottom", new Attribute().setMode(MODE_WORD).setText("element_bottom"));
            put("drawableStart", new Attribute().setMode(MODE_WORD).setText("element_start"));
            put("drawableEnd", new Attribute().setMode(MODE_WORD).setText("element_end"));
            put("", new Attribute().setMode(MODE_WORD).setText("element_cursor_bubble"));
            put("", new Attribute().setMode(MODE_WORD).setText("element_selection_left_bubble"));
            put("", new Attribute().setMode(MODE_WORD).setText("element_selection_right_bubble"));
            put("textStyle", new Attribute().setMode(MODE_WORD).setText("text_font"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_weight"));
            put("", new Attribute().setMode(MODE_WORD).setText("italic"));
            put("", new Attribute().setMode(MODE_WORD).setText("padding_for_text"));
            put("", new Attribute().setMode(MODE_WORD).setText("auto_scrolling_count"));
            put("", new Attribute().setMode(MODE_WORD).setText("auto_scrolling_duration"));
            put("", new Attribute().setMode(MODE_WORD).setText("truncation_mode"));
            put("", new Attribute().setMode(MODE_WORD).setText("input_enter_key_type"));
            put("", new Attribute().setMode(MODE_WORD).setText("hour"));
            put("", new Attribute().setMode(MODE_WORD).setText("second"));
            put("", new Attribute().setMode(MODE_WORD).setText("minute"));
            put("", new Attribute().setMode(MODE_WORD).setText("am_pm_order"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_am"));
            put("", new Attribute().setMode(MODE_WORD).setText("text_pm"));
            put("", new Attribute().setMode(MODE_WORD).setText("title"));
            put("", new Attribute().setMode(MODE_WORD).setText("subtitle"));
            put("", new Attribute().setMode(MODE_WORD).setText("logo"));
            put("", new Attribute().setMode(MODE_WORD).setText("logo_description"));
            put("", new Attribute().setMode(MODE_WORD).setText("title_margin_start"));
            put("", new Attribute().setMode(MODE_WORD).setText("title_margin_top"));
            put("", new Attribute().setMode(MODE_WORD).setText("title_margin_end"));
            put("", new Attribute().setMode(MODE_WORD).setText("title_margin_bottom"));
            put("", new Attribute().setMode(MODE_WORD).setText("title_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("subtitle_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("id"));
            put("", new Attribute().setMode(MODE_WORD).setText("theme"));
            put("", new Attribute().setMode(MODE_WORD).setText("remote"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_fading_delay"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_fading_duration"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_start_angle"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_sweep_angle"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_thickness"));
            put("layoutDirection", new Attribute().setMode(MODE_WORD).setText("layout_direction"));
            put("layout_width", new Attribute().setMode(MODE_WORD).setText("width"));
            put("layout_height", new Attribute().setMode(MODE_WORD).setText("height"));
            put("layout_margin", new Attribute().setMode(MODE_WORD).setText("margin"));
            put("layout_marginLeft", new Attribute().setMode(MODE_WORD).setText("left_margin"));
            put("layout_marginTop", new Attribute().setMode(MODE_WORD).setText("top_margin"));
            put("layout_marginRight", new Attribute().setMode(MODE_WORD).setText("right_margin"));
            put("layout_marginBottom", new Attribute().setMode(MODE_WORD).setText("bottom_margin"));
            put("layout_marginStart", new Attribute().setMode(MODE_WORD).setText("start_margin"));
            put("layout_marginEnd", new Attribute().setMode(MODE_WORD).setText("end_margin"));
            put("background", new Attribute().setMode(MODE_WORD).setText("background_element"));
            put("foreground", new Attribute().setMode(MODE_WORD).setText("foreground_element"));
            put("minWidth", new Attribute().setMode(MODE_WORD).setText("min_width"));
            put("minHeight", new Attribute().setMode(MODE_WORD).setText("min_height"));
            put("padding", new Attribute().setMode(MODE_WORD).setText("padding"));
            put("paddingLeft", new Attribute().setMode(MODE_WORD).setText("left_padding"));
            put("paddingRight", new Attribute().setMode(MODE_WORD).setText("right_padding"));
            put("paddingStart", new Attribute().setMode(MODE_WORD).setText("start_padding"));
            put("paddingEnd", new Attribute().setMode(MODE_WORD).setText("end_padding"));
            put("", new Attribute().setMode(MODE_WORD).setText("focus_border_width"));
            put("", new Attribute().setMode(MODE_WORD).setText("focus_border_padding"));
            put("paddingTop", new Attribute().setMode(MODE_WORD).setText("top_padding"));
            put("paddingBottom", new Attribute().setMode(MODE_WORD).setText("bottom_padding"));
            put("enabled", new Attribute().setMode(MODE_WORD).setText("enabled"));
            put("visibility", new Attribute().setMode(MODE_WORD).setText("visibility"));
            put("clickable", new Attribute().setMode(MODE_WORD).setText("clickable"));
            put("longClickable", new Attribute().setMode(MODE_WORD).setText("long_click_enabled"));
            put("focusable", new Attribute().setMode(MODE_WORD).setText("focusable"));
            put("focusableInTouchMode", new Attribute().setMode(MODE_WORD).setText("focusable_in_touch"));
            put("fadeScrollbars", new Attribute().setMode(MODE_WORD).setText("scrollbar_fading_enabled"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_overlap_enabled"));
            put("", new Attribute().setMode(MODE_WORD).setText("focus_border_enable"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_description"));
            put("alpha", new Attribute().setMode(MODE_WORD).setText("alpha"));
            put("", new Attribute().setMode(MODE_WORD).setText("pivot_x"));
            put("", new Attribute().setMode(MODE_WORD).setText("pivot_y"));
            put("rotation", new Attribute().setMode(MODE_WORD).setText("rotate"));
            put("scaleX", new Attribute().setMode(MODE_WORD).setText("scale_x"));
            put("scaleY", new Attribute().setMode(MODE_WORD).setText("scale_y"));
            put("translationX", new Attribute().setMode(MODE_WORD).setText("translation_x"));
            put("translationY", new Attribute().setMode(MODE_WORD).setText("translation_y"));
            put("", new Attribute().setMode(MODE_WORD).setText("focus_border_radius"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("scrollbar_background_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("page_cache_size"));
            put("", new Attribute().setMode(MODE_WORD).setText("item_offset"));
            put("", new Attribute().setMode(MODE_WORD).setText("normal_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("selected_element"));
            put("", new Attribute().setMode(MODE_WORD).setText("unselected_dot_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("selected_dot_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("background_start_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("background_end_color"));
            put("", new Attribute().setMode(MODE_WORD).setText("layout"));
            put("", new Attribute().setMode(MODE_WORD).setText("state"));
            put("", new Attribute().setMode(MODE_WORD).setText("element"));
            put("shape", new Attribute().setMode(MODE_WORD).setText("shape"));
            put("", new Attribute().setMode(MODE_WORD).setText("radius"));
            put("", new Attribute().setMode(MODE_WORD).setText("left_top_x"));
            put("", new Attribute().setMode(MODE_WORD).setText("left_top_y"));
            put("", new Attribute().setMode(MODE_WORD).setText("right_top_x"));
            put("", new Attribute().setMode(MODE_WORD).setText("right_top_y"));
            put("", new Attribute().setMode(MODE_WORD).setText("right_bottom_x"));
            put("", new Attribute().setMode(MODE_WORD).setText("right_bottom_y"));
            put("", new Attribute().setMode(MODE_WORD).setText("left_bottom_x"));
            put("", new Attribute().setMode(MODE_WORD).setText("left_bottom_y"));
            put("", new Attribute().setMode(MODE_WORD).setText("color"));
            put("", new Attribute().setMode(MODE_WORD).setText("colors"));
            put("", new Attribute().setMode(MODE_WORD).setText("shader_type"));
            put("", new Attribute().setMode(MODE_WORD).setText("left"));
            put("", new Attribute().setMode(MODE_WORD).setText("right"));
            put("", new Attribute().setMode(MODE_WORD).setText("top"));
            put("", new Attribute().setMode(MODE_WORD).setText("bottom"));
            put("", new Attribute().setMode(MODE_WORD).setText("viewportWidth"));
            put("", new Attribute().setMode(MODE_WORD).setText("viewportHeight"));
            put("", new Attribute().setMode(MODE_WORD).setText("autoMirrored"));
            put("", new Attribute().setMode(MODE_WORD).setText("pivotX"));
            put("", new Attribute().setMode(MODE_WORD).setText("pivotY"));
            put("", new Attribute().setMode(MODE_WORD).setText("scaleX"));
            put("", new Attribute().setMode(MODE_WORD).setText("scaleY"));
            put("", new Attribute().setMode(MODE_WORD).setText("translateX"));
            put("", new Attribute().setMode(MODE_WORD).setText("translateY"));
            put("", new Attribute().setMode(MODE_WORD).setText("pathData"));
            put("", new Attribute().setMode(MODE_WORD).setText("strokeWidth"));
            put("", new Attribute().setMode(MODE_WORD).setText("strokeColor"));
            put("", new Attribute().setMode(MODE_WORD).setText("strokeAlpha"));
            put("", new Attribute().setMode(MODE_WORD).setText("fillColor"));
            put("", new Attribute().setMode(MODE_WORD).setText("fillAlpha"));
            put("", new Attribute().setMode(MODE_WORD).setText("trimPathStart"));
            put("", new Attribute().setMode(MODE_WORD).setText("trimPathEnd"));
            put("", new Attribute().setMode(MODE_WORD).setText("trimPathOffset"));
            put("", new Attribute().setMode(MODE_WORD).setText("strokeLineCap"));
            put("", new Attribute().setMode(MODE_WORD).setText("strokeLineJoin"));
            put("", new Attribute().setMode(MODE_WORD).setText("strokeMiterLimit"));
            put("", new Attribute().setMode(MODE_WORD).setText("name"));
            put("", new Attribute().setMode(MODE_WORD).setText("type"));
            put("", new Attribute().setMode(MODE_WORD).setText("tileMode"));
            put("", new Attribute().setMode(MODE_WORD).setText("startX"));
            put("", new Attribute().setMode(MODE_WORD).setText("startY"));
            put("", new Attribute().setMode(MODE_WORD).setText("endX"));
            put("", new Attribute().setMode(MODE_WORD).setText("endY"));
            put("", new Attribute().setMode(MODE_WORD).setText("centerX"));
            put("", new Attribute().setMode(MODE_WORD).setText("centerY"));
            put("", new Attribute().setMode(MODE_WORD).setText("gradientRadius"));
            put("", new Attribute().setMode(MODE_WORD).setText("offset"));



            put("", new Attribute().setMode(MODE_WORD).setText(""));
            put("", new Attribute().setMode(MODE_WORD).setText(""));
        }
    };
}
