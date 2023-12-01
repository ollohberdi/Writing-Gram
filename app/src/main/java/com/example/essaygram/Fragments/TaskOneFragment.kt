package com.example.essaygram.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.essaygram.R
import com.example.essaygram.adapter.EssaysOneAdapter
import com.example.essaygram.databinding.FragmentTaskTwoBinding
import com.example.essaygram.item.ObjectTaskOne
import com.example.essaygram.model.TaskOne
import com.google.firebase.firestore.FirebaseFirestore


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TaskOneFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TaskOneFragment : Fragment() {

    lateinit var binding: FragmentTaskTwoBinding
    lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var list: ArrayList<TaskOne>

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

        firebaseFirestore.collection("TaskOne").get().addOnCompleteListener {
            if (it.isSuccessful) {
                list = ArrayList()
                var result = it.result

                result?.forEach { queryDocumentSnapshot ->
                    var taskOne = queryDocumentSnapshot.toObject(TaskOne::class.java)
                    list.add(taskOne)
                }
                var adapter = EssaysOneAdapter(list, object : EssaysOneAdapter.OnClickOne {
                    override fun click(taskOne: TaskOne, position: Int) {
                        ObjectTaskOne.taskOne = taskOne
                        findNavController().navigate(R.id.showTaskOneFragment)
                    }

                })
                binding.rv2.adapter = adapter
            }
        }



        return binding.root
    }

}