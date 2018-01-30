package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model

import com.google.gson.annotations.SerializedName

data class DataResponse(

	@field:SerializedName("results")
	val results: List<ResultsItem?>? = null,

	@field:SerializedName("info")
	val info: Info? = null
)