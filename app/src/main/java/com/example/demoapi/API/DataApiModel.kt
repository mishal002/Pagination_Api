package com.example.demoapi.API

import com.google.gson.annotations.SerializedName

data class DataApiModel(

	@field:SerializedName("DataApiModel")
	val dataApiModel: List<DataApiModelItem?>? = null
)

data class DataApiModelItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("postId")
	val postId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
