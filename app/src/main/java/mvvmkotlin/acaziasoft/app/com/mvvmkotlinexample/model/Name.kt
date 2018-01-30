package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model

import com.google.gson.annotations.SerializedName

data class Name(

	@field:SerializedName("last")
	val last: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("first")
	val first: String? = null
)