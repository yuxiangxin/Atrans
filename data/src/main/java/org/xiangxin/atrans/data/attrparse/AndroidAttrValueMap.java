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

package org.xiangxin.atrans.data.attrparse;

import org.xiangxin.atrans.data.Attribute;

import java.util.HashMap;

/**
 * @author yuxiangxin
 * @since 2021-05-25
 */
public class AndroidAttrValueMap {
    private static final String MODE_CONTAINS = "contains_match";
    private static final String MODE_WORD = "word_all";
    private static final String MODE_CONTAINS_ALL = "contains_all";

    static final HashMap<String, Attribute> UI_WIDGET_MAP = new HashMap<String, Attribute>() {
        {
            put("", new Attribute().setMode(MODE_WORD).setText("floating"));
            put("", new Attribute().setMode(MODE_WORD).setText("atThumb"));
            put("", new Attribute().setMode(MODE_WORD).setText("aboveThumb"));
            put("", new Attribute().setMode(MODE_WORD).setText("wrap_content"));
            put("", new Attribute().setMode(MODE_WORD).setText("default"));
            put("", new Attribute().setMode(MODE_WORD).setText("shortEdges"));
            put("", new Attribute().setMode(MODE_WORD).setText("never"));
            put("", new Attribute().setMode(MODE_WORD).setText("always"));
            put("", new Attribute().setMode(MODE_WORD).setText("normal"));
            put("", new Attribute().setMode(MODE_WORD).setText("micro"));
            put("", new Attribute().setMode(MODE_WORD).setText("auto"));
            put("", new Attribute().setMode(MODE_WORD).setText("visible"));
            put("", new Attribute().setMode(MODE_WORD).setText("invisible"));
            put("", new Attribute().setMode(MODE_WORD).setText("gone"));
            put("", new Attribute().setMode(MODE_WORD).setText("insideOverlay"));
            put("", new Attribute().setMode(MODE_WORD).setText("insideInset"));
            put("", new Attribute().setMode(MODE_WORD).setText("outsideOverlay"));
            put("", new Attribute().setMode(MODE_WORD).setText("outsideInset"));
            put("", new Attribute().setMode(MODE_WORD).setText("low"));
            put("", new Attribute().setMode(MODE_WORD).setText("high"));
            put("", new Attribute().setMode(MODE_WORD).setText("ifContentScrolls"));
            put("", new Attribute().setMode(MODE_WORD).setText("defaultPosition"));
            put("", new Attribute().setMode(MODE_WORD).setText("left"));
            put("", new Attribute().setMode(MODE_WORD).setText("right"));
            put("", new Attribute().setMode(MODE_WORD).setText("none"));
            put("", new Attribute().setMode(MODE_WORD).setText("software"));
            put("", new Attribute().setMode(MODE_WORD).setText("hardware"));
            put("", new Attribute().setMode(MODE_WORD).setText("ltr"));
            put("", new Attribute().setMode(MODE_WORD).setText("rtl"));
            put("", new Attribute().setMode(MODE_WORD).setText("inherit"));
            put("", new Attribute().setMode(MODE_WORD).setText("locale"));
            put("", new Attribute().setMode(MODE_WORD).setText("firstStrong"));
            put("", new Attribute().setMode(MODE_WORD).setText("anyRtl"));
            put("", new Attribute().setMode(MODE_WORD).setText("firstStrongLtr"));
            put("", new Attribute().setMode(MODE_WORD).setText("firstStrongRtl"));
            put("", new Attribute().setMode(MODE_WORD).setText("gravity"));
            put("", new Attribute().setMode(MODE_WORD).setText("textStart"));
            put("", new Attribute().setMode(MODE_WORD).setText("textEnd"));
            put("", new Attribute().setMode(MODE_WORD).setText("center"));
            put("", new Attribute().setMode(MODE_WORD).setText("viewStart"));
            put("", new Attribute().setMode(MODE_WORD).setText("viewEnd"));
            put("", new Attribute().setMode(MODE_WORD).setText("yes"));
            put("", new Attribute().setMode(MODE_WORD).setText("no"));
            put("", new Attribute().setMode(MODE_WORD).setText("noHideDescendants"));
            put("", new Attribute().setMode(MODE_WORD).setText("polite"));
            put("", new Attribute().setMode(MODE_WORD).setText("assertive"));
            put("", new Attribute().setMode(MODE_WORD).setText("src_over"));
            put("", new Attribute().setMode(MODE_WORD).setText("src_in"));
            put("", new Attribute().setMode(MODE_WORD).setText("src_atop"));
            put("", new Attribute().setMode(MODE_WORD).setText("multiply"));
            put("", new Attribute().setMode(MODE_WORD).setText("screen"));
            put("", new Attribute().setMode(MODE_WORD).setText("add"));
            put("", new Attribute().setMode(MODE_WORD).setText("background"));
            put("", new Attribute().setMode(MODE_WORD).setText("bounds"));
            put("", new Attribute().setMode(MODE_WORD).setText("paddedBounds"));
            put("", new Attribute().setMode(MODE_WORD).setText("arrow"));
            put("", new Attribute().setMode(MODE_WORD).setText("context_menu"));
            put("", new Attribute().setMode(MODE_WORD).setText("hand"));
            put("", new Attribute().setMode(MODE_WORD).setText("help"));
            put("", new Attribute().setMode(MODE_WORD).setText("wait"));
            put("", new Attribute().setMode(MODE_WORD).setText("cell"));
            put("", new Attribute().setMode(MODE_WORD).setText("crosshair"));
            put("", new Attribute().setMode(MODE_WORD).setText("text"));
            put("", new Attribute().setMode(MODE_WORD).setText("vertical_text"));
            put("", new Attribute().setMode(MODE_WORD).setText("alias"));
            put("", new Attribute().setMode(MODE_WORD).setText("copy"));
            put("", new Attribute().setMode(MODE_WORD).setText("no_drop"));
            put("", new Attribute().setMode(MODE_WORD).setText("all_scroll"));
            put("", new Attribute().setMode(MODE_WORD).setText("horizontal_double_arrow"));
            put("", new Attribute().setMode(MODE_WORD).setText("vertical_double_arrow"));
            put("", new Attribute().setMode(MODE_WORD).setText("top_right_diagonal_double_arrow"));
            put("", new Attribute().setMode(MODE_WORD).setText("top_left_diagonal_double_arrow"));
            put("", new Attribute().setMode(MODE_WORD).setText("zoom_in"));
            put("", new Attribute().setMode(MODE_WORD).setText("zoom_out"));
            put("", new Attribute().setMode(MODE_WORD).setText("grab"));
            put("", new Attribute().setMode(MODE_WORD).setText("grabbing"));
            put("", new Attribute().setMode(MODE_WORD).setText("beforeDescendants"));
            put("", new Attribute().setMode(MODE_WORD).setText("afterDescendants"));
            put("", new Attribute().setMode(MODE_WORD).setText("blocksDescendants"));
            put("", new Attribute().setMode(MODE_WORD).setText("clipBounds"));
            put("", new Attribute().setMode(MODE_WORD).setText("opticalBounds"));
            put("", new Attribute().setMode(MODE_WORD).setText("fill_parent"));
            put("", new Attribute().setMode(MODE_WORD).setText("match_parent"));
            put("", new Attribute().setMode(MODE_WORD).setText("disabled"));
            put("", new Attribute().setMode(MODE_WORD).setText("alwaysScroll"));
            put("", new Attribute().setMode(MODE_WORD).setText("singleChoice"));
            put("", new Attribute().setMode(MODE_WORD).setText("multipleChoice"));
            put("", new Attribute().setMode(MODE_WORD).setText("multipleChoiceModal"));
            put("", new Attribute().setMode(MODE_WORD).setText("midpoint"));
            put("", new Attribute().setMode(MODE_WORD).setText("inside"));
            put("", new Attribute().setMode(MODE_WORD).setText("spacingWidth"));
            put("", new Attribute().setMode(MODE_WORD).setText("columnWidth"));
            put("", new Attribute().setMode(MODE_WORD).setText("spacingWidthUniform"));
            put("", new Attribute().setMode(MODE_WORD).setText("auto_fit"));
            put("", new Attribute().setMode(MODE_WORD).setText("matrix"));
            put("", new Attribute().setMode(MODE_WORD).setText("fitXY"));
            put("", new Attribute().setMode(MODE_WORD).setText("fitStart"));
            put("", new Attribute().setMode(MODE_WORD).setText("fitCenter"));
            put("", new Attribute().setMode(MODE_WORD).setText("fitEnd"));
            put("", new Attribute().setMode(MODE_WORD).setText("centerCrop"));
            put("", new Attribute().setMode(MODE_WORD).setText("centerInside"));
            put("", new Attribute().setMode(MODE_WORD).setText("repeat"));
            put("", new Attribute().setMode(MODE_WORD).setText("cycle"));
            put("", new Attribute().setMode(MODE_WORD).setText("spannable"));
            put("", new Attribute().setMode(MODE_WORD).setText("editable"));
            put("", new Attribute().setMode(MODE_WORD).setText("sentences"));
            put("", new Attribute().setMode(MODE_WORD).setText("words"));
            put("", new Attribute().setMode(MODE_WORD).setText("characters"));
            put("", new Attribute().setMode(MODE_WORD).setText("marquee_forever"));
            put("", new Attribute().setMode(MODE_WORD).setText("simple"));
            put("", new Attribute().setMode(MODE_WORD).setText("high_quality"));
            put("", new Attribute().setMode(MODE_WORD).setText("balanced"));
            put("", new Attribute().setMode(MODE_WORD).setText("full"));
            put("", new Attribute().setMode(MODE_WORD).setText("uniform"));
            put("", new Attribute().setMode(MODE_WORD).setText("inter_word"));
            put("", new Attribute().setMode(MODE_WORD).setText("dialog"));
            put("", new Attribute().setMode(MODE_WORD).setText("dropdown"));
            put("", new Attribute().setMode(MODE_WORD).setText("spinner"));
            put("", new Attribute().setMode(MODE_WORD).setText("calendar"));
            put("", new Attribute().setMode(MODE_WORD).setText("oneLine"));
            put("", new Attribute().setMode(MODE_WORD).setText("collapsing"));
            put("", new Attribute().setMode(MODE_WORD).setText("twoLine"));
            put("", new Attribute().setMode(MODE_WORD).setText("single"));
            put("", new Attribute().setMode(MODE_WORD).setText("multiple"));
            put("", new Attribute().setMode(MODE_WORD).setText("modeSmall"));
            put("", new Attribute().setMode(MODE_WORD).setText("modeMedium"));
            put("", new Attribute().setMode(MODE_WORD).setText("modeLarge"));
            put("", new Attribute().setMode(MODE_WORD).setText("holo"));
            put("", new Attribute().setMode(MODE_WORD).setText("material"));
            put("", new Attribute().setMode(MODE_WORD).setText("clock"));
            put("", new Attribute().setMode(MODE_WORD).setText("rectangle"));
            put("", new Attribute().setMode(MODE_WORD).setText("oval"));
            put("", new Attribute().setMode(MODE_WORD).setText("line"));
            put("", new Attribute().setMode(MODE_WORD).setText("ring"));
            put("", new Attribute().setMode(MODE_WORD).setText("linear"));
            put("", new Attribute().setMode(MODE_WORD).setText("radial"));
            put("", new Attribute().setMode(MODE_WORD).setText("sweep"));
            put("", new Attribute().setMode(MODE_WORD).setText("opaque"));
            put("", new Attribute().setMode(MODE_WORD).setText("transparent"));
            put("", new Attribute().setMode(MODE_WORD).setText("translucent"));
            put("", new Attribute().setMode(MODE_WORD).setText("nest"));
            put("", new Attribute().setMode(MODE_WORD).setText("stack"));
            put("", new Attribute().setMode(MODE_WORD).setText("clamp"));
            put("", new Attribute().setMode(MODE_WORD).setText("mirror"));
            put("", new Attribute().setMode(MODE_WORD).setText("butt"));
            put("", new Attribute().setMode(MODE_WORD).setText("round"));
            put("", new Attribute().setMode(MODE_WORD).setText("square"));
            put("", new Attribute().setMode(MODE_WORD).setText("miter"));
            put("", new Attribute().setMode(MODE_WORD).setText("bevel"));
            put("", new Attribute().setMode(MODE_WORD).setText("nonZero"));
            put("", new Attribute().setMode(MODE_WORD).setText("evenOdd"));
            put("", new Attribute().setMode(MODE_WORD).setText("infinite"));
            put("", new Attribute().setMode(MODE_WORD).setText("restart"));
            put("", new Attribute().setMode(MODE_WORD).setText("reverse"));
            put("", new Attribute().setMode(MODE_WORD).setText("top"));
            put("", new Attribute().setMode(MODE_WORD).setText("bottom"));
            put("", new Attribute().setMode(MODE_WORD).setText("random"));
            put("", new Attribute().setMode(MODE_WORD).setText("column"));
            put("", new Attribute().setMode(MODE_WORD).setText("row"));
            put("", new Attribute().setMode(MODE_WORD).setText("fade_in"));
            put("", new Attribute().setMode(MODE_WORD).setText("fade_out"));
            put("", new Attribute().setMode(MODE_WORD).setText("fade_in_out"));
            put("", new Attribute().setMode(MODE_WORD).setText("start"));
            put("", new Attribute().setMode(MODE_WORD).setText("end"));
            put("", new Attribute().setMode(MODE_WORD).setText("together"));
            put("", new Attribute().setMode(MODE_WORD).setText("sequential"));
            put("", new Attribute().setMode(MODE_WORD).setText("floatType"));
            put("", new Attribute().setMode(MODE_WORD).setText("intType"));
            put("", new Attribute().setMode(MODE_WORD).setText("pathType"));
            put("", new Attribute().setMode(MODE_WORD).setText("colorType"));
            put("", new Attribute().setMode(MODE_WORD).setText("sequentially"));
            put("", new Attribute().setMode(MODE_WORD).setText("container"));
            put("", new Attribute().setMode(MODE_WORD).setText("system"));
            put("", new Attribute().setMode(MODE_WORD).setText("secondary"));
            put("", new Attribute().setMode(MODE_WORD).setText("alternative"));
            put("", new Attribute().setMode(MODE_WORD).setText("all"));
            put("", new Attribute().setMode(MODE_WORD).setText("voice"));
            put("", new Attribute().setMode(MODE_WORD).setText("music"));
            put("", new Attribute().setMode(MODE_WORD).setText("alarm"));
            put("", new Attribute().setMode(MODE_WORD).setText("listMode"));
            put("", new Attribute().setMode(MODE_WORD).setText("tabMode"));
            put("", new Attribute().setMode(MODE_WORD).setText("liveAudio"));
            put("", new Attribute().setMode(MODE_WORD).setText("user"));
            put("", new Attribute().setMode(MODE_WORD).setText("hidden"));
            put("", new Attribute().setMode(MODE_WORD).setText("bool"));
            put("", new Attribute().setMode(MODE_WORD).setText("choice"));
            put("", new Attribute().setMode(MODE_WORD).setText("multi-select"));
            put("", new Attribute().setMode(MODE_WORD).setText("integer"));
            put("", new Attribute().setMode(MODE_WORD).setText("string"));
            put("", new Attribute().setMode(MODE_WORD).setText("bundle"));
            put("", new Attribute().setMode(MODE_WORD).setText("bundle_array"));
            put("", new Attribute().setMode(MODE_WORD).setText("italic"));
            put("", new Attribute().setMode(MODE_WORD).setText("surfaceView"));
            put("", new Attribute().setMode(MODE_WORD).setText("textureView"));
        }
    };
}
