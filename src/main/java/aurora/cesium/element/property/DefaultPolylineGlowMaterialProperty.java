package aurora.cesium.element.property;

import aurora.cesium.language.writer.PolylineGlowMaterialCesiumWriter;
import aurora.cesium.language.writer.TimeInterval;

import java.util.List;
import java.util.Optional;

/**
 * @author hanhaoran
 * @date 2020/8/28
 */
public class DefaultPolylineGlowMaterialProperty extends PropertyAdapter<PolylineGlowMaterialProperty> implements PolylineGlowMaterialProperty {

    private ColorProperty color;

    private DoubleProperty glowPower;

    private DoubleProperty taperPower;

    @Override
    public void dispatch(PolylineGlowMaterialCesiumWriter writer) {
        try (writer) {
            Optional.ofNullable(getColor()).ifPresent(colorProperty -> colorProperty.dispatch(writer.openColorProperty()));
            Optional.ofNullable(getGlowPower()).ifPresent(doubleProperty -> doubleProperty.dispatch(writer.openGlowPowerProperty()));
            Optional.ofNullable(getTaperPower()).ifPresent(doubleProperty -> doubleProperty.dispatch(writer.openTaperPowerProperty()));
            dispatchInterval(writer, (intervalWriter, property) -> property.dispatch(intervalWriter));
        }
    }

    public ColorProperty getColor() {
        return color;
    }

    public void setColor(ColorProperty color) {
        this.color = color;
    }

    public DoubleProperty getGlowPower() {
        return glowPower;
    }

    public void setGlowPower(DoubleProperty glowPower) {
        this.glowPower = glowPower;
    }

    public DoubleProperty getTaperPower() {
        return taperPower;
    }

    public void setTaperPower(DoubleProperty taperPower) {
        this.taperPower = taperPower;
    }

    public TimeInterval getInterval() {
        return interval;
    }

    public void setInterval(TimeInterval interval) {
        this.interval = interval;
    }

    public List<PolylineGlowMaterialProperty> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<PolylineGlowMaterialProperty> intervals) {
        this.intervals = intervals;
    }

    public static final class Builder {
        private ColorProperty color;
        private DoubleProperty glowPower;
        private DoubleProperty taperPower;

        protected TimeInterval interval;
        protected List<PolylineGlowMaterialProperty> intervals;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withColor(ColorProperty color) {
            this.color = color;
            return this;
        }

        public Builder withGlowPower(DoubleProperty glowPower) {
            this.glowPower = glowPower;
            return this;
        }

        public Builder withTaperPower(DoubleProperty taperPower) {
            this.taperPower = taperPower;
            return this;
        }

        public Builder withInterval(TimeInterval interval) {
            this.interval = interval;
            return this;
        }

        public Builder withIntervals(List<PolylineGlowMaterialProperty> intervals) {
            this.intervals = intervals;
            return this;
        }

        public DefaultPolylineGlowMaterialProperty build() {
            DefaultPolylineGlowMaterialProperty defaultPolylineGlowMaterialProperty = new DefaultPolylineGlowMaterialProperty();
            defaultPolylineGlowMaterialProperty.setColor(color);
            defaultPolylineGlowMaterialProperty.setGlowPower(glowPower);
            defaultPolylineGlowMaterialProperty.setTaperPower(taperPower);
            defaultPolylineGlowMaterialProperty.setInterval(interval);
            defaultPolylineGlowMaterialProperty.setIntervals(intervals);
            return defaultPolylineGlowMaterialProperty;
        }
    }
}