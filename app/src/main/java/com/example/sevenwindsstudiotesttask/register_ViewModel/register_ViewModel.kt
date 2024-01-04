//package com.example.sevenwindsstudiotesttask.register_ViewModel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.example.sevenwindsstudiotesttask.model.ModelRegister
//import com.example.sevenwindsstudiotesttask.model.RegisterRequest
//import com.example.sevenwindsstudiotesttask.network.loginInterface
//import com.example.sevenwindsstudiotesttask.network.retroInstance
//import retrofit2.Call
//import retrofit2.Response
//
//class register_ViewModel:ViewModel() {
//    var liveData : MutableLiveData<ModelRegister> = MutableLiveData()
//
//    fun getRegister():MutableLiveData<ModelRegister>{
//        return liveData
//    }
//
//
//    fun makeApicall(toString: RegisterRequest) {
//        val retroInstance = retroInstance().getRetroInstance()
//        val retroservice = retroInstance.create(loginInterface::class.java)
//        val call = retroservice.getRegister()
//        call.enqueue(object :retrofit2.Callback<ModelRegister>{
//            override fun onResponse(call: Call<List<ModelRegister>>, response: Response<ModelRegister>) {
//
//                liveData.postValue(response.body())
//            }
//
//            override fun onFailure(call: Call<List<ModelRegister>>, t: Throwable) {
//                liveData.postValue(null)
//
//            }
//
//        } )
//    }
//
//}
//
//
//
