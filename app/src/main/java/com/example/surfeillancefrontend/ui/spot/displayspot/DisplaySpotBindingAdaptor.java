package com.example.surfeillancefrontend.ui.spot.displayspot;

import android.widget.TextView;
import androidx.databinding.BindingAdapter;

import java.text.DecimalFormat;

public class DisplaySpotBindingAdaptor {

    @BindingAdapter("highTideHeight")
    public static void setHighTideHeight(TextView view, Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        view.setText(decimalFormat.format(value));
    }
    @BindingAdapter("lowTideHeight")
    public static void setlowTideHeight(TextView view, Double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        view.setText(decimalFormat.format(value));
    }
}
