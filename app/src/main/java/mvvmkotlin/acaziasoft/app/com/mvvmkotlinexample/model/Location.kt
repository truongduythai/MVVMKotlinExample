package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model

import com.google.gson.annotations.SerializedName

data class Location(

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("street")
	val street: String? = null,

	@field:SerializedName("postcode")
	val postcode: String? = null,

	@field:SerializedName("state")
	val state: String? = null
)