package com.example.essaygram.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.essaygram.R
import com.example.essaygram.databinding.FragmentShowTaskTwoBinding
import com.example.essaygram.databinding.FragmentTaskTwoBinding
import com.example.essaygram.item.ObjectTaskTwo
import com.example.essaygram.model.TaskOne
import com.example.essaygram.model.TaskTwo

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowTaskTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowTaskTwoFragment : Fragment() {
    lateinit var binding: FragmentShowTaskTwoBinding
    lateinit var taskTwo: TaskTwo

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        binding = FragmentShowTaskTwoBinding.inflate(layoutInflater)

        taskTwo = ObjectTaskTwo.taskTwo

        var question = taskTwo.question
        var essay = "${taskTwo.essay!!} \n\nBand Score: ${taskTwo.bandScore} by ${taskTwo.author}"

        binding.tvQuestion.text = question
        binding.tvEssayAB.text = essay

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ShowTaskTwoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShowTaskTwoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}