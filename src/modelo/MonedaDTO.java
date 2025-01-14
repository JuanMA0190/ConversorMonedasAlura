package modelo;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record MonedaDTO(@SerializedName("base_code") String baseCode,
                        @SerializedName("conversion_rates") Map<String, Double> conversionRates) {

}
