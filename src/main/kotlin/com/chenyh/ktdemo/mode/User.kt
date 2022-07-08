package com.chenyh.ktdemo.mode

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonProperty

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
data class User(
    @JsonProperty("named") var name: String,
    var age: Int,
) {

}
