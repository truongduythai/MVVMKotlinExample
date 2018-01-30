package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model

import com.google.gson.annotations.SerializedName

data class Id(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("value")
	val value: String? = null
)