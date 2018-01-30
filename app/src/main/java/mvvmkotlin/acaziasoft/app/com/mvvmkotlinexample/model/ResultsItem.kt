package mvvmkotlin.acaziasoft.app.com.mvvmkotlinexample.model

import com.google.gson.annotations.SerializedName

data class ResultsItem(

	@field:SerializedName("nat")
	val nat: String? = null,

	@field:SerializedName("gender")
	val gender: String? = null,

	@field:SerializedName("phone")
	val phone: String? = null,

	@field:SerializedName("dob")
	val dob: String? = null,

	@field:SerializedName("name")
	val name: Name? = null,

	@field:SerializedName("registered")
	val registered: String? = null,

	@field:SerializedName("location")
	val location: Location? = null,

	@field:SerializedName("id")
	val id: Id? = null,

	@field:SerializedName("login")
	val login: Login? = null,

	@field:SerializedName("cell")
	val cell: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("picture")
	val picture: Picture? = null
)