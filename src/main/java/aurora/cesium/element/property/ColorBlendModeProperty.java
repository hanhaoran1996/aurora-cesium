package aurora.cesium.element.property;

import aurora.cesium.language.writer.ColorBlendModeCesiumWriter;

/**
 * @author hanhaoran
 * @date 2020/8/23
 */
public interface ColorBlendModeProperty extends Property, ReferenceProperty {

    static DefaultColorBlendModeProperty.Builder newBuilder() {
        return DefaultColorBlendModeProperty.Builder.newBuilder();
    }

    void dispatch(ColorBlendModeCesiumWriter writer);
}
