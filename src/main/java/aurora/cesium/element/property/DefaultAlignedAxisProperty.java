package aurora.cesium.element.property;

import aurora.cesium.language.writer.*;

import java.util.List;
import java.util.Optional;

/**
 * @author hanhaoran
 * @date 2020/8/20
 */
public class DefaultAlignedAxisProperty extends PropertyAdapter<AlignedAxisProperty> implements AlignedAxisProperty {

    private UnitCartesianProperty unitCartesian;

    private UnitSphericalProperty unitSpherical;

    @Override
    public void dispatch(AlignedAxisCesiumWriter writer) {
        try (writer) {
            Optional.ofNullable(getUnitCartesian()).ifPresent(unitCartesianProperty -> unitCartesianProperty.dispatchUnitCartesian(writer));
            Optional.ofNullable(getUnitSpherical()).ifPresent(unitSphericalProperty -> unitSphericalProperty.dispatchUnitSpherical(writer));
            dispatchInterpolations(writer);
            dispatchInterval(writer, (intervalWriter, property) -> property.dispatch(intervalWriter));
            dispatchReference(writer);
        }
    }

    @Override
    public UnitCartesianProperty getUnitCartesian() {
        return unitCartesian;
    }

    public void setUnitCartesian(UnitCartesianProperty unitCartesian) {
        this.unitCartesian = unitCartesian;
    }

    @Override
    public UnitSphericalProperty getUnitSpherical() {
        return unitSpherical;
    }

    public void setUnitSpherical(UnitSphericalProperty unitSpherical) {
        this.unitSpherical = unitSpherical;
    }

    @Override
    public Interpolations getInterpolations() {
        return interpolations;
    }

    public void setInterpolations(Interpolations interpolations) {
        this.interpolations = interpolations;
    }

    @Override
    public TimeInterval getInterval() {
        return interval;
    }

    public void setInterval(TimeInterval interval) {
        this.interval = interval;
    }

    @Override
    public List<AlignedAxisProperty> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<AlignedAxisProperty> intervals) {
        this.intervals = intervals;
    }

    @Override
    public Reference getReference() {
        return reference;
    }

    public void setReference(Reference reference) {
        this.reference = reference;
    }

    public static final class Builder {
        protected Interpolations interpolations;
        protected TimeInterval interval;
        protected List<AlignedAxisProperty> intervals;
        protected Reference reference;
        private UnitCartesianProperty unitCartesian;
        private UnitSphericalProperty unitSpherical;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withUnitCartesian(UnitCartesianProperty unitCartesian) {
            this.unitCartesian = unitCartesian;
            return this;
        }

        public Builder withUnitSpherical(UnitSphericalProperty unitSpherical) {
            this.unitSpherical = unitSpherical;
            return this;
        }

        public Builder withInterpolations(Interpolations interpolations) {
            this.interpolations = interpolations;
            return this;
        }

        public Builder withInterval(TimeInterval interval) {
            this.interval = interval;
            return this;
        }

        public Builder withIntervals(List<AlignedAxisProperty> intervals) {
            this.intervals = intervals;
            return this;
        }

        public Builder withReference(Reference reference) {
            this.reference = reference;
            return this;
        }

        public DefaultAlignedAxisProperty build() {
            DefaultAlignedAxisProperty defaultAlignedAxisProperty = new DefaultAlignedAxisProperty();
            defaultAlignedAxisProperty.setUnitCartesian(unitCartesian);
            defaultAlignedAxisProperty.setUnitSpherical(unitSpherical);
            defaultAlignedAxisProperty.setInterpolations(interpolations);
            defaultAlignedAxisProperty.setInterval(interval);
            defaultAlignedAxisProperty.setIntervals(intervals);
            defaultAlignedAxisProperty.setReference(reference);
            return defaultAlignedAxisProperty;
        }
    }
}
