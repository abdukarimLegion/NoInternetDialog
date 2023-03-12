package com.naa.uz.nointernetdialog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.naa.uz.nointernetdialog.databinding.FragmentNoInternetDialogBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NoInternetDialogFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var _binding: FragmentNoInternetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoInternetDialogBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        binding.retry.setOnClickListener {
            if (onClick != null) {
                onClick?.onClick(binding.cancel.text.toString())
            }
            dismiss()
        }
        binding.cancel.setOnClickListener {
            if (onClick != null) {
                onClick?.onClick(binding.cancel.text.toString())
            }
            dismiss()
        }

        return binding.root
    }

    override fun getTheme(): Int  =R.style.RoundedCornersDialog

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NoInternetDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private var onClick: OnClick? = null

    interface OnClick {
        fun onClick(str: String)
    }

    fun setOnClick(onClick: OnClick) {
        this.onClick = onClick
    }

}