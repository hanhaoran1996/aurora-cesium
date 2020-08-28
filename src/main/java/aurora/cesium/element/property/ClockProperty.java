package aurora.cesium.element.property;

import aurora.cesium.language.writer.*;

import java.util.List;

/**
 * @author hanhaoran
 * @date 2020/8/20
 */
public interface ClockProperty extends IntervalProperty<ClockProperty> {

    static DefaultClockProperty.Builder newBuilder() {
        return DefaultClockProperty.Builder.newBuilder();
    }

    JulianDate getCurrentTime();

    Double getMultiplier();

    ClockRange getRange();

    ClockStep getStep();

    @Override
    TimeInterval getInterval();

    @Override
    List<ClockProperty> getIntervals();

    void dispatch(ClockCesiumWriter writer);
}
