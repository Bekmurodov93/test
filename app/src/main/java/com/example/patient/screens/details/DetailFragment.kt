package com.example.patient.screens.details


import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.example.patient.R
import com.example.patient.databinding.DetailFragmentBinding
import com.example.patient.repositories.register.Form2
import com.example.patient.repositories.register.RegisterModel
import com.example.patient.screens.MainActivity
import com.example.patient.utils.base.BaseFragment

class DetailFragment : BaseFragment<DetailFragmentBinding, DetailViewModel>() {
    override fun getViewModelClass() = DetailViewModel::class.java

    override fun getViewBinding() = DetailFragmentBinding.inflate(layoutInflater)

    override fun setUpViews() {
        super.setUpViews()
        (activity as MainActivity).setSupportActionBar(binding.toolbar)
        binding.toolbar.title=""
        val arg = arguments?.get("reg")
        arg?.let {
            val register = arg as RegisterModel
            binding.addressText.text=register.address
            binding.passportText.text=register.passport
            binding.fioText.text=register.fio
            binding.phoneText.text=register.phone
            binding.dateText.text=register.birthdate
            binding.idLabel.text=register.id.toString()
            binding.registeredPLace.setOnClickListener {
                navigate(R.id.action_toRegisterFragment)
            }
            val bundle= bundleOf()
            bundle.getString("code",register.code)
            binding.emergencyPLace.setOnClickListener {
                navigate(R.id.action_toEmergencyFragment)
            }
            binding.reversePLace.setOnClickListener {
                navigate(R.id.action_toReverseRegisterFragment)
            }
            binding.registeredBeforeBirthPLace.setOnClickListener {
                val form=Form2()

                bundle.putParcelable("form",form)
                navigate(R.id.action_toBeforeBirthRegisterFragment)
            }
            binding.deathPLace.setOnClickListener {
                navigate(R.id.action_toRegisterDeathFragment)
            }
        }


    }
    private fun navigate(id:Int,bundle: Bundle= bundleOf()) {
        Navigation.findNavController(requireView()).navigate(id,bundle)
    }

}