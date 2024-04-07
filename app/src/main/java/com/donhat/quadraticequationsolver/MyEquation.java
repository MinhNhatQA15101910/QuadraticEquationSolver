package com.donhat.quadraticequationsolver;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.donhat.quadraticequationsolver.databinding.ActivityMainBinding;

public class MyEquation extends BaseObservable {
    private String a;
    private String b;
    private String c;
    private final ActivityMainBinding binding;

    public MyEquation(ActivityMainBinding binding) {
        this.binding = binding;
    }

    @Bindable
    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void solveEquation(View view) {
        double aValue = Double.parseDouble(getA());
        double bValue = Double.parseDouble(getB());
        double cValue = Double.parseDouble(getC());

        double discriminant = bValue * bValue - 4 * aValue * cValue;

        if (discriminant > 0) {
            double x1 = (-bValue + Math.sqrt(discriminant)) / (2 * aValue);
            double x2 = (-bValue - Math.sqrt(discriminant)) / (2 * aValue);

            binding.resultTextView.setText("x1 = " + x1 + ", x2 = " + x2);
        } else if (discriminant == 0) {
            double x = -bValue / (2 * aValue);

            binding.resultTextView.setText("x = " + x);
        } else {
            binding.resultTextView.setText("No real roots (complex roots)");
        }
    }
}
