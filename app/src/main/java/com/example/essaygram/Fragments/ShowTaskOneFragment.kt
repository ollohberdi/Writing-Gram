package com.example.essaygram.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.essaygram.databinding.FragmentShowTaskOneBinding
import com.example.essaygram.item.ObjectTaskOne
import com.example.essaygram.model.TaskOne

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShowTaskOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShowTaskOneFragment : Fragment() {

    lateinit var binding: FragmentShowTaskOneBinding
    lateinit var taskOne: TaskOne

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
        binding = FragmentShowTaskOneBinding.inflate(layoutInflater)

        taskOne = ObjectTaskOne.taskOne

        var question = taskOne.question
        var questionImage = taskOne.questionImage
        var essay = "${taskOne.essay} \n\nBand Score: ${taskOne.bandScore} by ${taskOne.author}"


        binding.questionImage.load(questionImage)
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
         * @return A new instance of fragment ShowTaskOneFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShowTaskOneFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}