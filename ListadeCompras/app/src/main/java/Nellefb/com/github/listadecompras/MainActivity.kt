package Nellefb.com.github.listadecompras

import Nellefb.com.github.listadecompras.adapter.ItemsAdapter
import Nellefb.com.github.listadecompras.model.ItemModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import Nellefb.com.github.listadecompras.ui.theme.ListaDeComprasTheme
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView);
        val itemsAdapter = ItemsAdapter()
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {

//            p/ não deixar campo em branco
            if (editText.text.isEmpty()) {
            editText.error = "Preencha um valor"
            return@setOnClickListener
//                volta no estado q estava
        }
            val item = ItemModel(
//                to string  pq devolve objeto
                name = editText.text.toString(),
                onRemove = {
                    itemsAdapter.removeItem(it)
                }
            )

            itemsAdapter.addItem(item)
            editText.text.clear()
        }
    }
}