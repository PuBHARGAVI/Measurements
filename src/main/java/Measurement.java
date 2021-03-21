
public abstract class Measurement<T extends Measurement> {
    public double dimension;
    final Unit unit;

    public Measurement(double dimension, Unit unit) {
        double dimensionInSIunits = unit.dimensionInSIunits(dimension);
        if ((dimensionInSIunits <= 0 && !(unit instanceof UnitOfTemperature)) || (dimensionInSIunits < 0 && unit instanceof UnitOfTemperature))
            throw new IllegalArgumentException();
        this.dimension = dimension;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        T measurement = (T) object;

        return this.unit.dimensionInSIunits(dimension) == measurement.unit.dimensionInSIunits(measurement.dimension);
    }

}
