package aurora.cesium.element.property;

import aurora.cesium.language.writer.*;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author hanhaoran
 * @date 2020/8/20
 */
class OrientationPropertyImpl extends SingleTimeBasedPropertyAdapter<UnitQuaternion, OrientationProperty> implements OrientationProperty {

    @Override
    public void dispatch(Supplier<OrientationCesiumWriter> supplier) {
        try (OrientationCesiumWriter writer = supplier.get()) {
            dispatchConsumer(writer::writeUnitQuaternion, writer::writeUnitQuaternion, writer::writeUnitQuaternion);

            dispatchDelete(writer);
            dispatchInterpolations(writer);
            dispatchInterval(writer, (intervalWriterSupplier, property) -> property.dispatch(intervalWriterSupplier));
            dispatchReference(writer);
        }
    }

    @Override
    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
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
    public List<OrientationProperty> getIntervals() {
        return intervals;
    }

    public void setIntervals(List<OrientationProperty> intervals) {
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
        private List<JulianDate> dates;
        private List<UnitQuaternion> values;
        private Integer startIndex;
        private Integer length;

        private UnitQuaternion value;

        private Boolean delete;
        private Interpolations interpolations;
        private TimeInterval interval;
        private List<OrientationProperty> intervals;
        private Reference reference;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withValue(UnitQuaternion value) {
            this.value = value;
            return this;
        }

        public Builder withValues(List<JulianDate> dates, List<UnitQuaternion> values) {
            this.dates = dates;
            this.values = values;
            return this;
        }

        public Builder withValues(List<JulianDate> dates, List<UnitQuaternion> values, Integer startIndex, Integer length) {
            this.dates = dates;
            this.values = values;
            this.startIndex = startIndex;
            this.length = length;
            return this;
        }

        public Builder withDelete(Boolean delete) {
            this.delete = delete;
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

        public Builder withIntervals(List<OrientationProperty> intervals) {
            this.intervals = intervals;
            return this;
        }

        public Builder withReference(Reference reference) {
            this.reference = reference;
            return this;
        }

        public OrientationPropertyImpl build() {
            OrientationPropertyImpl orientationPropertyImpl = new OrientationPropertyImpl();
            orientationPropertyImpl.setDates(dates);
            orientationPropertyImpl.setValues(values);
            orientationPropertyImpl.setStartIndex(startIndex);
            orientationPropertyImpl.setLength(length);
            orientationPropertyImpl.setValue(value);
            orientationPropertyImpl.setDelete(delete);
            orientationPropertyImpl.setInterpolations(interpolations);
            orientationPropertyImpl.setInterval(interval);
            orientationPropertyImpl.setIntervals(intervals);
            orientationPropertyImpl.setReference(reference);
            return orientationPropertyImpl;
        }
    }
}
