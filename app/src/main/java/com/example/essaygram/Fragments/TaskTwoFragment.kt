package com.example.essaygram.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.essaygram.R
import com.example.essaygram.adapter.EssayTwoAdapter
import com.example.essaygram.databinding.FragmentTaskTwoBinding
import com.example.essaygram.item.ObjectTaskTwo
import com.example.essaygram.model.TaskTwo
import com.google.firebase.firestore.FirebaseFirestore


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TaskTwoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TaskTwoFragment : Fragment() {

    lateinit var binding: FragmentTaskTwoBinding
    lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var list: ArrayList<TaskTwo>

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
        binding = FragmentTaskTwoBinding.inflate(layoutInflater)

        firebaseFirestore = FirebaseFirestore.getInstance()


        firebaseFirestore.collection("TaskTwo").get().addOnCompleteListener {
            if (it.isSuccessful) {

                list = ArrayList()
                var result = it.result

                result?.forEach { queryDocumentSnapshot ->
                    var taskTwo = queryDocumentSnapshot.toObject(TaskTwo::class.java)
                    list.add(taskTwo)
                }
                var adapter = EssayTwoAdapter(list, object : EssayTwoAdapter.OnClickTwo {
                    @SuppressLint("SuspiciousIndentation")
                    override fun click(taskTwo: TaskTwo, position: Int) {

                      ObjectTaskTwo.taskTwo = taskTwo
                        findNavController().navigate(R.id.showTaskTwoFragment)

                    }

                })
                binding.rv2.adapter = adapter

            }
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TaskTwoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TaskTwoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}