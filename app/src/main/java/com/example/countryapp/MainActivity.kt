package com.example.countryapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.countryapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    companion object {
        var CountryList = ArrayList<CountryModal>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiinterface = ApiClient.getApiClient().create(ApiInterface::class.java)
        apiinterface.getcountry().enqueue(object : Callback<List<CountryModal>> {
            override fun onResponse(
                call: Call<List<CountryModal>>,
                response: Response<List<CountryModal>>
            ) {

                CountryList = response.body() as ArrayList<CountryModal>

                if (response.isSuccessful) {
                    var clickItem = object : CountryClick {
                        override fun onTap(i: Int) {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    Country_Detail::class.java
                                ).putExtra("pos", i)
                            )
                        }
                    }

                    binding.RcvCountry.layoutManager = GridLayoutManager(this@MainActivity, 2)
                    binding.RcvCountry.adapter = CountryAdapter(CountryList, clickItem )

                }

            }

            override fun onFailure(call: Call<List<CountryModal>>, t: Throwable) {

            }

        })
    }
}