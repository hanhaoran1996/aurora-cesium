package aurora.cesium.element.graphics;

import aurora.cesium.element.property.*;
import aurora.cesium.language.writer.PolygonCesiumWriter;
import aurora.cesium.language.writer.TimeInterval;

import java.util.List;

/**
 * @author hanhaoran
 * @date 2020/8/20
 */
public interface PolygonGraphics extends Graphics<PolygonGraphics, PolygonCesiumWriter> {

    static PolygonGraphicsAdapter.Builder newBuilder() {
        return PolygonGraphicsAdapter.Builder.newBuilder();
    }

    /**
     * Gets or sets the {@link aurora.cesium.language.writer.CesiumArcType} Property specifying the type of lines the polygon edges use.
     */
    ArcTypeProperty getArcType();

    /**
     * Gets or sets a boolean specifying whether or not the top of an extruded polygon is included.
     */
    BooleanProperty getCloseTop();

    /**
     * Gets or sets a boolean specifying whether or not the bottom of an extruded polygon is included.
     */
    BooleanProperty getCloseBottom();

    ClassificationTypeProperty getClassificationType();

    DistanceDisplayConditionProperty getDistanceDisplayCondition();

    DoubleProperty getExtrudedHeight();

    HeightReferenceProperty getExtrudedHeightReference();

    BooleanProperty getFill();

    /**
     * Gets or sets the numeric Property specifying the angular distance between points on the polygon.
     */
    DoubleProperty getGranularity();

    DoubleProperty getHeight();

    HeightReferenceProperty getHeightReference();

    MaterialProperty getMaterial();

    BooleanProperty getOutline();

    ColorProperty getOutlineColor();

    DoubleProperty getOutlineWidth();

    /**
     * Gets or sets the boolean specifying whether or not the the height of each position is used.
     * If true, the shape will have non-uniform altitude defined by the height of each {@link ?} position.
     * If false, the shape will have a constant altitude as specified by {@link PolygonGraphics#getHeight()}.
     */
    BooleanProperty getPerPositionHeight();

    PositionListProperty getPositions();

    ShadowModeProperty getShadows();

    @Override
    BooleanProperty getShow();

    DoubleProperty getStRotation();

    IntegerProperty getZIndex();

    @Override
    TimeInterval getInterval();

    @Override
    List<PolygonGraphics> getIntervals();

    @Override
    void dispatch(PolygonCesiumWriter writer);
}
