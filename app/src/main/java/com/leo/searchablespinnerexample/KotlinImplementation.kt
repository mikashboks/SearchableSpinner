package com.leo.searchablespinnerexample

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.leo.searchablespinner.SearchableSpinner
import com.leo.searchablespinner.interfaces.OnItemSelectListener
import com.leo.searchablespinnerexample.databinding.SearchableSpinnerImplementationBinding

class KotlinImplementation : AppCompatActivity() {

    var isTextInputLayoutClicked: Boolean = false
    private lateinit var searchableSpinnerBinding : SearchableSpinnerImplementationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchableSpinnerBinding = SearchableSpinnerImplementationBinding.inflate(
            LayoutInflater.from(this), null, false
        )
        setContentView(searchableSpinnerBinding.root)
        val searchableSpinner = SearchableSpinner(this)
        searchableSpinner.windowTitle = "SEARCHABLE SPINNER"
        searchableSpinner.onItemSelectListener = object : OnItemSelectListener {
            override fun setOnItemSelectListener(position: Int, selectedString: String) {
                Toast.makeText(
                    this@KotlinImplementation,
                    "${searchableSpinner.selectedItem}  ${searchableSpinner.selectedItemPosition}",
                    Toast.LENGTH_SHORT
                ).show()
                if (isTextInputLayoutClicked)
                    searchableSpinnerBinding.textInputSpinner.editText?.setText(selectedString)
                else
                    searchableSpinnerBinding.editTextSpinner.setText(selectedString)
            }
        }

        //Setting Visibility for views in SearchableSpinner
//        searchableSpinner.searchViewVisibility = SearchableSpinner.SpinnerView.GONE
//        searchableSpinner.negativeButtonVisibility = SearchableSpinner.SpinnerView.GONE
//        searchableSpinner.windowTitleVisibility = SearchableSpinner.SpinnerView.GONE

        val androidVersionList = arrayListOf(
            "Cupcake",
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow",
            "Nougat",
            "10"
        )

        searchableSpinner.setSpinnerListItems(androidVersionList)
        searchableSpinnerBinding.textInputSpinner.editText?.keyListener = null
        searchableSpinnerBinding.textInputSpinner.editText?.setOnClickListener {
            isTextInputLayoutClicked = true
            searchableSpinner.show()
        }

        searchableSpinnerBinding.editTextSpinner.keyListener = null
        searchableSpinnerBinding.editTextSpinner.setOnClickListener {
            searchableSpinner.highlightSelectedItem = false
            isTextInputLayoutClicked = false
            searchableSpinner.show()
        }
    }
}
