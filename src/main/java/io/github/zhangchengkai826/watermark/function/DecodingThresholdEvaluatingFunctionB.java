package io.github.zhangchengkai826.watermark.function;

import java.util.List;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class DecodingThresholdEvaluatingFunctionB extends DecodingThresholdEvaluatingFunction {
    @Override
    public double apply(List<Double> minValues, List<Double> maxValues) {
        SummaryStatistics ss = new SummaryStatistics();
        for (double x : minValues)
            ss.addValue(x);
        final double mean0 = ss.getMean();

        ss.clear();
        for (double x : maxValues)
            ss.addValue(x);
        final double mean1 = ss.getMean();

        double threshold = (mean0 + mean1) / 2;
        debugCheckThresholdQuality(minValues, maxValues, threshold);
        return threshold;
    }
}