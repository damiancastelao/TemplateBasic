package com.dam2.basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dam2.basic.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    // la necesitamos porque la anterior puede ser nula en diferentes hilos
    // esto ocurre asi, porque estamos dentro de un fragment y es mutable (var)

    // Propiedad no mutable val (es parecido a static)
    // Método abreviado de definicion de propiedad:
    // definimos la propiedad NO abreviadamente
    private val binding: FragmentFirstBinding
        // 'sobrescribimos' el get() para que devuelva _binding
        // no hace falta poner 'fun'
        get() {
            return _binding!!
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.textviewFirst
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}