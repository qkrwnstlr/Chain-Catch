package com.dtd.chaincatch.drawing.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dtd.chaincatch.databinding.FragmentDrawingBinding
import com.raed.rasmview.brushtool.data.Brush
import com.raed.rasmview.brushtool.data.BrushesRepository
import com.raed.rasmview.state.RasmState

class DrawingFragment : Fragment() {

  private var _binding: FragmentDrawingBinding? = null
  private val binding: FragmentDrawingBinding
    get() = _binding!!

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentDrawingBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val rasmContext = binding.drawingView.rasmContext

    // brush
    val brushesRepository = BrushesRepository(resources)
    rasmContext.brushConfig = brushesRepository.get(Brush.Marker)
    rasmContext.brushColor = Color.RED
//    rasmContext.brushColor = 0xff2187bb.toInt() //ARGB

    val rasmState: RasmState = rasmContext.state

    binding.undo.setOnClickListener {
      rasmState.undo()
    }
    binding.redo.setOnClickListener {
      rasmState.redo()
    }
    rasmState.addOnStateChangedListener {
      binding.undo.isEnabled = rasmState.canCallUndo()
      binding.redo.isEnabled = rasmState.canCallRedo()
    }
    binding.undo.isEnabled = rasmState.canCallUndo()
    binding.redo.isEnabled = rasmState.canCallRedo()
  }

}