package ru.project.monumentsOfBrazil.data.repository

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface DownloadService {
    @GET
    fun downloadGeoPackage(@Url url: String): Call<ResponseBody>
}