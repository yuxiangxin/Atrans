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
public class AttributeValueMap {
    private static final String MODE_CONTAINS = "contains_match";
    private static final String MODE_WORD = "word_all";
    private static final String MODE_CONTAINS_ALL = "contains_all";

    static final java.util.Map<String, Attribute> Map = new LinkedHashMap<String, Attribute>() {
        {
            put("@+id/", new Attribute().setMode(MODE_CONTAINS).setText("$+id:"));
            put("@id/", new Attribute().setMode(MODE_CONTAINS).setText("$id:"));
            put("dp", new Attribute().setMode(MODE_CONTAINS).setIgnoreCase(true).setText("vp"));
            put("fp", new Attribute().setMode(MODE_CONTAINS).setIgnoreCase(true).setText("sp"));
            put("dip", new Attribute().setMode(MODE_CONTAINS).setIgnoreCase(true).setText("vp"));
            put("", new Attribute().setMode(MODE_WORD).setText("left"));
            put("", new Attribute().setMode(MODE_WORD).setText("top"));
            put("", new Attribute().setMode(MODE_WORD).setText("right"));
            put("", new Attribute().setMode(MODE_WORD).setText("bottom"));
            put("center_horizontal", new Attribute().setMode(MODE_WORD).setText("horizontal_center"));
            put("center_vertical", new Attribute().setMode(MODE_WORD).setText("vertical_center"));
            put("", new Attribute().setMode(MODE_WORD).setText("center"));
            put("", new Attribute().setMode(MODE_WORD).setText("start"));
            put("", new Attribute().setMode(MODE_WORD).setText("end"));
            put("", new Attribute().setMode(MODE_WORD).setText("day-month-year"));
            put("", new Attribute().setMode(MODE_WORD).setText("month-day-year"));
            put("", new Attribute().setMode(MODE_WORD).setText("year-month-day"));
            put("", new Attribute().setMode(MODE_WORD).setText("year-day-month"));
            put("", new Attribute().setMode(MODE_WORD).setText("day-month"));
            put("", new Attribute().setMode(MODE_WORD).setText("month-day"));
            put("", new Attribute().setMode(MODE_WORD).setText("year-month"));
            put("", new Attribute().setMode(MODE_WORD).setText("month-year"));
            put("", new Attribute().setMode(MODE_WORD).setText("only_year"));
            put("", new Attribute().setMode(MODE_WORD).setText("only_month"));
            put("", new Attribute().setMode(MODE_WORD).setText("only_day"));
            put("", new Attribute().setMode(MODE_WORD).setText("align_edges"));
            put("", new Attribute().setMode(MODE_WORD).setText("align_contents"));
            put("", new Attribute().setMode(MODE_WORD).setText("horizontal"));
            put("", new Attribute().setMode(MODE_WORD).setText("vertical"));
            put("fitCenter", new Attribute().setMode(MODE_WORD).setText("zoom_center"));
            put("fitStart", new Attribute().setMode(MODE_WORD).setText("zoom_start"));
            put("fitEnd", new Attribute().setMode(MODE_WORD).setText("zoom_end"));
            put("fitXY", new Attribute().setMode(MODE_WORD).setText("stretch"));
            put("centerInside", new Attribute().setMode(MODE_WORD).setText("inside"));
            put("centerCrop", new Attribute().setMode(MODE_WORD).setText("clip_center"));
            put("", new Attribute().setMode(MODE_WORD).setText("pattern_null"));
            put("", new Attribute().setMode(MODE_WORD).setText("pattern_text"));
            put("", new Attribute().setMode(MODE_WORD).setText("pattern_number"));
            put("", new Attribute().setMode(MODE_WORD).setText("pattern_password"));
            put("", new Attribute().setMode(MODE_WORD).setText("sans-serif"));
            put("", new Attribute().setMode(MODE_WORD).setText("sans-serif-medium"));
            put("", new Attribute().setMode(MODE_WORD).setText("HwChinese-medium"));
            put("", new Attribute().setMode(MODE_WORD).setText("sans-serif-condensed"));
            put("", new Attribute().setMode(MODE_WORD).setText("sans-serif-condensed-medium"));
            put("", new Attribute().setMode(MODE_WORD).setText("monospace"));
            put("", new Attribute().setMode(MODE_WORD).setText("unlimited"));
            put("", new Attribute().setMode(MODE_WORD).setText("none"));
            put("start", new Attribute().setMode(MODE_WORD).setText("ellipsis_at_start"));
            put("middle", new Attribute().setMode(MODE_WORD).setText("ellipsis_at_middle"));
            put("end", new Attribute().setMode(MODE_WORD).setText("ellipsis_at_end"));
            put("marquee", new Attribute().setMode(MODE_WORD).setText("auto_scrolling"));
            put("", new Attribute().setMode(MODE_WORD).setText("enter_key_type_unspecified"));
            put("", new Attribute().setMode(MODE_WORD).setText("enter_key_type_search"));
            put("", new Attribute().setMode(MODE_WORD).setText("enter_key_type_go"));
            put("", new Attribute().setMode(MODE_WORD).setText("enter_key_type_send"));
            put("", new Attribute().setMode(MODE_WORD).setText("ltr"));
            put("", new Attribute().setMode(MODE_WORD).setText("rtl"));
            put("", new Attribute().setMode(MODE_WORD).setText("inherit"));
            put("", new Attribute().setMode(MODE_WORD).setText("locale"));
            put("match_parent", new Attribute().setMode(MODE_WORD).setText("match_parent"));
            put("fill_parent", new Attribute().setMode(MODE_WORD).setText("match_content"));
            put("wrap_content", new Attribute().setMode(MODE_WORD).setText("match_content"));
            put("visible", new Attribute().setMode(MODE_WORD).setText("visible"));
            put("invisible", new Attribute().setMode(MODE_WORD).setText("invisible"));
            put("gone", new Attribute().setMode(MODE_WORD).setText("hide"));
            put("", new Attribute().setMode(MODE_WORD).setText("focus_disable"));
            put("", new Attribute().setMode(MODE_WORD).setText("focus_adaptable"));
            put("", new Attribute().setMode(MODE_WORD).setText("focus_enable"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_state_empty"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_state_hovered"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_state_focused"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_state_selected"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_state_pressed"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_state_disabled"));
            put("", new Attribute().setMode(MODE_WORD).setText("component_state_checked"));
            put("", new Attribute().setMode(MODE_WORD).setText("rectangle"));
            put("", new Attribute().setMode(MODE_WORD).setText("oval"));
            put("", new Attribute().setMode(MODE_WORD).setText("line"));
            put("", new Attribute().setMode(MODE_WORD).setText("arc"));
            put("", new Attribute().setMode(MODE_WORD).setText("path"));
            put("", new Attribute().setMode(MODE_WORD).setText("linear_gradient"));
            put("", new Attribute().setMode(MODE_WORD).setText("radial_gradient"));
            put("", new Attribute().setMode(MODE_WORD).setText("sweep_gradient"));
            put("", new Attribute().setMode(MODE_WORD).setText("butt"));
            put("", new Attribute().setMode(MODE_WORD).setText("round"));
            put("", new Attribute().setMode(MODE_WORD).setText("square"));
            put("", new Attribute().setMode(MODE_WORD).setText("miter"));
            put("", new Attribute().setMode(MODE_WORD).setText("bevel"));
            put("", new Attribute().setMode(MODE_WORD).setText("strokeColor"));
            put("", new Attribute().setMode(MODE_WORD).setText("fillColor"));
            put("", new Attribute().setMode(MODE_WORD).setText("linear"));
            put("", new Attribute().setMode(MODE_WORD).setText("radial"));
            put("", new Attribute().setMode(MODE_WORD).setText("sweep"));
            put("", new Attribute().setMode(MODE_WORD).setText("clamp"));
            put("", new Attribute().setMode(MODE_WORD).setText("repeat"));
            put("", new Attribute().setMode(MODE_WORD).setText("mirror"));

        }
    };
}
