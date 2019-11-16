package com.example.firstproject.network


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.firstproject.network.GiphyApi
import com.example.firstproject.network.Gif
import com.example.firstproject.network.GifResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GifRepository {

    private val gifCall = GiphyApi.create()
    fun getGif():LiveData<Gif>{
        val gif = MutableLiveData<Gif>()
        gifCall.getRandomGif(
            tag = "Universe",
            apiKey = "DrwcnZf7UjtkLTJB0FTLmY94GAJwiNEd"
        ).enqueue(object :Callback<GifResponse> {
            override fun onResponse(call: Call<GifResponse>, response: Response<GifResponse>) {
                gif.value = response.body()?.data
            }
            override fun onFailure(call: Call<GifResponse>, t: Throwable) {
            }
        })
        return gif
    }
}