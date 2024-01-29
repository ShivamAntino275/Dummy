package com.indigo.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.indigo.custom.networks.RetrofitClient
import com.indigo.custom.recycleradapter.DummyModel
import com.indigo.custom.recycleradapter.RecyclerAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ExtraView : ConstraintLayout {


    lateinit var rvContest:RecyclerView
    lateinit var rvContestPosition:RecyclerView

    val transactionAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_contest, true)
    val contestPositionAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_contest_position, true)


    // Constructors for creating the view programmatically
    constructor(context: Context) : super(context) {
        initialize(context, null)
    }

    // Constructors for inflating the view from XML
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initialize(context, attrs)
    }

    // Constructors for inflating the view from XML with a default style
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize(context, attrs)
    }

    private fun initialize(context: Context, attrs: AttributeSet?) {

        // Initialization logic here
        val view = LayoutInflater.from(context).inflate(R.layout.custom_constraint_layout, this, true)

         rvContest = view.findViewById<RecyclerView>(R.id.rvContest)
         rvContestPosition = view.findViewById<RecyclerView>(R.id.rvContestPosition)

        rvContest.adapter = transactionAdapter
        rvContestPosition.adapter = contestPositionAdapter

        fetchData(context)

        // Access attributes if needed
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.CustomConstraintLayout)
            // Access custom attributes using typedArray
            typedArray.recycle()
        }
    }

    fun setValue(context: Context) {
//        fetchData(context)
    }

    fun fetchData(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            var response = RetrofitClient.getApiService().callServer()
            if (response.isSuccessful){
                CoroutineScope(Dispatchers.Main).launch {

                    var data = response.body()
                    transactionAdapter.addItems(arrayListOf<DummyModel>().apply {
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                    })
                    contestPositionAdapter.addItems(arrayListOf<DummyModel>().apply {
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                        add(DummyModel())
                    })
                }
            }

        }
    }


}


