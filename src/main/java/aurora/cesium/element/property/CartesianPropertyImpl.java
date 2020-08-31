package aurora.cesium.element.property;

import aurora.cesium.language.writer.*;
import aurora.cesium.language.writer.advanced.ICesiumCartesian3ValuePropertyWriter;

import java.util.List;
import java.util.function.Supplier;

/**
 * @author hanhaoran
 * @date 2020/8/21
 */
public class CartesianPropertyImpl extends SingleTimeBasedPropertyAdapter<Cartesian, CartesianProperty> implements CartesianProperty {

    @Override
    public void dispatchWithoutClose(ICesiumCartesian3ValuePropertyWriter writer) {
        dispatchConsumer(writer::writeCartesian, writer::writeCartesian, writer::writeCartesian);
    }

    public static final class Builder {
        protected List<JulianDate> dates;
        protected List<Cartesian> values;
        protected Integer startIndex;
        protected Integer length;
        protected Cartesian value;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder withValues(List<JulianDate> dates, List<Cartesian> values) {
            this.dates = dates;
            this.values = values;
            return this;
        }

        public Builder withValues(List<JulianDate> dates, List<Cartesian> values, Integer startIndex, Integer length) {
            this.dates = dates;
            this.values = values;
            this.startIndex = startIndex;
            this.length = length;
            return this;
        }

        public Builder withValue(Cartesian value) {
            this.value = value;
            return this;
        }

        public CartesianPropertyImpl build() {
            CartesianPropertyImpl cartesianPropertyImpl = new CartesianPropertyImpl();
            cartesianPropertyImpl.setDates(dates);
            cartesianPropertyImpl.setValues(values);
            cartesianPropertyImpl.setStartIndex(startIndex);
            cartesianPropertyImpl.setLength(length);
            cartesianPropertyImpl.setValue(value);
            return cartesianPropertyImpl;
        }
    }
}