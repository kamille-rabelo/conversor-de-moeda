package br.com.one.conversordemoedas.modelos;

import com.google.gson.annotations.SerializedName;

public record ValorConversao(@SerializedName("conversion_result") double conversionResult) {
}
